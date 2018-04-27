package services;

import jo.MessageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:spring-mongo.xml"})
public class EmailServiceTest {

	@Autowired
	private EmailService emailService;

	@Test
	public void sendEmailTest(){
		MessageInfo info = new MessageInfo();
		info.setName("chris");
		info.setMessage("吧啦啦啦");
		info.setEmail("2323@qq.com");

		emailService.sendMail(info);
	}


}