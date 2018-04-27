package mongo.repository.cases;

import mongo.entity.cases.EduCase;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Administrator on 2018/4/26.
 */
@Repository
public interface EduRepository extends MongoRepository<EduCase, ObjectId> {
	public EduCase findByTitle(String title);
}
