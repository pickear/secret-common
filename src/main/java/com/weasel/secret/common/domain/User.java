package com.weasel.secret.common.domain;

import com.weasel.secret.common.helper.EntryptionHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**用户
 * Created by Dylan on 2017/11/11.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    @Column(name = "username",nullable = false,unique = true)
    private String username;
    /**
     * 密码
     */
    @Column(name = "password",nullable = false)
    private String password;
    /**
     * 邮箱
     */
    @Column(name = "email",nullable = true)
    private String email;

    /**
     *创建时间
     */
    @Column(name = "create_time",nullable = false)
    @Access(value = AccessType.PROPERTY)
    private Long createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time",nullable = true)
    @Access(value = AccessType.PROPERTY)
    private Long updateTime;
    /**
     * 密码主体，比如招行，淘宝
     */
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Subject> subjects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Subject> getSubjects() {
        if(null == this.subjects){
            return new ArrayList<>();
        }
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void encodePassword(){
        setPassword(EntryptionHelper.md5Hex(getPassword()));
    }

}
