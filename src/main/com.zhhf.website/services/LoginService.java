package services;

import mongo.dao.user.UserDao;
import mongo.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/4/30.
 */
@Service
public class LoginService {

	@Autowired
	private UserDao userDao;

	public boolean isUserExist(User user){
		return userDao.exist(user);
	}
}
