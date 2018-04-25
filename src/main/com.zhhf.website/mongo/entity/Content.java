package mongo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/29.
 */
public class Content {
	private String text;
	private List<String> picPaths = new ArrayList<>();

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getPicPaths() {
		return picPaths;
	}

	public void setPicPaths(List<String> picPaths) {
		this.picPaths = picPaths;
	}
}
