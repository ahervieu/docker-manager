package org.kevoree.docker.containerDriver.core.cgroupDriver;



import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aymeric on 01/12/14.
 */
public class NetworkDriver {


    private static void execCmd(String cmd)  {
        try {
        DataOutputStream os = null;

            Process p ;
        p = Runtime.getRuntime().exec("su");
        os = new DataOutputStream(p.getOutputStream());
         BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            os.writeBytes(cmd);
        os.flush();
        os.close();
            System.out.println("Exec " + cmd);
            String line = "";
            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void setIncomingTraffic(String bridge,  String traffic)
    {
        if(!bridge.isEmpty())
        {
            execCmd(" sudo tc qdisc del dev "+bridge+" root netem rate " + traffic +"kbit") ;
            if(!traffic.equals("-1")) {
            execCmd(" sudo tc qdisc add dev "+bridge+" root netem rate " + traffic +"kbit") ;
            }
        }

    }

    public static void setIncomingCorruptionRate( String bridge, int rate)
    {
        if(!bridge.isEmpty() )
    {
        execCmd(" sudo tc qdisc del dev "+bridge+" root netem corrupt " + rate+"%");
        if(rate != -1)  {
        execCmd(" sudo tc qdisc add dev "+bridge+" root netem corrupt " + rate+"%");
        }
    }
    }

    public static void setIncomingLossRate( String bridge, int rate)
    {
        if(!bridge.isEmpty())
        {
        execCmd(" sudo tc qdisc del dev "+bridge+" root netem loss " + rate+"%");
            if(rate != -1)  {
        execCmd(" sudo tc qdisc add dev "+bridge+" root netem loss " + rate+"%");
        }
        }
    }

    public static void setIncomingDelay( String bridge, int delay)
    {
        if(!bridge.isEmpty())
        {
            execCmd(" sudo tc qdisc del dev "+bridge+" root netem delay " + delay+"ms");
            if(delay != -1)  {
            execCmd(" sudo tc qdisc add dev "+bridge+" root netem delay " + delay+"ms");
         }
        }
    }

    public static void setOutgoingTraffic( String containerId,  String traffic)
    {
        if(!containerId.isEmpty())
        {
            execCmd(" sudo docker exec "+containerId+" tc qdisc del dev eth0 root netem rate " + traffic +"kbit");
            if(!traffic.equals("-1")) {
            execCmd(" sudo docker exec "+containerId+" tc qdisc all dev eth0 root netem rate " + traffic +"kbit") ;
        }
        }
    }

    public static void setOutgoingCorruptionRate( String containerId, int rate)
    {
        if(!containerId.isEmpty())
        {
        execCmd(" sudo docker exec "+containerId+" tc qdisc del dev eth0 root corrupt " + rate);
            if(rate != -1)  {
        execCmd(" sudo docker exec "+containerId+" tc qdisc all dev eth0 root corrupt " + rate);
        }
        }
    }

    public static void setOutgoingLossRate( String containerId, int rate)
    {
        if(!containerId.isEmpty())
        {
            execCmd(" sudo docker exec "+containerId+" tc qdisc del dev eth0 root loss " + rate);
            if(rate != -1)  {
            execCmd(" sudo docker exec "+containerId+" tc qdisc all dev eth0 root loss " + rate);
        }
        }
    }

    public static void setOutgoingDelay( String containerId, int delay)
    {
        if(!containerId.isEmpty())
        {
            execCmd(" sudo docker exec "+containerId+" tc qdisc del dev eth0 root delay " + delay+"ms");
            if(delay != -1)  {
            execCmd(" sudo docker exec "+containerId+" tc qdisc all dev eth0 root delay " + delay+"ms");
        }
        }
    }

    public static void addIpTableRule()
    {
        DataOutputStream os = null;
        String value = "";
        try {
            Process p ;
            p = Runtime.getRuntime().exec("su");
            os = new DataOutputStream(p.getOutputStream());
            os.writeBytes("iptables -I INPUT -i docker0 -p icmp -j LOG");
            os.flush();
            os.close();
        } catch (IOException e) {
            if(e.getMessage().contains("pipe"))
            {
                System.out.println("Please start the application as sudo");
            }
            e.printStackTrace();
        }
    }

    // http://stackoverflow.com/questions/21724225/docker-how-to-get-veth-bridge-interface-pair-easily

    public static String  getContainerBridge( String Ip)
    {
        String bridge = "";
        DataOutputStream os = null;
        String value = "";
        try {
            Process p = Runtime.getRuntime().exec("ping -c 1 "+Ip);
            BufferedReader readerIp = new BufferedReader(new InputStreamReader(p.getInputStream()));
            p.waitFor();

            Process p2 ;
            p2 = Runtime.getRuntime().exec("su");
            os = new DataOutputStream(p2.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            os.writeBytes("dmesg | grep " + Ip);
            os.flush();
            os.close();
            String line ="";
            Boolean stop = false ;
            while ((line = reader.readLine())!= null && !stop) {
                if(line.contains(Ip))
                {
                    stop = true ;
                    String pattern = "PHYSIN=([a-z,0-9]*) " ;
                    Pattern pat = Pattern.compile(pattern);
                    Matcher m = pat.matcher(line) ;
                    m.find();
                    bridge =m.group(1);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bridge ;


    }

}
