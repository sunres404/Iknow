package service.impl;

import dao.impl.UserDaoImpl;
import bean.User;
import service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public User loginUser(String name, String password) {
		// TODO Auto-generated method stub
		if(name==null || password==null)return null;
		//任何参数未获取到
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.loginUser(name, password);
		return user;
	}

}
