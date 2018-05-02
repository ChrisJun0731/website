package controllers;

import jo.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.EmailService;

/**
 * Created by Administrator on 2018/4/27.
 */
@RestController
public class ContactController {

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/leave_message", method = RequestMethod.POST)
	public void mail(@RequestBody MessageInfo messageInfo){
		emailService.sendMail(messageInfo);
	}

}
