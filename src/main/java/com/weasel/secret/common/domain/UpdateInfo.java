package com.weasel.secret.common.domain;

import java.io.Serializable;

/**
 * Created by dell on 2017/12/6.
 */
public class UpdateInfo implements Serializable {

    public UpdateInfo() {
    }

    public UpdateInfo(boolean hasUpdate, boolean force, float currentVesion,String description,String url, String md5, long size) {
        this.hasUpdate = hasUpdate;
        this.force = force;
        this.currentVesion = currentVesion;
        this.description = description;
        this.url = url;
        this.md5 = md5;
        this.size = size;
    }

    /**
     * 是否有更新
     */
    private boolean hasUpdate;
    /**
     * 是否强制更新
     */
    private boolean force;
    /**
     * 当前最新版本号
     */
    private float currentVesion;
    /**
     * 更新描述
     */
    private String description;
    /**
     * apk下载url
     */
    private String url;
    /**
     * apk md5值
     */
    private String md5;
    /**
     * apk 大小
     */
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
