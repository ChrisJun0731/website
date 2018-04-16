package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/4/14.
 */
@Controller
public class ManagerController {
	@RequestMapping("/management")
	public String manager(){
		return "management";
	}

}
