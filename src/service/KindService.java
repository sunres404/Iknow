package service;

import bean.Page;

public interface KindService {
	public Page getEssayByKind(String kind, String nowPage, String order);
	//分类页面
}
