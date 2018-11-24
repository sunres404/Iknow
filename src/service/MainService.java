package service;

import bean.Page;

public interface MainService {
	public Page getEssayByEssaySeeCount(int nowPage);
	//首页展示最热的文章
}
