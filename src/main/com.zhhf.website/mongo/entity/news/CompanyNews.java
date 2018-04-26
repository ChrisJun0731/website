package mongo.entity.news;

import mongo.entity.Content;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/29.
 */
@Document(collection="company_news")
public class CompanyNews extends News{

}
