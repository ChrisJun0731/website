package mongo.repository.news;

import mongo.entity.news.CompanyNews;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/3/29.
 */
@Repository
public interface CompanyRepository extends MongoRepository<CompanyNews, ObjectId>{
	public CompanyNews findByTitle(String title);
}
