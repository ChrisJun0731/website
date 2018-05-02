package services;

import mongo.dao.cases.*;
import mongo.dao.join.PTrainDao;
import mongo.dao.news.CompanyDao;
import mongo.dao.news.IndustryDao;
import mongo.dao.news.NewsDao;
import mongo.dao.news.StaffDao;
import mongo.entity.cases.*;
import mongo.entity.join.PTrain;
import mongo.entity.news.CompanyNews;
import mongo.entity.news.IndustryNews;
import mongo.entity.news.StaffNews;
import mongo.repository.cases.*;
import mongo.repository.join.PersonalTrainRepository;
import mongo.repository.news.CompanyRepository;
import mongo.repository.news.IndustryRepository;
import mongo.repository.news.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/21.
 */
@Service
public class ManagerService {

	@Autowired
	private CommercialRepository commCaseRepository;
	@Autowired
	private HotelRepository hotelCaseRepository;
	@Autowired
	private OfficeRepository officeCaseRepository;
	@Autowired
	private RestaurantRepository restCaseRepository;
	@Autowired
	private EduRepository eduCaseRepository;

	@Autowired
	private CompanyRepository comNewsRepository;
	@Autowired
	private IndustryRepository indNewsRepository;
	@Autowired
	private StaffRepository staffNewsRepository;

	@Autowired
	private PersonalTrainRepository pTrainRepository;

	@Autowired
	private CaseDao caseDao;

	@Autowired
	private NewsDao newsDao;

	@Autowired
	private PTrainDao pTrainDao;

	/**
	 * 上传文件
	 *
	 * @param file
	 * @param type1, type2
	 * @param title
	 */
	public String uploadFile(MultipartFile file, String type1, String type2, String title) {
		//获取root路径
		String root = System.getenv("CATALINA_HOME") + "/webapps";
		String path = "/website/upload/" + type1 + "/" + type2 + "/" + title + "/";
		String fileName = file.getOriginalFilename();
		File uploadDir = new File(root + path);
		if (!uploadDir.exists()) {
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

		return path + fileName;
	}


	/**
	 * 将上传的数据入库
	 *
	 * @param type1,type2
	 * @param title
	 * @param desc
	 * @param picPath
	 */
	public void save(String type1, String type2, String title, String desc, String picPath) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = dateFormat.format(new Date());
		switch (type1) {
			//新闻类
			case "news":
				switch (type2) {
					case "company":
						//判断该新闻标题是否存在，不存在新增，存在则添加图片的路径
						CompanyNews comNews = comNewsRepository.findByTitle(title);
						if (comNews != null && picPath!=null) {
							newsDao.addPicPaths(title, picPath, "company_news");
						} else {
							comNews = new CompanyNews();
							comNews.setTitle(title);
							comNews.setDate(dateStr);
							comNews.getContent().setText(desc);
							comNews.getContent().getPicPaths().add(picPath);
							comNewsRepository.insert(comNews);
						}
						break;
					case "industry":
						IndustryNews indusNews = indNewsRepository.findByTitle(title);
						if (indusNews != null&& picPath!=null) {
							newsDao.addPicPaths(title, picPath, "industry_news");
						} else {
							indusNews = new IndustryNews();
							indusNews.setTitle(title);
							indusNews.setDate(dateStr);
							indusNews.getContent().setText(desc);
							indusNews.getContent().getPicPaths().add(picPath);
							indNewsRepository.insert(indusNews);
						}
						break;
					case "staff":
						StaffNews staffNews = staffNewsRepository.findByTitle(title);
						if (staffNews != null&& picPath!=null) {
							newsDao.addPicPaths(title, picPath, "staff_news");
						} else {
							staffNews = new StaffNews();
							staffNews.setTitle(title);
							staffNews.setDate(dateStr);
							staffNews.getContent().setText(desc);
							staffNews.getContent().getPicPaths().add(picPath);
							staffNewsRepository.insert(staffNews);
						}
						break;
				}
				//案例类
			case "cases":
				switch (type2) {
					case "office":
						System.out.println("将新增一条办公空间案例.");
						OfficeCase officeCase = officeCaseRepository.findByTitle(title);
						if (officeCase != null&& picPath!=null) {
							caseDao.addPicPath(title, picPath, "office_case");
						} else {
							officeCase = new OfficeCase();
							officeCase.setTitle(title);
							officeCase.setCoverPath(picPath);
							officeCase.getContent().setText(desc);
							officeCase.getContent().getPicPaths().add(picPath);
							officeCaseRepository.insert(officeCase);
						}
						break;
					case "commercial":
						System.out.println("将新增一条商业空间案例.");
						CommercialCase commCase = commCaseRepository.findByTitle(title);
						if (commCase != null&& picPath!=null) {
							caseDao.addPicPath(title, picPath, "commercial_case");
						} else {
							commCase = new CommercialCase();
							commCase.setTitle(title);
							commCase.setCoverPath(picPath);
							commCase.getContent().setText(desc);
							commCase.getContent().getPicPaths().add(picPath);
							commCaseRepository.insert(commCase);
						}
						break;
					case "hotel":
						System.out.println("将新增一条酒店装饰信息.");
						HotelCase hotelCase = hotelCaseRepository.findByTitle(title);
						if (hotelCase != null&& picPath!=null) {
							caseDao.addPicPath(title, picPath, "hotel_case");
						} else {
							hotelCase = new HotelCase();
							hotelCase.setCoverPath(picPath);
							hotelCase.setTitle(title);
							hotelCase.getContent().setText(desc);
							hotelCase.getContent().getPicPaths().add(picPath);
							hotelCaseRepository.insert(hotelCase);
						}
						break;
					case "restaurant":
						System.out.println("将新增一条餐饮案例.");
						RestaurantCase restCase = restCaseRepository.findByTitle(title);
						if (restCase != null&& picPath!=null) {
							caseDao.addPicPath(title, picPath, "restaurant_case");
						} else {
							restCase = new RestaurantCase();
							restCase.setCoverPath(picPath);
							restCase.setTitle(title);
							restCase.getContent().setText(desc);
							restCase.getContent().getPicPaths().add(picPath);
							restCaseRepository.insert(restCase);
						}
						break;
					case "education":
						System.out.println("将新增一条教育案例.");
						EduCase eduCase = eduCaseRepository.findByTitle(title);
						if (eduCase != null&& picPath!=null) {
							caseDao.addPicPath(title, picPath, "education_case");
						} else {
							eduCase = new EduCase();
							eduCase.setCoverPath(picPath);
							eduCase.setTitle(title);
							eduCase.getContent().setText(desc);
							eduCase.getContent().getPicPaths().add(picPath);
							eduCaseRepository.insert(eduCase);
						}
						break;
				}
				//加入我们
			case "join":
				switch (type2) {
					case "p_train":
						PTrain pTrain = pTrainRepository.findByTitle(title);
						if (pTrain != null&& picPath!=null) {
							pTrainDao.addPicPaths(title, picPath, "personal_train");
						} else {
							pTrain = new PTrain();
							pTrain.setTitle(title);
							pTrain.setDate(dateStr);
							pTrain.getContent().setText(desc);
							pTrain.getContent().getPicPaths().add(picPath);
							pTrainRepository.insert(pTrain);
						}

				}
		}
	}

