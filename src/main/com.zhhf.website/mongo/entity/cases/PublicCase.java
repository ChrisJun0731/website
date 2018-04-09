package mongo.entity.cases;

import mongo.entity.Content;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/29.
 */
@Document(collection = "public_case")
public class PublicCase extends Case implements Serializable{

}
