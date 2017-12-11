package com.weasel.secret.common.domain;

import javax.persistence.*;
import java.io.Serializable;
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
    private long userId;
    /**
     * 标题
     */
    @Column(name = "title",nullable = false)
    private String title;
    /**
     * 主本地址，如http://www.taobao.com
     */
    @Column(name = "url",nullable = true)
    private String url;

    /**
     *创建时间
     */
    @Column(name = "create_time",nullable = false)
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time",nullable = true)
    private Date updateTime;

    /**
     * 是否已删除
     */
    @Column(name = "deleted",nullable = true)
    private boolean deleted;

    /**
     * 密码，如:
     * 支付密码:42234324
     * 登录密码:dsf24234234
     */
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
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

    public Subject setUserId(long userId) {
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

    public String getUrl() {
        return url;
    }

    public Subject setUrl(String url) {
        this.url = url;
        return this;
    }

    public Date getCreateTime() {
        if(null == getId() && null == this.createTime){
            setCreateTime(new Date());
        }
        return createTime;
    }

    public Subject setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        if(null == this.updateTime){
            setUpdateTime(new Date());
        }
        return updateTime;
    }

    public Subject setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Subject setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
}

    public List<Secret> getSecrets() {
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

        return this.getId() == ((Subject)o).getId();
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
