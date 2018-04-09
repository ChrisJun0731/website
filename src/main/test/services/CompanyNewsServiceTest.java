package services;

import mongo.entity.Content;
import mongo.entity.news.CompanyNews;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:spring-mongo.xml"})
public class CompanyNewsServiceTest {

	@Autowired
	private NewsService newsService;

	@Test
	public void testInsertNews() throws Exception {
		for (int i = 0; i < 10; i++) {
			CompanyNews companyNews = new CompanyNews();
			companyNews.setTitle("news" + i);
			companyNews.setDate("" + i);
			Content content = new Content();
			content.setText("test"+i);
			List<String> picPaths = new ArrayList<>();
			picPaths.add("pic"+i);
			content.setPicPaths(picPaths);
			companyNews.setContent(content);
			newsService.insertNews("company", companyNews);
		}
	}

}