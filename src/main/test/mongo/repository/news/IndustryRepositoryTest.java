package mongo.repository.news;

import junit.framework.TestCase;
import mongo.entity.Content;
import mongo.entity.news.CompanyNews;
import mongo.entity.news.IndustryNews;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-mongo.xml"})
public class IndustryRepositoryTest {

	@Resource
	private IndustryRepository industryRepository;

	@Test
	public void testInsert(){
		for(int i=0; i<20; i++){
			IndustryNews news = new IndustryNews();
			news.setTitle("industry_news"+i);
			news.setDate("date"+i);
			Content content = new Content();
			content.setText("industry_news_text" + i);
			List<String> picPaths = new ArrayList<>();
			picPaths.add("industry_news_path"+i);
			content.setPicPaths(picPaths);
			news.setContent(content);
			industryRepository.insert(news);
		}
	}
}