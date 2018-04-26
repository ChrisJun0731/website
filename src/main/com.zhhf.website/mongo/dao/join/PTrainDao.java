package mongo.dao.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/4/26.
 */
@Component
public class PTrainDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void addPicPaths(String title, String picPath, String collName){
		Query query = Query.query(Criteria.where("title").is(title));
		Update update = new Update().addToSet("content.picPaths", picPath);
		mongoTemplate.updateFirst(query, update, collName);
	}
}
