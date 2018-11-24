package service;
import bean.Essay;

public interface WriteService {
	public Essay getEssayById(int id);
	//修改和书写是一样的，如果没有则显示空
	
	public Essay addEssay(String essayName, String writerName, String essayContent, 
			String otherInfo, int essayKind);
	//增加一篇新文章，跳转到显示文章页
	
	public Essay updateEssay(int id, String essayName, String essayContent, 
			String otherInfo, int essayKind);
	//修改文章，跳转到显示文章页
}
