package com.sjbao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author ryan.song
 * @Date 2018/10/8
 **/
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    public Person(){}

    public Person(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
