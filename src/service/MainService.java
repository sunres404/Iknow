package service;

import java.util.List;

import bean.Essay;

public interface MainService {
	public List<Essay> getEssayByEssaySeeCount(int page);
	//首页展示最热的文章
}
