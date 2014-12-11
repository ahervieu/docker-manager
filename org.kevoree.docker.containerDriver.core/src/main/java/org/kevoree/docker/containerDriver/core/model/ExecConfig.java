package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Arrays;

/**
 * Created by aymeric on 02/12/14.
 */
public class ExecConfig {

    @JsonProperty("AttachStdin")            private boolean attachStdin ;
    @JsonProperty("AttachStdout")           private boolean attachStdout ;
    @JsonProperty("AttachStderr")           private boolean attachStderr ;
    @JsonProperty("Tty")                    private boolean tty ;
    @JsonProperty("Cmd")                    private String[] cmd;
    @JsonProperty("Container")              private String container;

    public ExecConfig(boolean attachStderr, boolean attachStdin, boolean attachStdout, boolean tty, String[] cmd, String container) {
        this.attachStderr = attachStderr;
        this.attachStdin = attachStdin;
        this.attachStdout = attachStdout;
        this.tty = tty;
        this.cmd = cmd;
        this.container = container;
    }

    public boolean isAttachStdin() {
        return attachStdin;
    }

    public void setAttachStdin(boolean attachStdin) {
        this.attachStdin = attachStdin;
    }

    public boolean isAttachStdout() {
        return attachStdout;
    }

    public void setAttachStdout(boolean attachStdout) {
        this.attachStdout = attachStdout;
    }

    public boolean isAttachStderr() {
        return attachStderr;
    }

    public void setAttachStderr(boolean attachStderr) {
        this.attachStderr = attachStderr;
    }

    public boolean isTty() {
        return tty;
    }

    public void setTty(boolean tty) {
        this.tty = tty;
    }

    public String[] getCmd() {
        return cmd;
    }

    public void setCmd(String[] cmd) {
        this.cmd = cmd;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }


    @Override
    public String toString() {
        return "ExecConfig{" +
                "attachStdin=" + attachStdin +
                ", attachStdout=" + attachStdout +
                ", attachStderr=" + attachStderr +
                ", tty=" + tty +
                ", cmd=" + Arrays.toString(cmd) +
                ", container='" + container + '\'' +
                '}';
    }
}