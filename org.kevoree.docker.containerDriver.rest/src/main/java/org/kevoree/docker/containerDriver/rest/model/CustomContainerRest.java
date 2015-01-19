package org.kevoree.docker.containerDriver.rest.model;

import org.kevoree.docker.containerDriver.core.model.CustomContainerDetail;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by aymeric on 19/01/15.
 */

@XmlRootElement
public class CustomContainerRest {


    private String id ;
    private String name;

    private int incomingTraffic ;
    private int outgoingTraffic ;
    private int corruptionRate ;
    private int lossRate ;
    private int delayRate ;

    private String cpuNumber ;
    private int cpu_freq ;

    private String max_mem ;
    private String max_swap ;

    private int io_write_speed ;
    private int io_read_speed ;

    public CustomContainerRest() {
    }

    public CustomContainerRest(String id, int corruptionRate, int cpu_freq, String cpuNumber, int delayRate, int incomingTraffic, int io_read_speed, int io_write_speed, int lossRate, String max_mem, String max_swap, String name, int outgoingTraffic) {
        this.id = id;
        this.corruptionRate = corruptionRate;
        this.cpu_freq = cpu_freq;
        this.cpuNumber = cpuNumber;
        this.delayRate = delayRate;
        this.incomingTraffic = incomingTraffic;
        this.io_read_speed = io_read_speed;
        this.io_write_speed = io_write_speed;
        this.lossRate = lossRate;
        this.max_mem = max_mem;
        this.max_swap = max_swap;
        this.name = name;
        this.outgoingTraffic = outgoingTraffic;
    }

    public CustomContainerRest(CustomContainerDetail ccd)
    {
        id = ccd.getId();
        name = ccd.getName();
        incomingTraffic = ccd.getIncomingTraffic();
        outgoingTraffic = ccd.getOutgoingTraffic();
        corruptionRate = ccd.getCorruptionRate();
        lossRate = ccd.getLossRate();
        delayRate = ccd.getDelayRate();
        cpuNumber = ccd.getCpuNumber();
        cpu_freq = ccd.getCpu_freq();
        max_mem = ccd.getMax_mem();
        max_swap = ccd.getMax_swap();
        io_read_speed = ccd.getIo_write_speed();
        io_read_speed = ccd.getIo_read_speed();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncomingTraffic() {
        return incomingTraffic;
    }

    public void setIncomingTraffic(int incomingTraffic) {
        this.incomingTraffic = incomingTraffic;
    }

    public int getOutgoingTraffic() {
        return outgoingTraffic;
    }

    public void setOutgoingTraffic(int outgoingTraffic) {
        this.outgoingTraffic = outgoingTraffic;
    }

    public int getCorruptionRate() {
        return corruptionRate;
    }

    public void setCorruptionRate(int corruptionRate) {
        this.corruptionRate = corruptionRate;
    }

    public int getLossRate() {
        return lossRate;
    }

    public void setLossRate(int lossRate) {
        this.lossRate = lossRate;
    }

    public int getDelayRate() {
        return delayRate;
    }

    public void setDelayRate(int delayRate) {
        this.delayRate = delayRate;
    }

    public String getCpuNumber() {
        return cpuNumber;
    }

    public void setCpuNumber(String cpuNumber) {
        this.cpuNumber = cpuNumber;
    }

    public int getCpu_freq() {
        return cpu_freq;
    }

    public void setCpu_freq(int cpu_freq) {
        this.cpu_freq = cpu_freq;
    }

    public String getMax_mem() {
        return max_mem;
    }

    public void setMax_mem(String max_mem) {
        this.max_mem = max_mem;
    }

    public String getMax_swap() {
        return max_swap;
    }

    public void setMax_swap(String max_swap) {
        this.max_swap = max_swap;
    }

    public int getIo_write_speed() {
        return io_write_speed;
    }

    public void setIo_write_speed(int io_write_speed) {
        this.io_write_speed = io_write_speed;
    }

    public int getIo_read_speed() {
        return io_read_speed;
    }

    public void setIo_read_speed(int io_read_speed) {
        this.io_read_speed = io_read_speed;
    }

    @Override
    public String toString() {
        return "CustomContainerRest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", incomingTraffic=" + incomingTraffic +
                ", outgoingTraffic=" + outgoingTraffic +
                ", corruptionRate=" + corruptionRate +
                ", lossRate=" + lossRate +
                ", delayRate=" + delayRate +
                ", cpuNumber='" + cpuNumber + '\'' +
                ", cpu_freq=" + cpu_freq +
                ", max_mem='" + max_mem + '\'' +
                ", max_swap='" + max_swap + '\'' +
                ", io_write_speed=" + io_write_speed +
                ", io_read_speed=" + io_read_speed +
                '}';
    }



}
