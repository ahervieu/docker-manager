package kevoree;

import org.kevoree.annotation.*;

@ComponentType
@Library(name = "Java")
public class HelloWorld {

    @Param(defaultValue = "Default Content")
    String message;

    @KevoreeInject
    org.kevoree.api.Context context;

    @Output
    org.kevoree.api.Port out;

    @Input
    public String in(Object i) {
        String msg = message+" from "+context.getInstanceName()+"@"+context.getNodeName();
        System.out.println(msg);
        out.send(msg);
        return msg;
    }

    @Start
    public void start() {}

    @Stop
    public void stop() {}

    @Update
    public void update() {System.out.println("Param updated!");}

}



