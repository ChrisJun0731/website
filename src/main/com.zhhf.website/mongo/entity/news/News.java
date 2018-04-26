package mongo.entity.news;

import mongo.entity.Content;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/31.
 */
public class News implements Serializable{

	@Id
	private ObjectId id;
	private String title;
	private String date;
	private Content content = new Content();

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}
}
