package com.weasel.secret.common.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**密码主体，如招行，淘宝
 * Created by Dylan on 2017/11/11.
 */
@Entity
@Table(name = "subject")
public class Subject implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;
    /**
     * 标题
     */
    @Column(name = "title",nullable = false)
    private String title;

    /**
     * 帐号
     */
    @Column(name = "account",nullable = true)
    private String account;
    /**
     * 主本地址，如http://www.taobao.com
     */
    @Column(name = "url",nullable = true)
    private String url;

    /**
     *创建时间
     */
    @Column(name = "create_time",nullable = false,updatable = false)
    @Access(value = AccessType.PROPERTY)
    private Long createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time",nullable = true)
    @Access(value = AccessType.PROPERTY)
    private Long updateTime;

    /**
     * 是否已删除
     */
    @Column(name = "deleted",nullable = true)
    private boolean deleted;

    @Column(name = "version",nullable = false)
    private int version;

    /**
     * 密码，如:
     * 支付密码:42234324
     * 登录密码:dsf24234234
     */
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private List<Secret> secrets;

    public Long getId() {
        return id;
    }

    public Subject setId(Long id) {
        this.id = id;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public Subject setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Subject setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUrl() {
        return url;
    }

    public Subject setUrl(String url) {
        this.url = url;
        return this;
    }

    public Long getCreateTime() {
        if(null == getId() && null == this.createTime){
            setCreateTime(System.currentTimeMillis());
        }
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        if(null == this.updateTime){
            setUpdateTime(System.currentTimeMillis());
        }
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Subject setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<Secret> getSecrets() {
        if(null == this.secrets){
            return new ArrayList<>();
        }
        return secrets;
    }

    public Subject setSecrets(List<Secret> secrets) {
        this.secrets = secrets;
        return this;
    }

    /**
     *
     * @param key
     * @throws Exception
     */
    public Subject entryptAllSecret(String key) throws Exception {
        for(Secret secret : getSecrets()){
            secret.entrypt(key);
        }
        return this;
    }

    /**
     *
     * @param key
     * @throws Exception
     */
    public Subject decryptAllSecret(String key) throws Exception {
        for(Secret secret : getSecrets()){
            secret.decrypt(key);
        }
        return this;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = (int) (PRIME * result + getId());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (null == o){
            return false;
        }
        if (!(o instanceof Subject)){
            return false;
        }

        if(null == this.getId() || null == ((Subject)o).getId()){
            return this == o;
        }
        return this.getId().longValue() == ((Subject)o).getId().longValue();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        buffer.append("id:").append(getId()).append(",")
              .append("title:").append(getTitle()).append(",")
              .append("url:").append(getUrl()).append(",")
              .append("secrets[");

        for(Secret secret : getSecrets()){
            buffer.append("{id:").append(secret.getId()).append(",")
                  .append("name:").append(secret.getName()).append(",")
                  .append("value:").append(secret.getValue()).append("}");
        }
        buffer.append("]}");
        return buffer.toString();
    }
}
