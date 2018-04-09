package services;

import mongo.entity.news.CompanyNews;
import mongo.entity.news.IndustryNews;
import mongo.entity.news.News;
import mongo.entity.news.StaffNews;
import mongo.repository.news.CompanyRepository;
import mongo.repository.news.IndustryRepository;
import mongo.repository.news.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sun.swing.BakedArrayList;

import javax.xml.stream.events.StartDocument;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/30.
 */
@Service
public class NewsService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private IndustryRepository industryRepository;

	@Autowired
	private StaffRepository staffRepository;

	/**
	 * 查询总记录数
	 * @return
	 */
	public int countNewsSize(String type){
		int size = 0;
		switch(type){
			case "company":
				size = (int)companyRepository.count();
				break;
			case "industry":
				size = (int)industryRepository.count();
				break;
			case "staff":
				size = (int)staffRepository.count();
				break;
		}
		return size;
	}

	/**
	 * 新闻分页查询
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<? extends News> page(int page, int pageSize, String type){
		PageRequest pageRequest = new PageRequest(page, pageSize);
		List<? extends News> pageList = null;
		switch(type){
			case "company":
				Page<CompanyNews> company_page = companyRepository.findAll(pageRequest);
				List<CompanyNews> companyNewsList = company_page.getContent();
				pageList = companyNewsList;
				break;
			case "industry":
				Page<IndustryNews> industry_page = industryRepository.findAll(pageRequest);
				List<IndustryNews> industryNewsList = industry_page.getContent();
				pageList = industryNewsList;
				break;
			case "staff":
				Page<StaffNews> staff_page = staffRepository.findAll(pageRequest);
				List<StaffNews> staffNewsList = staff_page.getContent();
				pageList = staffNewsList;
				break;
		}
		return pageList;
	}

	/**
	 * 新增一条新闻
	 * @param
	 */
	public void insertNews(String type, News news){

		switch(type){
			case "company":
				companyRepository.insert((CompanyNews)news);
				break;
			case "industry":
				industryRepository.insert((IndustryNews)news);
				break;
			case "staff":
				staffRepository.insert((StaffNews)news);
				break;
		}
	}

}
