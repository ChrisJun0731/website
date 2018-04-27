package mongo.repository.join;

import mongo.entity.join.PTrain;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/4/26.
 */
@Repository
public interface PersonalTrainRepository extends MongoRepository<PTrain, ObjectId>{
	public PTrain findByTitle(String title);
}
