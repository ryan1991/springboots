package com.sjbao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 宝宝设置
 *
 * @author songjunbao
 * @createdate 2018/6/25
 */
@Component
@ConfigurationProperties(prefix = "baby")
public class BabySettings {

    private String name;
    private Integer sex;
    private Integer height; // cm
    private Integer weight; //g

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "BabySettings{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
