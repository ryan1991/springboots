package com.sjbao.dao;

import com.sjbao.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ryan.song on 2018/10/8.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByName(String name);

}
