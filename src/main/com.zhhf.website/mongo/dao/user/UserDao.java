package mongo.dao.user;

import mongo.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/4/30.
 */
@Component
public class UserDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	public boolean exist(User user){
		Query query = Query.query(Criteria.where("username").is(user.getUsername()).and("pwd").is(user.getPwd()));
		return mongoTemplate.exists(query, "user");
	}
}
