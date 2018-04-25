package mongo.repository.news;

import mongo.entity.Content;
import mongo.entity.news.CompanyNews;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-mongo.xml"})
public class CompanyRepositoryTest {

	@Resource
	private CompanyRepository companyRepository;

	@Test
	public void testCount(){
		System.out.println(companyRepository.count());
	}

	@Test
	public void testInsert(){
//		for(int i=0; i<20; i++){
//			CompanyNews news = new CompanyNews();
//			news.setTitle("company_news"+i);
//			news.setDate("date"+i);
//			Content content = new Content();
//			content.setText("company_news_text" + i);
//			List<String> picPaths = new ArrayList<>();
//			picPaths.add("company_news_path"+i);
//			content.setPicPaths(picPaths);
//			news.setContent(content);
//			companyRepository.insert(news);
//		}
	}
}