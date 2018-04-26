package mongo.repository.cases;

import mongo.entity.cases.RestaurantCase;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Administrator on 2018/4/26.
 */
public interface RestaurantRepository extends MongoRepository<RestaurantCase, ObjectId> {

	public RestaurantCase findByTitle(String title);
}
