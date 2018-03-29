package mongo.dao;

import mongo.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-mongo.xml"})
public class PersonDaoTest {

	@Resource
	private PersonDao personDao;

	@Test
	public void testMongo() throws Exception {
		List<Person> personList = new ArrayList<>();
		for(int i=0; i<10; i++){
			personList.add(new Person("name" + i, i));
		}
		personDao.save(personList);
	}

	@Test
	public void findMongo(){
		System.out.println(personDao.findByAge(2,8, "name6"));
	}

}