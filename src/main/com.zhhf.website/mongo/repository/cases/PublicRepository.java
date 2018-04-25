package mongo.repository.cases;

import mongo.entity.cases.PublicCase;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/3/31.
 */
@Repository
public interface PublicRepository extends MongoRepository<PublicCase, ObjectId> {
	PublicCase findByTitle(String title);
}
