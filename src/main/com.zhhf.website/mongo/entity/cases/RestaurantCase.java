package mongo.entity.cases;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Administrator on 2018/4/26.
 */
@Document(collection = "restaurant_case")
public class RestaurantCase extends Case {
}
