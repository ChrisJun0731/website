package mongo.repository.cases;

import mongo.entity.cases.RestaurantCase;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/4/26.
 */
@Repository
public interface RestaurantRepository extends MongoRepository<RestaurantCase, ObjectId> {

	public RestaurantCase findByTitle(String title);
}
