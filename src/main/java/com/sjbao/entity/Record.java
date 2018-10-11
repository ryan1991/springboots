package com.sjbao.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 履历
 * @Author ryan.song
 * @Date 2018/10/11
 **/
@Document
public class Record {
    @Id
    private String id;
    private String name;
    @Field("works")
    private Collection<Work> works = new LinkedHashSet<>();

    public Record(String name) {
        super();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Work> getWorks() {
        return works;
    }

    public void setWorks(Collection<Work> works) {
        this.works = works;
    }
}
