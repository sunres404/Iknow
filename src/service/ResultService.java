package service;

import bean.Page;

public interface ResultService {
	public Page getEssayByName(String name, String nowPage, String order);
	//请求结果
}
