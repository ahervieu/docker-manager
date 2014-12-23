package org.kevoree.docker.containerDriver.core.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.io.IOUtils;


import org.kevoree.docker.containerDriver.core.model.*;
import us.monoid.json.JSONArray;
import us.monoid.json.JSONException;
import us.monoid.web.BinaryResource;
import us.monoid.web.Content;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;

import java.io.*;
import java.util.List;

import static us.monoid.web.Resty.*;

/**
 * Created by leiko on 22/05/14.
 */
public class DockerClientImpl implements DockerClient {

    private static final int KILL_TIMEOUT = 15;

    private Resty resty;
    private String url;

    public DockerClientImpl(String url) {
        this.resty = new Resty();
        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 2);
        }
        this.url = url;
    }

    public DockerClientImpl() {
        this("http://localhost:2375");
    }


    @Override
    public void start(String id) throws DockerException, JSONException {
        this.start(id, null);
    }

    @Override
    public void start(String id, HostConfig conf) throws DockerException, JSONException {
        try {
            ObjectMapper mapper = build();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(baos);
            mapper.writeValue(osw, conf);

            this.resty.json(
                    this.url + String.format(DockerApi.START_CONTAINER, id),
                    new Content("application/json; charset=UTF-8", baos.toByteArray())
            );
        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }

    @Override
    public void stop(String id) throws DockerException {
        this.stop(id, KILL_TIMEOUT);
    }

    @Override
    public void stop(String id, int timeout) throws DockerException {
        try {
            this.resty.text(this.url + String.format(DockerApi.STOP_CONTAINER, id), form(String.format("t=%d", timeout)));
        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }

    @Override
    public InputStream attach(final String id, boolean logs, boolean stream, boolean stdin, boolean stdout, boolean stderr) throws DockerException, JSONException {
        try {
            final BinaryResource res = this.resty.bytes(
                    this.url + String.format(DockerApi.ATTACH_CONTAINER, id),
                    form(String.format("logs=%b&stream=%b&stdin=%b&stdout=%b&stderr=%b", logs, stream, stdin, stdout, stderr))
            );

            return res.stream();

        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }

    @Override
    public List<Image> getImages() throws DockerException, JSONException {
        return this.getImages(false, null);
    }

    @Override
    public List<Image> getImages(boolean all,  String filters) throws DockerException, JSONException {
        if (filters == null) {
            filters = "";
        }

        try {
            JSONArray res = this.resty.json(this.url + DockerApi.IMAGES_LIST + String.format("?all=%s&filters=%s", all, filters)).array();

            ObjectMapper mapper = build();
            return mapper.readValue(res.toString(), mapper.getTypeFactory().constructCollectionType(List.class, Image.class));

        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }

    @Override
    public List<Container> getContainers() throws DockerException, JSONException {
        try {
            JSONArray res = this.resty.json(this.url + DockerApi.CONTAINERS_LIST).array();

            ObjectMapper mapper = build();
            return mapper.readValue(res.toString(), mapper.getTypeFactory().constructCollectionType(List.class, Container.class));

        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }

    @Override
    public ContainerDetail getContainer(String idOrName) throws DockerException, JSONException {
        try {

            JSONResource res = this.resty.json(this.url + String.format(DockerApi.INSPECT_CONTAINER, idOrName));
            System.out.println(res.toObject().toString());
            ObjectMapper mapper = build();
            return mapper.readValue(res.toObject().toString(), ContainerDetail.class);

        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }

    @Override
    public void deleteContainer(String id) throws DockerException, JSONException {
        try {
            this.resty.json(this.url + String.format(DockerApi.DELETE_CONTAINER, id) + String.format("?force=%s", true), delete());
        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }

    @Override
    public ContainerInfo commit(CommitConfig conf) throws DockerException, JSONException {
        try {
            JSONResource res = this.resty.json(
                    this.url + DockerApi.COMMIT_IMAGE,
                    form(String.format("container=%s&m=%s&repo=%s&tag=%s&author=%s", conf.getContainer(), conf.getMessage(), conf.getRepo(), conf.getTag(), conf.getAuthor()))
            );

            ObjectMapper mapper = build();
            return mapper.readValue(res.toObject().toString(), ContainerInfo.class);

        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }

    @Override
    public void pull(String name) throws DockerException, JSONException {
        ImageConfig conf = new ImageConfig();
        conf.setFromImage(name);
        this.pull(conf);
    }

    @Override
    public void pull( ImageConfig conf) throws DockerException, JSONException {
        if (conf == null) {
            conf = new ImageConfig();
        }
        try {

            JSONResource res = this.resty.json(
                    this.url + DockerApi.CREATE_IMAGE,
                    form(String.format("fromImage=%s&fromSrc=%s&repo=%s&tag=%s&registry=%s", conf.getFromImage(), conf.getFromSrc(), conf.getRepo(), conf.getTag(), conf.getRegistry()))
            );

            StringWriter writer = new StringWriter();
            IOUtils.copy(res.getUrlConnection().getInputStream(), writer, "UTF-8");


        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }

    @Override
    public void push(String name, AuthConfig conf) throws DockerException, JSONException {
        this.push(name, null, conf);
    }

    @Override
    public void push(String name,  String tag, AuthConfig conf) throws DockerException, JSONException {
        if (tag == null || tag.length() == 0) {
            tag = "latest";
        }

        try {

            Resty authResty = new Resty();
            authResty.withHeader("X-Registry-Auth", Base64.encode(new ObjectMapper().writeValueAsString(conf).getBytes()));
            JSONResource res = authResty.json(
                    this.url + String.format(DockerApi.PUSH_IMAGE, name),
                    form(String.format("?tag=%s", tag))
            );

            StringWriter writer = new StringWriter();
            IOUtils.copy(res.getUrlConnection().getInputStream(), writer, "UTF-8");


        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }

    @Override
    public void createImage(ImageConfig conf) throws DockerException, JSONException {
        try {
            ObjectMapper mapper = build();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(baos);
            mapper.writeValue(osw, conf);

            JSONResource res = this.resty.json(this.url + DockerApi.CREATE_IMAGE, content(baos.toByteArray()));

            StringWriter writer = new StringWriter();
            IOUtils.copy(res.getUrlConnection().getInputStream(), writer, "UTF-8");

        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }

    @Override
    public List<ImageInfo> searchImage(String term) throws DockerException, JSONException {
        try {
            JSONArray res = this.resty.json(this.url + DockerApi.SEARCH_IMAGE + String.format("?term=%s", term)).array();

            ObjectMapper mapper = build();
            return mapper.readValue(res.toString(), mapper.getTypeFactory().constructCollectionType(List.class, ImageInfo.class));

        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }

    @Override
    public ContainerInfo createContainer(ContainerConfig conf) throws DockerException, JSONException {
        return this.createContainer(conf, "");
    }

    @Override
    public ContainerInfo createContainer(ContainerConfig conf,  String name) throws DockerException, JSONException {
        if (name != null && name.length() > 0 && !name.matches("/?[a-zA-Z0-9_-]+")) {
            throw new DockerException(String.format("Container name must match /?[a-zA-Z0-9_-]+ but '%s' does not", name));
        }

        try {
            ObjectMapper mapper = build();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(baos);
            mapper.writeValue(osw, conf);

            JSONResource res = this.resty.json(this.url + DockerApi.CREATE_CONTAINER + String.format("?name=%s", name), content(baos.toByteArray()));

            return mapper.readValue(res.toObject().toString(), ContainerInfo.class);

        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }


    public ObjectMapper build() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        return mapper;
    }

    @Override
    public void exec(String id, ExecConfig exec) throws DockerException, JSONException {
        try {
            ObjectMapper mapper = build();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(baos);
            mapper.writeValue(osw, exec);

            JSONResource res = this.resty.json(this.url + String.format(DockerApi.EXEC_CONTAINER, id), content(baos.toByteArray()));
            System.out.println(this.url + String.format(DockerApi.EXEC_CONTAINER, id));
            System.out.println(res.toObject().toString());
           // return mapper.readValue(res.toObject().toString(), ContainerInfo.class);

        } catch (IOException e) {
            throw new DockerException(e.getMessage());
        }
    }


}
