package service;
import bean.Essay;

public interface WriteService {
	public Essay getEssayById(String id);
	//修改和书写是一样的，如果没有则显示空
	
	public Essay addEssay(String essayName, String writerName, String essayContent, 
			String otherInfo, String essayKind);
	//增加一篇新文章，跳转到显示文章页
	
	public Essay updateEssay(String id, String essayName, String essayContent, 
			String otherInfo, String essayKind);
	//修改文章，跳转到显示文章页
}
