package mongo.repository.news;

import mongo.entity.news.StaffNews;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/3/31.
 */
@Repository
public interface StaffRepository extends MongoRepository<StaffNews, ObjectId>{

}
