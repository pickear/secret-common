package com.weasel.secret.common.domain;

import javax.persistence.*;

/**
 * Created by Dylan on 2017/11/11.
 */
@Entity
@Table(name = "secret")
public class Secret{

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

}
