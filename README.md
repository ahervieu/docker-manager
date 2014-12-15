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


