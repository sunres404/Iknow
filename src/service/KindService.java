package service;

import bean.Page;

public interface KindService {
	public Page getEssayByKind(int kind, int nowPage, int order);
	//分类页面
}
