Warning : doc is deprecated. Todo : update it

docker-manager
==============
A small video of presentation is available here :https://www.youtube.com/watch?v=uKcJt3-17GY&feature=youtu.be
# getting started
* activate rest server on docker
* to build the jfx app in JavaFx project :
```
mvn jfx:jar ; sudo java -jar target/jfx/app/org.kevoree.docker.containerdriver-jfx.jar
```
* to start the rest server, in the rest project
```
sudo mvn exec:java
```

* start a container :
```
 sudo docker run --cap-add=NET_ADMIN -ti --cpuset=0 ahervieu/stress_diverse
```
Use refresh button to update container list !


##Playing with Rest API

```
http://localhost:8081/api/
http://localhost:8081/api/ID of the container
```

# How to test it :
## Testing CPU :
in the container :
```
stress --cpu 2
```
Open system monitor on your host, then change  values of numbers of cpu and frequency in the application and observe the load balancing.
You can put -1 value to remove frequency limitations

## Testing memory :
In the UI set a Max memory at 250m (=250Mo)
in the container :
```
stress--vm 2 --vm-bytes 250M
```
Docker container will try to consume 2*250Mo of memory. You can  observe the limitation at 250 in the resource monitor. Then put -1 and ovserve that the container then consumes 500 Mo.

## Testing Network :
In the container :
```
 time(wget http://www.obeo.fr/download/release/designer/6.2/latest/juno3/bundles/ObeoDesigner-6.2-linux.gtk.x86_64.zip)
```

Then add traffic limitation and observe variations.

## Testing IO :
In the container :
```
 time $(dd if=/dev/zero of=testfile0 bs=1000 count=100000 && sync)
 ```
##Start container todo : fix img name 
  ```
 sudo docker run \
   --volume=/:/rootfs:ro \
   --volume=/var/run:/var/run:rw \
   --volume=/sys:/sys:ro \
   --volume=/var/lib/docker/:/var/lib/docker:ro \
   --publish=8080:8080 \
   --detach=true \
   --name=dm \
   --net=host
 dockman
  ```

