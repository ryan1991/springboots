package com.sjbao.controller;

import com.sjbao.dao.PersonRepository;
import com.sjbao.entity.Person;
import com.sjbao.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ryan.song
 * @Date 2018/10/8
 **/

@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @RequestMapping("/save")
    public Person findAllPersons(String name){
        Person p = new Person();
        p.setName(name);
        return personRepository.save(p);

    }

    @RequestMapping("/findByName")
    public Person findByName(String name) {
        return personRepository.findByName(name);
    }

    @RequestMapping("/findAll")
    public List<Person> findAllPersons(){
        return personService.findAllPersons();
    }

    @RequestMapping("/sort")
    public List<Person> sort(){
        return personRepository.findAll(new Sort(Sort.Direction.DESC, "Id"));
    }

    @RequestMapping("/page")
    public Page<Person> page(){
        return personRepository.findAll(new PageRequest(0,2));
    }

    @RequestMapping("/rollback")
    public Person rollback(String name){
        Person p = new Person();
        p.setName("songdali");
        return personService.savePersonWithRollback(p);

    }

    @RequestMapping("/noRollback")
    public Person noRollback(String name){
        Person p = new Person();
        p.setName("songdali");
        return personService.savePersonWithoutRollback(p);

    }
}
