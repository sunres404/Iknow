package dao;

public interface UserDao {
	public boolean addUser(String name, String password, int kind);
	//增加一个用户，成功增加true,失败false
	public boolean isExistUser(String name);
	//根据用户名判断该用户是否存在
	public boolean loginUser(String name, String password, int kind);
	//比对用户信息，无误则true，有误则false
}