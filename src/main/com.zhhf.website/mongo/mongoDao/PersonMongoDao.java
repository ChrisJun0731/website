package mongo.mongoDao;

import mongo.entity.Person;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/27.
 */
@Component
public class PersonMongoDao {

	@Resource
	private MongoTemplate mongoTemplate;

	public List<Person> findAll(){
		return mongoTemplate.findAll(Person.class, "person");
	}

	public void insertPerson(Person person){
		mongoTemplate.insert(person, "person");
	}

	public void removePerson(String username){
		mongoTemplate.remove(Query.query(Criteria.where("name").is(username)), "person");
	}
}
