package service;

import bean.Page;

public interface ResultService {
	public Page getEssayByName(String name, int nowPage, int order);
	//请求结果
}
