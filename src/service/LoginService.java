package service;

import bean.User;

public interface LoginService {
	//已经取出参数来啦的那种，但是参数判断是否为空之类的还是靠他来判断
	public User loginUser(String name, String password);
	//有次用户返回User,没有null
	
}
