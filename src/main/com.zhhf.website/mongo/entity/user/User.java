package mongo.entity.user;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Administrator on 2018/4/30.
 */
@Document(collection = "user")
public class User {

	private String username;
	private String pwd;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
