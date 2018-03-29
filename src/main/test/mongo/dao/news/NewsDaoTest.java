package mongo.dao.news;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/3/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-mongo.xml"})
public class NewsDaoTest {

	@Resource
	private NewsDao newsDao;

	@Test
	public void testCount(){
		System.out.println(newsDao.count());
	}
}