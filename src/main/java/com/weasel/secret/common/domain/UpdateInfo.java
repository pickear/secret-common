package com.weasel.secret.common.domain;

import java.io.Serializable;

/**
 * Created by dell on 2017/12/6.
 */
public class UpdateInfo implements Serializable {

    public UpdateInfo() {
    }

    public UpdateInfo(boolean hasUpdate, boolean force, float currentVesion,String url, String md5, long size) {
        this.hasUpdate = hasUpdate;
        this.force = force;
        this.currentVesion = currentVesion;
        this.url = url;
        this.md5 = md5;
        this.size = size;
    }

    private boolean hasUpdate;
    private boolean force;
    private float currentVesion;
    private String url;
    private String md5;
    private long size;

    public boolean isHasUpdate() {
        return hasUpdate;
    }

    public void setHasUpdate(boolean hasUpdate) {
        this.hasUpdate = hasUpdate;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    public float getCurrentVesion() {
        return currentVesion;
    }

    public void setCurrentVesion(float currentVesion) {
        this.currentVesion = currentVesion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
