package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import services.ManagerService;

/**
 * Created by Administrator on 2018/4/14.
 */
@Controller
public class ManagerController {

	@Autowired
	private ManagerService managerService;


	@RequestMapping("/management")
	public String manager(){
		return "management";
	}

	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public void upload(@RequestParam("file")MultipartFile file, @RequestParam("type1")String type1,
					   @RequestParam("type2")String type2, @RequestParam("title")String title,
					   @RequestParam("desc")String desc){
		//上传文件
		String picPath = managerService.uploadFile(file, type1, type2, title);
		System.out.println("文件上传成功！");
		//数据入库
		managerService.save(type1, type2, title, desc, picPath);
		System.out.println("数据保存完毕");
	}

}
