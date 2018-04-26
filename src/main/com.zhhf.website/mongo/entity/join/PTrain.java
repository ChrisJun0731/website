package mongo.entity.join;

import mongo.entity.news.News;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Administrator on 2018/4/26.
 */
@Document(collection = "personal_train")
public class PTrain extends News {
}
