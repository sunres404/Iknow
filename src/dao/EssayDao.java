package dao;

import java.util.List;

import bean.Essay;
import bean.Page;

public interface EssayDao {
	public Essay addEssay(String essayName, String writerName, String essayContent, 
			String otherInfo, int essayKind);
	//增加一篇文章, id弄成自增序列，就是他的id号主键,最后一次修改日期应该和当前日期一致，代码获取当前时间，浏览量置为0
	
	public Page getEssayByEssaySeeCount(int nowPage);
	//返回最热的几篇文章，浏览量最多的，第几页, Page.PAGE_COUNT就是一页能容纳的文章数量
	
	public Page getEssayByEssayName(String name, int nowPage, int order);
	//根据文章名字查询一篇文章, order为排序方式，注：符合匹配即可，提示： SQL like
	//返回一个文章列表给我显示，没有则返回null,后同
	
	public Page getEssayByEssayKind(int essayKind, int nowPage, int order);
	//根据文章类型来找文章
	
	public List<Essay> getEssayByWriterName(String name);
	//根据用户名来找文章
	
	public Essay getEssayById(int id);
	//根据文章id来查找一篇文章
	
	public Essay updateEssay(int id, String essayName, String essayContent, 
			String otherInfo, int essayKind);
	//更改一篇文章的信息，记住，先检测改文章是否存在,修改最后一次修改日期，其中最后一次修改日期获取系统当前时间
	
	public boolean addEssaySeeCount(int id);
	//增加一次阅读量
	
	public boolean deleteEssay(int id);
	//删除这一篇文章
}
