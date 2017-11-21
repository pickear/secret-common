package com.weasel.secret.common.domain;

import com.weasel.secret.common.helper.EntryptionHelper;

import javax.persistence.*;
import java.util.List;

/**密码主体，如招行，淘宝
 * Created by Dylan on 2017/11/11.
 */
@Entity
@Table(name = "subject")
public class Subject {
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

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Secret> getSecrets() {
        return secrets;
    }

    public void setSecrets(List<Secret> secrets) {
        this.secrets = secrets;
    }

    /**
     *
     * @param key
     * @throws Exception
     */
    public void entryptAllSecret(String key) throws Exception {
        for(Secret secret : getSecrets()){
            secret.entrypt(key);
        }
    }

    /**
     *
     * @param key
     * @throws Exception
     */
    public void decryptAllSecret(String key) throws Exception {
        for(Secret secret : getSecrets()){
            secret.decrypt(key);
        }
    }


}
