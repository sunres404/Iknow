package service.impl;

import dao.impl.UserDaoImpl;
import bean.User;
import service.RegisterService;

public class RegisterServiceImpl implements RegisterService {

	@Override
	public boolean isExistUser(String name) {
		// TODO Auto-generated method stub
		if(name == null) return true;
		UserDaoImpl userDao = new UserDaoImpl();
		return userDao.isExistUser(name);
		//测试该用户是否存在
	}

	@Override
	public User addUser(String name, String password, String kd) {
		// TODO Auto-generated method stub
		if(name == null || password == null)return null;
		//只要用户名或者密码未获取到，则返回未注册成功
		int kind;
		try{
			kind = Integer.parseInt(kd);
			if(kind != User.KIND_MANAGER)kind = User.KIND_USER;
		}catch(Exception e){
			kind = User.KIND_USER;
		}
		//只要不是管理员的请求，一律归纳为非管理员
		UserDaoImpl userDao = new UserDaoImpl();
		return userDao.addUser(name, password, kind);
	}

}
