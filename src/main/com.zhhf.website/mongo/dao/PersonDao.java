package mongo.dao;

import mongo.entity.Person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/27.
 */
@Component
public interface PersonDao extends MongoRepository<Person, ObjectId> {

	@Query(value="{'age':{'$gte':?0, '$lte':?1}, 'name':?2}", fields="{'name': 1, 'age': 1}")
	List<Person> findByAge(int age1, int age2, String name);
}
