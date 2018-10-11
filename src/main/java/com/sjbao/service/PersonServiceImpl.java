package com.sjbao.service;

import com.sjbao.dao.PersonRepository;
import com.sjbao.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ryan.song
 * @Date 2018/10/10
 **/
@Service
@CacheConfig(cacheNames = "people")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    CacheManager cacheManager;


    @Transactional(rollbackFor = IllegalArgumentException.class)
    @Override
    public Person savePersonWithRollback(Person person) {
        Person p = personRepository.save(person);
        if ("songdali".equals(person.getName())){
            throw new IllegalArgumentException("songdali 已经存在 将回滚");
        }

        return p;
    }

    @Transactional(noRollbackFor = IllegalArgumentException.class)
    @Override
    public Person savePersonWithoutRollback(Person person) {
        Person p = personRepository.save(person);
        if ("songdali".equals(person.getName())){
            throw new IllegalArgumentException("songdali 已经存在 不回滚");
        }

        return p;
    }

    @Cacheable
    @Override
    public List<Person> findAllPersons() {
        System.out.println("cacheName:" + cacheManager.getCacheNames());
        return personRepository.findAll();
    }
}
