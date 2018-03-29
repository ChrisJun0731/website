package mongo.mongoDao;

import junit.framework.TestCase;
import mongo.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-mongo.xml"})
public class PersonMongoDaoTest {

	@Resource
	private PersonMongoDao personMongoDao;

	@Test
	public void testMongo(){
		List<Person> personList = personMongoDao.findAll();
		for(Person person: personList){
			System.out.println(person.toString());
		}
	}
}