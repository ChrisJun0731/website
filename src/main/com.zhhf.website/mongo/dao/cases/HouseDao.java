package mongo.dao.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/4/21.
 */
@Component
public class HouseDao {
	@Autowired
	private MongoTemplate mongoTemplate;

	public void addPicPath(String title, String picPath){
		Query query = Query.query(Criteria.where("title").is(title));
		Update update = new Update().addToSet("content.picPaths", picPath);
		mongoTemplate.updateFirst(query, update, "house_case");
	}
}
