package com.sjbao;

import com.sjbao.annotation.MyService;
import com.sjbao.jms.Msg;
import com.sjbao.util.ApplicationContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static com.sjbao.util.ApplicationContextHolder.getBeansWithAnnotation;

@RestController
@SpringBootApplication
@EnableCaching //开启springboot缓存
//程序启动后执行CommandLineRunner.run
@Slf4j
public class SpringBootFirstApplication implements CommandLineRunner{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value(value = "${book.author}")
	private String bookAuthor;
	@Value(value = "${book.name}")
	private String bookName;
	@Value(value = "${book.pinyin}")
	private String bookPinyin;

	@Value("${book.page}")
	private int bookPage;
	@Autowired
	private BookBean book;

	@Autowired
	private BabySettings babySettings;

	@Autowired
	private JmsTemplate jmsTemplate;

	public static void main(String[] args) {
//		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootFirstApplication.class);
//		builder.bannerMode(Banner.Mode.OFF).run(args);


		SpringApplication.run(SpringBootFirstApplication.class, args);


	}


	@RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
	public String index(){
//		return  "hello boot ,bookName:" + bookName + ",bookAuthor:"+bookAuthor+",pinyin:"+bookPinyin;
		logger.info("@value annotation ,bookName:" + bookName + ",bookAuthor:"+bookAuthor+",pinyin:"+bookPinyin+",page:"+bookPage);
		return  "hello boot ,bookName:" + book.getName();
	}


	@RequestMapping(value = "/baby",produces = "text/plain;charset=UTF-8")
	public String baby(){
		return  "baby info:" + babySettings.toString();
	}


	@Override
	public void run(String... strings) throws Exception {
		//目的地
		jmsTemplate.send("myDestination", new Msg());
		dowork();
	}

	private void dowork(){
		Map<String, Object> serviceBeanMap = ApplicationContextHolder.getBeansWithAnnotation(MyService.class);
		for(Object serviceBean : serviceBeanMap.values()){
			String val = serviceBean.getClass().getAnnotation(MyService.class).value();
			log.info("val:"+val);
			try {
				Method method = serviceBean.getClass().getMethod("work", String.class);
				method.invoke(serviceBean, "ryan");
			}catch (NoSuchMethodException e){
				log.error("no such method", e);
			}catch (IllegalAccessException ie){
				log.error("illegal access", ie);
			}catch (InvocationTargetException te){
				log.error("invoke target error", te);
			}

		}


	}

}
