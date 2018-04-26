package mongo.repository.cases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2018/4/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-mongo.xml"})
public class HouseRepositoryTest {
	@Autowired
	private OfficeRepository houseRepository;

	@Test
	public void testInsert(){
//		for(int i=0; i<20; i++){
//			OfficeCase cases = new OfficeCase();
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
