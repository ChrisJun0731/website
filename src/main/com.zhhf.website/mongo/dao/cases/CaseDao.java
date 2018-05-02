package mongo.dao.cases;

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
public class CaseDao {
	@Autowired
	private MongoTemplate mongoTemplate;

	public void addPicPath(String title, String picPath, String collName){
		Query query = Query.query(Criteria.where("title").is(title));
		Update update = new Update().addToSet("content.picPaths", picPath);
		mongoTemplate.updateFirst(query, update, collName);
	}

	public void delTitle(String title, String collName){
		Query query = Query.query(Criteria.where("title").is(title));
		mongoTemplate.remove(query, collName);
	}
}
