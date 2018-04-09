package mongo.repository.cases;

import junit.framework.TestCase;
import mongo.entity.Content;
import mongo.entity.cases.PublicCase;
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
public class PublicRepositoryTest {
	@Autowired
	private PublicRepository publicRepository;

	@Test
	public void testInsert(){
		for(int i=0; i<20; i++){
			PublicCase cases = new PublicCase();
			cases.setTitle("public_title"+i);
			cases.setCoverPath("cover_path"+i);
			Content content = new Content();
			content.setText("public_text" + i);
			List<String> picPaths = new ArrayList<>();
			picPaths.add("public_path"+i);
			content.setPicPaths(picPaths);
			cases.setContent(content);
			publicRepository.insert(cases);
		}
	}
}