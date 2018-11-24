package dao;

import bean.User;

public interface UserDao {
	public User addUser(String name, String password, int kind);
	//增加一个用户，成功增加,失败null，注册日期获取系统当前时间
	public boolean isExistUser(String name);
	//根据用户名判断该用户名是否存在
	public User loginUser(String name, String password);
	//比对用户信息，无误则null，有误则返回user对象
	public boolean addSeeEssayCount(String name);
	//增加用户看文章的数量，每次+1
}