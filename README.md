docker-manager
==============
# getting started
* activate rest server on docker
* mvn jfx:jar ; sudo java -jar target/jfx/app/org.kevoree.docker.containerdriver-jfx.jar
* start a container :
```
 sudo docker run --cap-add=NET_ADMIN -ti --cpuset=0 ahervieu/stress_diverse
```
Use refresh button to update container list !
