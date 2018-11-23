package dao;

import java.util.List;
import bean.Essay;

public interface EssayDao {
	public boolean addEssay(String essayName, String writerName, String essayContent, 
			String issueDate, String lastChange, int essayKind, int seeCount);
	//增加一篇文章
	
	public List<Essay> getEssayByEssaySeeCount(int page);
	//返回最热的几篇文章，浏览量最多的，第几页
	
	public List<Essay> getEssayByEssayName(String name);
	//根据文章名字查询一篇文章，注：符合匹配即可，提示： SQL like
	//返回一个文章列表给我显示
	
	public List<Essay> getEssayByEssayKind(int essayKind, int page);
	//根据文章类型来找文章
	
	public List<Essay> getEssayByWriterName(String name, int page);
	//根据用户名来找文章
	
	public boolean updateEssay(int id, String essayName, String essayContent, 
			String lastChange, int essayKind);
	//更改一篇文章的信息，记住，先检测改文章是否存在
	
	public boolean addEssaySeeCount(int id);
	//增加一次阅读量
	
	public boolean deleteEssay(int id);
	//删除这一篇文章
}
