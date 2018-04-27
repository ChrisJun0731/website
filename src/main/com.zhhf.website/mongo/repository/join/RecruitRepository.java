package mongo.repository.join;

import mongo.entity.join.Recruit;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/4/27.
 */
@Repository
public interface RecruitRepository extends MongoRepository<Recruit, ObjectId>{

}
