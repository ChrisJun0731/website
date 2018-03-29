package mongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/27.
 */
@Document(collection="person")
public class Person implements Serializable{
	@Id
	private ObjectId id;
	private String name;
	private int age;

	public Person(){

	}

	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String toString(){
		return "{'name':" + name + ",'age':" + age + "}";
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
