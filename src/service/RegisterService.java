package service;

import bean.User;

public interface RegisterService {
	public boolean isExistUser(String name);
	public User addUser(String name, String password, int kind);
}
