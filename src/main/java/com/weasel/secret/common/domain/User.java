package com.weasel.secret.common.domain;

import com.weasel.secret.common.helper.EntryptionHelper;

import javax.persistence.*;
import java.io.Serializable;
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
    @Column(name = "createTime",nullable = false)
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "updateTime",nullable = true)
    private Date updateTime;
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

    public Date getCreateTime() {
        if(null == getId() && null == this.createTime){
            setCreateTime(new Date());
        }
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        if(null == this.updateTime){
            setUpdateTime(new Date());
        }
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void encodePassword(){
        setPassword(EntryptionHelper.md5Hex(getPassword()));
    }
}
