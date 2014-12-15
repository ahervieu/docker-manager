package org.kevoree.docker.containerDriver.core.model;



import org.kevoree.docker.containerDriver.core.StringParsingUtils;
import org.kevoree.docker.containerDriver.core.cgroupDriver.BlkioDriver;
import org.kevoree.docker.containerDriver.core.cgroupDriver.CPUDriver;
import org.kevoree.docker.containerDriver.core.cgroupDriver.MemoryDriver;
import org.kevoree.docker.containerDriver.core.cgroupDriver.NetworkDriver;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * Created by aymeric on 02/12/14.
 */
@XmlRootElement
public class CustomContainerDetail {

    @XmlTransient
    private ContainerDetail container ;

    private String bridge = "" ;

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


    public String getName() {
        return name;
    }

 /*   public void setName(String name) {
        this.name = name;
    }*/

    public String getCpuNumber() {
        return cpuNumber;
    }

    public void setCpuNumber(String cpuNumber) {
        CPUDriver.setCPUValue(this.getId(), cpuNumber);
        this.cpuNumber = cpuNumber;
    }

    public int getCpu_freq() {
        return cpu_freq;
    }

    public void setCpu_freq(int cpu_freq) {

        CPUDriver.setFreqValue(this.getId(),String.valueOf(cpu_freq));
        this.cpu_freq = cpu_freq;
    }

    public String getMax_mem() {

        return max_mem;
    }

    public void setMax_mem(String max_mem) {

        MemoryDriver.setMaxMemValue(this.getId(),max_mem );
        this.max_mem = max_mem;
    }

    public String getMax_swap() {
        return max_swap;
    }

    public void setMax_swap(String max_swap) {
        MemoryDriver.setSwapValue(this.getId(), max_swap);
        this.max_swap = max_swap;
    }

    public int getIo_write_speed() {
        return io_write_speed;
    }

    public void setIo_write_speed(int io_write_speed) {
        BlkioDriver.setWriteValue(this.getId(), String.valueOf(io_write_speed));
        this.io_write_speed = io_write_speed;
    }

    public int getIo_read_speed() {
        return io_read_speed;
    }

    public void setIo_read_speed(int io_read_speed) {
        BlkioDriver.setReadValue(this.getId(), String.valueOf(io_read_speed));
        this.io_read_speed = io_read_speed;
    }

    public String nameProperty() {
        return name;
    }

    public String getId(){
        return  id;
    }

   /* public void  setId(String _id){
          id =_id;
    }*/

    @XmlTransient
    public ContainerDetail getContainer() {
        return container;
    }

    public void setContainer(ContainerDetail container) {
        this.container = container;
    }

    public String getBridge() {
         return bridge;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge;
    }

    public int getIncomingTraffic() {

        return incomingTraffic;
    }

    public void setIncomingTraffic(int incomingTraffic) {

        NetworkDriver.setIncomingTraffic(this.getBridge(),incomingTraffic);
        this.incomingTraffic = incomingTraffic;
    }

    public int getOutgoingTraffic() {
        return outgoingTraffic;
    }

    public void setOutgoingTraffic(int outgoingTraffic) {

        NetworkDriver.setOutgoingTraffic(this.getBridge(), outgoingTraffic);
        this.outgoingTraffic = outgoingTraffic;
    }

    public int getCorruptionRate() {
        return corruptionRate;
    }

    public void setCorruptionRate(int corruptionRate) {
        NetworkDriver.setIncomingCorruptionRate(this.getBridge(), corruptionRate);
        this.corruptionRate = corruptionRate;
    }

    public int getLossRate() {
        return lossRate;
    }

    public void setLossRate(int lossRate) {
        NetworkDriver.setIncomingLossRate(this.getBridge(), lossRate);
        this.lossRate = lossRate;
    }

    public int getDelayRate() {
        return delayRate;
    }

    public void setDelayRate(int delayRate) {
        NetworkDriver.setIncomingDelay(this.getBridge(),delayRate);
        this.delayRate = delayRate;
    }

    public CustomContainerDetail(ContainerDetail container) {
        id = container.getId();

        name = container.getName();

        this.container = container ;
        incomingTraffic= -1;
        outgoingTraffic =-1;
        lossRate = -1;
        delayRate = -1 ;

    }

    public CustomContainerDetail() {
        id = "-1";

        name = "-1";

        this.container = null ;
        incomingTraffic= -1;
        outgoingTraffic =-1;
        lossRate = -1;
        delayRate = -1 ;

    }

    @Override
    public boolean equals( Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final CustomContainerDetail other = (CustomContainerDetail) obj;
        return (other.getContainer().getId().equals(this.getContainer().getId()));
    }

    @Override
    public String toString() {
        return "CustomContainerDetail{" +
                "container=" + container +
                ", bridge='" + bridge + '\'' +
                ", id='" + id + '\'' +
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


    public void updateCustomContainerDetail(CustomContainerDetail ccd_){
       this.setIncomingTraffic(ccd_.getIncomingTraffic());
       this.setOutgoingTraffic(ccd_.getOutgoingTraffic());
       this.setCorruptionRate(ccd_.getCorruptionRate());
       this.setLossRate(ccd_.getLossRate());
       this.setDelayRate(ccd_.getDelayRate());


       this.setCpuNumber(ccd_.getCpuNumber());
       this.setCpu_freq(ccd_.getCpu_freq());

       this.setIo_write_speed(ccd_.getIo_write_speed());
       this.setIo_read_speed(ccd_.getIo_read_speed());

       this.setMax_mem(ccd_.getMax_mem());
       this.setMax_swap(ccd_.getMax_swap());
    }
}
