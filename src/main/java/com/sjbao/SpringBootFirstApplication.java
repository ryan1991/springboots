package com.sjbao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootFirstApplication {

	@Value(value = "${book.author}")
	private String bookAuthor;
	@Value(value = "${book.name}")
	private String bookName;
	@Value(value = "${book.pinyin}")
	private String bookPinyin;

	@Autowired
	private BookBean book;

	@Autowired
	private BabySettings babySettings;

	public static void main(String[] args) {
//		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootFirstApplication.class);
//		builder.bannerMode(Banner.Mode.OFF).run(args);


		SpringApplication.run(SpringBootFirstApplication.class, args);


	}


	@RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
	public String index(){
//		return  "hello boot ,bookName:" + bookName + ",bookAuthor:"+bookAuthor+",pinyin:"+bookPinyin;
		return  "hello boot ,bookName:" + book.getName();
	}


	@RequestMapping(value = "/baby",produces = "text/plain;charset=UTF-8")
	public String baby(){
		return  "baby info:" + babySettings.toString();
	}
}
