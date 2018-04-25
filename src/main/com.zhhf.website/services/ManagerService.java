package services;

import mongo.dao.cases.HotelDao;
import mongo.dao.cases.HouseDao;
import mongo.dao.cases.PublicDao;
import mongo.entity.cases.HotelCase;
import mongo.entity.cases.HouseCase;
import mongo.entity.cases.PublicCase;
import mongo.repository.cases.HotelRepository;
import mongo.repository.cases.HouseRepository;
import mongo.repository.cases.PublicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/21.
 */
@Service
public class ManagerService {

	@Autowired
	private PublicRepository publicRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private HouseRepository houseRepository;
	@Autowired
	private PublicDao publicDao;
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private HouseDao houseDao;


	/**
	 * 上传文件
	 * @param file
	 * @param type
	 * @param title
	 */
	public String uploadFile(MultipartFile file, String type, String title){
		//获取root路径
		String root = System.getenv("CATALINA_HOME") + "/webapps/website";
		String path = "/upload/"+type+"/"+title+"/";
		String fileName = file.getOriginalFilename();
		File uploadDir = new File(root+path);
		if(!uploadDir.exists()){
			uploadDir.mkdirs();
		}
		String destFilePath = root + path + fileName;
		System.out.println("dest file path is " + destFilePath);
		File destFile = new File(destFilePath);

		try {
			file.transferTo(destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path+fileName;
	}


	/**
	 * 将上传的数据入库
	 * @param type
	 * @param title
	 * @param desc
	 * @param picPath
	 */
	public void save(String type, String title, String desc, String picPath){

		switch(type){
			case "public":
				System.out.println("将新增一条公共装饰信息.");
				PublicCase pubCase = publicRepository.findByTitle(title);
				if(pubCase != null){
					publicDao.addPicPath(title, picPath);
				}else{
					pubCase = new PublicCase();
					List<String> picPaths = new ArrayList();
					picPaths.add(picPath);
					pubCase.setTitle(title);
					pubCase.setCoverPath(picPath);
					pubCase.getContent().setText(desc);
					pubCase.getContent().setPicPaths(picPaths);
					publicRepository.insert(pubCase);
				}
				break;
			case "house":
				System.out.println("将新增一条家装信息.");
				HouseCase houseCase = houseRepository.findByTitle(title);
				if(houseCase != null){
					houseDao.addPicPath(title, picPath);
				}else{
					houseCase = new HouseCase();
					List<String> picPaths = new ArrayList();
					picPaths.add(picPath);
					houseCase.setCoverPath(picPath);
					houseCase.setTitle(title);
					houseCase.getContent().setText(desc);
					houseCase.getContent().setPicPaths(picPaths);
					houseRepository.insert(houseCase);
				}
				break;
			case "hotel":
				System.out.println("将新增一条酒店装饰信息.");
				HotelCase hotelCase = hotelRepository.findByTitle(title);
				if(hotelCase != null){
					hotelDao.addPicPath(title, picPath);
				}else{
					hotelCase = new HotelCase();
					List<String> picPaths = new ArrayList();
					picPaths.add(picPath);
					hotelCase.setCoverPath(picPath);
					hotelCase.setTitle(title);
					hotelCase.getContent().setText(desc);
					hotelCase.getContent().setPicPaths(picPaths);
					hotelRepository.insert(hotelCase);
				}
		}
	}
}
