package mongo.repository.news;

import mongo.entity.news.IndustryNews;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/3/31.
 */
@Repository
public interface IndustryRepository extends MongoRepository<IndustryNews, ObjectId> {
	public IndustryNews findByTitle(String title);
}
