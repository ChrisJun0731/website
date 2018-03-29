package mongo.entity.cases;

import mongo.entity.Content;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Administrator on 2018/3/29.
 */
@Document(collection = "house_case")
public class HouseCase {

	@Id
	private ObjectId id;
	private String title;
	private String coverPath;
	private Content content;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}
}
