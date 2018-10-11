package com.sjbao.controller;

import com.sjbao.dao.RecordMongoRepository;
import com.sjbao.entity.Record;
import com.sjbao.entity.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Author ryan.song
 * @Date 2018/10/11
 **/
@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private RecordMongoRepository recordMongoRepository;

    @RequestMapping("/save")
    public Record save(){
        Record record = new Record("songjunbao_mongo");
        Work lmm = new Work("20170510 - 20180814", "驴妈妈");
        Work xiaoi = new Work("20180917 -", "小i机器人");
        record.getWorks().add(lmm);
        record.getWorks().add(xiaoi);

        return record = recordMongoRepository.save(record);
    }


}
