package com.weasel.secret.common.domain;

import com.weasel.secret.common.helper.EntryptionHelper;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dylan on 2017/11/11.
 */
@Entity
@Table(name = "secret")
public class Secret implements Serializable{

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     *
     */
    @Column(name = "subject_id")
    private long subjectId;
    /**
     *
     */
    @Column(name = "name")
    private String name;
    /**
     *
     */
    @Column(name = "value")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     *
     * @param key
     * @throws Exception
     */
    public void entrypt(String key) throws Exception {
        setValue(EntryptionHelper.encrypt(key,getValue()));
    }

    /**
     *
     * @param key
     * @throws Exception
     */
    public void decrypt(String key) throws Exception {
        setValue(EntryptionHelper.decrypt(key,getValue()));
    }

}
