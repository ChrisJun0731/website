package controllers;

import jo.ContentParam;
import mongo.entity.user.User;
import org.apache.commons.codec.Encoder;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import services.LoginService;
import services.ManagerService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/4/14.
 */
@Controller
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private LoginService loginService;

	@RequestMapping("/management")
	public String manager(HttpSession session){
		if(session.getAttribute("user")!=null){
			return "management";
		}else{
			return "login";
		}
	}

	@ResponseBody
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String upload(@RequestParam("file")MultipartFile file, ContentParam param){

		String picPath = null;
		String type1 = param.getType1();
		String type2 = param.getType2();
		String title = param.getTitle();
		String desc = param.getDesc();
		if(file != null){
			//上传文件
			picPath = managerService.uploadFile(file, type1, type2, title);
			System.out.println("文件上传成功！");
		}

		//数据入库
		managerService.save(type1, type2, title, desc, picPath);
		System.out.println("数据保存完毕");
		return "{\"flag\":\"success\"}";
	}

	@ResponseBody
	@RequestMapping(value="/upload_no_file", method=RequestMethod.POST)
	public String uploadWithNoFile(@RequestBody ContentParam param){
		String picPath = null;
		String type1 = param.getType1();
		String type2 = param.getType2();
		String title = param.getTitle();
		String desc = param.getDesc();
		managerService.save(type1, type2, title, desc, picPath);
		return "{\"flag\":\"success\"}";
	}

	@ResponseBody
	@RequestMapping(value="/queryResults", method = RequestMethod.GET)
	public Object queryResults(@RequestParam("type1")String type1, @RequestParam("type2")String type2){
		return managerService.queryResults(type1, type2);
	}

	@ResponseBody
	@RequestMapping(value = "/delResult", method = RequestMethod.GET)
	public void delResult(@RequestParam("type1") String type1, @RequestParam("type2") String type2,
						  @RequestParam("title") String title) {
		managerService.delResult(type1, type2, title);
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(User user, HttpSession session){
		String key = user.getPwd();
		String val = DigestUtils.md5Hex(key);
		user.setPwd(val);
		if(loginService.isUserExist(user)){
			session.setAttribute("user", user);
			return "management";
		}else{
			return "login";
		}
	}

}
