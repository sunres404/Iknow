package service;
import bean.Essay;

public interface WriteService {
	public static int WAY_GET_ESSAY_ID = 1;//更新并获取id更新后的信息
	public static int WAY_WRITE_NEW_ESSAY = 2;//新建一篇新文章
	public static int WAY_UPDATE_ESSAY = 3;
	
	/*
	public Essay getEssayById(String id);
	//修改和书写是一样的，如果没有则显示空
	
	public Essay addEssay(String essayName, String writerName, String essayContent, 
			String otherInfo, String essayKind);
	//增加一篇新文章，跳转到显示文章页
	
	public Essay updateEssay(String id, String essayName, String essayContent, 
			String otherInfo, String essayKind);
	//修改文章，跳转到显示文章页
	 */
	
	public Essay writeEssay(String way, String id, String essayName, String writerName,
			String essayContent, String otherInfo, String essayKind);
	//way=1 即update的时候，收集这些信息去更新
	//不存在way参数或者way参数为其他的时候，则新建一篇文章！
}
