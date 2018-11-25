package dao.impl;

import bean.User;
import dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public User addUser(String name, String password, int kind) {
		// TODO Auto-generated method stub
		User user = null;
		if(!"lne".equals(name)){
			user = new User(name, password, "2018-08-07", User.KIND_USER, 1, 22);
		}
		return user;
	}

	@Override
	public boolean isExistUser(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User loginUser(String name, String password) {
		// TODO Auto-generated method stub
		User user = null;
		if(name.equals("小乞儿李") && password.equals("小乞儿李")){
			user = new User(name, password, "2018-11-24", User.KIND_MANAGER, 9, 99);
		}else if(name.equals("lne") && password.equals("lne")){
			user = new User(name, password, "2018-08-07", User.KIND_USER, 1, 22);
		}
		return user;
	}

	@Override
	public boolean addSeeEssayCount(String name) {
		// TODO Auto-generated method stub
		return false;
	}


}
