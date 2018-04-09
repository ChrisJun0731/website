package mongo.repository.news;

import junit.framework.TestCase;
import mongo.entity.Content;
import mongo.entity.news.StaffNews;
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
public class StaffRepositoryTest {

	@Resource
	private StaffRepository staffRepository;

	@Test
	public void testInsert(){
		for(int i=0; i<20; i++){
			StaffNews news = new StaffNews();
			news.setTitle("staff_news"+i);
			news.setDate("date"+i);
			Content content = new Content();
			content.setText("staff_news_text" + i);
			List<String> picPaths = new ArrayList<>();
			picPaths.add("staff_news_path"+i);
			content.setPicPaths(picPaths);
			news.setContent(content);
			staffRepository.insert(news);
		}
	}
}