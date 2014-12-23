package kevoree;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.kevoree.annotation.*;

import java.net.URI;

@ComponentType
public class ContainerDriver {


    @Param(defaultValue = "http://localhost:8080/myapp/")
    public static final String BASE_URI = "http://localhost:8080/myapp/" ;


    @Param(defaultValue = "http://127.0.0.1:2375")
    public static final String restDocker = "http://127.0.0.1:2375" ;
    final HttpServer server = null;

    @Start
    public void start() {
        final HttpServer server = startServer();
    }

    @Stop
    public void stop() {server.stop();}

    @Update
    public void update() {System.out.println("Param updated!");}


    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example package
        final ResourceConfig rc = new ResourceConfig().packages("org.kevoree.docker.containerDriver.rest");
        rc.property("dockerRest", restDocker) ;
        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

}



