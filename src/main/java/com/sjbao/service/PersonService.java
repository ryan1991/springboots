package com.sjbao.service;

import com.sjbao.entity.Person;

import java.util.List;

/**
 * Created by ryan.song on 2018/10/10.
 */
public interface PersonService {
    Person savePersonWithRollback(Person person);
    Person savePersonWithoutRollback(Person person);

    List<Person> findAllPersons();

}
