package service;

import bean.Essay;

public interface EssayService {
	public Essay getEssayById(String id);
	//文章内容详细页面
	public boolean deleteEssayById(String id);
}
