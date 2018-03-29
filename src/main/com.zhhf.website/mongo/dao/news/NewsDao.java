package mongo.dao.news;

import mongo.entity.news.News;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;

/**
 * Created by Administrator on 2018/3/29.
 */
public interface NewsDao extends MongoRepository<News, ObjectId>{

}
