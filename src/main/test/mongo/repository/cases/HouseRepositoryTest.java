package mongo.repository.cases;

import junit.framework.TestCase;
import mongo.entity.Content;
import mongo.entity.cases.HotelCase;
import mongo.entity.cases.HouseCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-mongo.xml"})
public class HouseRepositoryTest {
	@Autowired
	private HouseRepository houseRepository;

	@Test
	public void testInsert(){
//		for(int i=0; i<20; i++){
//			HouseCase cases = new HouseCase();
//			cases.setTitle("house_title"+i);
//			cases.setCoverPath("cover_path"+i);
//			Content content = new Content();
//			content.setText("house_text" + i);
//			List<String> picPaths = new ArrayList<>();
//			picPaths.add("house_path"+i);
//			content.setPicPaths(picPaths);
//			cases.setContent(content);
//			houseRepository.insert(cases);
//		}
	}
}
