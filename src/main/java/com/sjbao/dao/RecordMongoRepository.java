package com.sjbao.dao;

import com.sjbao.entity.Person;
import com.sjbao.entity.Record;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ryan.song on 2018/10/11.
 */
public interface RecordMongoRepository extends MongoRepository<Record, Long> {

    Record findByName(String name);

}
