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
        if (!(o instanceof Secret)){
            return false;
        }

        return this.getId() == ((Secret)o).getId();
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
