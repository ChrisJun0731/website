package mongo.entity.join;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Administrator on 2018/4/27.
 */
@Document(collection = "recruit_info")
public class Recruit {

	private String position;
	private int num;
	private String site;
	private String date;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