	public Object queryResults(String type1, String type2){
		Object obj = null;
		switch(type1){
			case "news":
				switch(type2){
					case "company":
						obj = (Object)comNewsRepository.findAll();
						break;
					case "industry":
						obj = (Object)indNewsRepository.findAll();
						break;
					case "staff":
						obj = (Object)staffNewsRepository.findAll();
						break;
				}
				break;
			case "cases":
				switch(type2){
					case "office":
						obj = officeCaseRepository.findAll();
						break;
					case "commercial":
						obj = commCaseRepository.findAll();
						break;
					case "restaurant":
						obj = restCaseRepository.findAll();
						break;
					case "hotel":
						obj = hotelCaseRepository.findAll();
						break;
					case "education":
						obj = eduCaseRepository.findAll();
						break;
				}
				break;
			case "join":
				switch(type2){
					case "p_train":
						obj = pTrainRepository.findAll();
						break;
				}
				break;
		}
		return obj;
	}

	public void delResult(String type1, String type2, String title){
		switch(type1){
			case "news":
				switch(type2){
					case "company":
						newsDao.delTitle(title, "company_news");
						break;
					case "industry":
						newsDao.delTitle(title, "industry_news");
						break;
					case "staff":
						newsDao.delTitle(title, "staff_news");
						break;
				}
				break;
			case "cases":
				switch(type2){
					case "office":
						caseDao.delTitle(title, "office_case");
						break;
					case "commercial":
						caseDao.delTitle(title, "commercial_case");
						break;
					case "hotel":
						caseDao.delTitle(title, "hotel_case");
						break;
					case "restaurant":
						caseDao.delTitle(title, "restaurant_case");
						break;
					case "education":
						caseDao.delTitle(title, "education_case");
						break;
				}
				break;
			case "join":
				switch (type2){
					case "p_train":
						pTrainDao.delTitle(title, "personal_train");
						break;
				}
				break;
		}
	}
}
