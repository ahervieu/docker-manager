package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 *
 * @author expi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContainerState {

    @JsonProperty("Running")    private boolean running;
    @JsonProperty("Pid")        private int     pid;
    @JsonProperty("ExitCode")   private int     exitCode;
    @JsonProperty("StartedAt")  private String  startedAt;
    @JsonProperty("Restarting") private boolean restarting;
    @JsonProperty("FinishedAt") private String  finishedAt;
    @JsonProperty("Ghost")      private boolean ghost;
    @JsonProperty("Paused")     private boolean paused;

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getExitCode() {
        return exitCode;
    }

    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public boolean isRestarting() {
        return restarting;
    }

    public void setRestarting(boolean restarting) {
        this.restarting = restarting;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    public boolean isGhost() {
        return ghost;
    }

    public void setGhost(boolean ghost) {
        this.ghost = ghost;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }


    @Override
    public String toString() {
        return "ContainerState{" + "running=" + running + ", pid=" + pid + ", exitCode=" + exitCode + ", startedAt=" + startedAt + ", restarting="+restarting+", finishedAt=" + finishedAt + ", ghost=" + ghost + ", paused="+paused+"}";
    }

}
