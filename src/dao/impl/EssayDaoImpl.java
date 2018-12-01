package dao.impl;

import java.util.List;

import bean.Essay;
import bean.Page;
import bean.User;
import dao.EssayDao;
import utils.Log;
import utils.linkdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/*
 * 
 * 总共有九个参数，两个时间，一个自增的ID,一个浏览量
 * 
 * */
public class EssayDaoImpl implements EssayDao {

	@Override
	public Essay addEssay(String essayName, String writerName,
			String essayContent, String otherInfo, int essayKind) {
		//增加一篇文章, id弄成自增序列，就是他的id号主键,最后一次修改日期应该和当前日期一致，代码获取当前时间，浏览量置为0
		Connection coon = null;
		Statement stmt = null;
		ResultSet rs = null;
		Essay essay = new Essay(essayName,writerName,essayContent,otherInfo,essayKind);
		//这里不用判断是否有没有，因为增加文章ID号肯定不同，名称可以相同
		try{
			//获得数据库连接
			coon = linkdb.getConnection();
			//获得statement对象
			stmt = coon.createStatement();
			//发送sql语句
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String issueDate = sdf.format(new Date());//发布日期与最后修改日期
			String sql = "INSERT INTO article(essayName,writerName,essayContent,issueDate,lastChange,otherInfo,essayKind,seeCount)"+
						"VALUES('"
						+essayName
						+"','"
						+writerName
						+"','"
						+essayContent
						+"','"
						+issueDate
						+"','"
						+issueDate
						+"','"
						+otherInfo
						+"',"+essayKind+","+essay.getSeeCount()
						+")";
			int num = stmt.executeUpdate(sql);
			if(num > 0){
				essay.setIssueDate(issueDate);
				essay.setLastChange(issueDate);
				sql="select * from article where essayName='"+essayName+"'";
				rs = stmt.executeQuery(sql);
				if(rs.next()){
					essay.setId(rs.getInt("id"));
				}
				//给该用户文章数加一
				sql = "select * from user where username='"+writerName+"'";
				rs = stmt.executeQuery(sql);
				if(rs.next()){
				//结果集不为空，用户名存在
				int essayCount = rs.getInt("essayCount")+1;
				sql = "Update user set essayCount="+essayCount
						+" where username='"+writerName+"'";
				num = stmt.executeUpdate(sql);
				if(num > 0){
					return essay;
				}
			}
			return null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			linkdb.releaseConnection(coon);
		}
		return null;
	}

	@Override
	public Page getEssayByEssaySeeCount(int nowPage) {
		//当前页面为1就返回前1~page.PAGE_COUNT个文章，依次类推
		//返回最热的几篇文章，浏览量最多的，第几页, Page.PAGE_COUNT就是一页能容纳的文章数量
		Connection coon = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count = nowPage;
		
		try{
			//获得数据库连接
			coon = linkdb.getConnection();
			//获得statement对象
			stmt = coon.createStatement();
			//发送sql语句
			String sql = "SELECT COUNT(*) FROM article";
			rs = stmt.executeQuery(sql);
			rs.next();
			int allessay = rs.getInt(1);
			
			if((nowPage-1)>(allessay/bean.Page.PAGE_COUNT)){
				return null;
			}
			 sql="select * from article ORDER BY seeCount DESC";//通过浏览量来降序排列
			rs = stmt.executeQuery(sql);
			List<Essay> essay_list = new ArrayList();
			while(rs.next()){
				while(count!=1){
					for(int i=0;i<bean.Page.PAGE_COUNT;i++){
							rs.next();
						}
					count--;
					}//这个循环只在大循环第一次进入的时候才调用
				Essay essay = new Essay(rs.getInt("id"),rs.getString("essayName"),rs.getString("essayContent"));
				essay_list.add(essay);
				}
			Page page = new Page(essay_list,nowPage,allessay/bean.Page.PAGE_COUNT);
			return page;
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			linkdb.releaseConnection(coon);
		}
		return null;
	}

	@Override
	public Page getEssayByEssayName(String name,int nowPage, int order) {
		//根据文章名字查询一篇文章, order为排序方式，注：文章名字符合匹配即可，提示： SQL like
		//返回一个文章列表给我显示，没有则返回null,后同
		Log.debug(this.getClass().getName(), "name=" + name + "nowPage=" + nowPage + "order=" + order);
		Connection coon = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count = nowPage;
		
		try{
			//获得数据库连接
			coon = linkdb.getConnection();
			//获得statement对象
			stmt = coon.createStatement();
			//发送sql语句
			String sql = "SELECT COUNT(*) FROM article";
			rs = stmt.executeQuery(sql);
			rs.next();
			int allessay = rs.getInt(1);
			
			if((nowPage-1)>(allessay/bean.Page.PAGE_COUNT)){
				return null;
			}
			String sql_h = "select * from article WHERE essayName like '%"+name+"%' ";
			switch(order){
			case 0:
				sql=sql_h+"ORDER BY LastChange DESC";//ORDER_NEW
				break;
			case 1:
				sql=sql_h+"ORDER BY LastChange ASC";//ORDER_OLD
				break;
			case 2:
				sql=sql_h+"ORDER BY seeCount DESC";//ORDER_HOT
				break;
			case 3:
				sql=sql_h+"ORDER BY seeCount ASC";//ORDER_COLD
				break;
			case 4:
				sql=sql_h;//ORDER_RANDOM
				break;
			default:return null;
			}//获得完整的sql语句
			 
			rs = stmt.executeQuery(sql);
			List<Essay> essay_list = new ArrayList();
			while(rs.next()){
				while(count!=1){
					for(int i=0;i<bean.Page.PAGE_COUNT;i++){
							rs.next();
						}
					count--;
					}//这个循环只在大循环第一次进入的时候才调用
				Essay essay = new Essay(rs.getInt("id"),rs.getString("essayName"),rs.getString("essayContent"));
				essay_list.add(essay);
				}
			Page page = new Page(essay_list,nowPage,allessay/bean.Page.PAGE_COUNT);
			return page;
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			linkdb.releaseConnection(coon);
		}
		return null;
	}

	@Override
	public Page getEssayByEssayKind(int essayKind, int nowPage, int order) {
		Log.debug(this.getClass().getName(), "essayKind=" + essayKind + "nowPage=" + nowPage
				+ " order=" + order);
		//根据文章类型来找文章
		Connection coon = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count = nowPage;
		
		try{
			//获得数据库连接
			coon = linkdb.getConnection();
			//获得statement对象
			stmt = coon.createStatement();
			//发送sql语句
			String sql = "SELECT COUNT(*) FROM article";
			rs = stmt.executeQuery(sql);
			rs.next();
			int allessay = rs.getInt(1);
			
			if((nowPage-1)>(allessay/bean.Page.PAGE_COUNT)){
				return null;
			}
			String sql_h = "select * from article WHERE essayKind="+essayKind+" ";
			switch(order){
			case 0:
				sql=sql_h+"ORDER BY LastChange DESC";//ORDER_NEW
				break;
			case 1:
				sql=sql_h+"ORDER BY LastChange ASC";//ORDER_OLD
				break;
			case 2:
				sql=sql_h+"ORDER BY seeCount DESC";//ORDER_HOT
				break;
			case 3:
				sql=sql_h+"ORDER BY seeCount ASC";//ORDER_COLD
				break;
			case 4:
				sql=sql_h;//ORDER_RANDOM
				break;
			default:return null;
			}//获得完整的sql语句
			 
			rs = stmt.executeQuery(sql);
			List<Essay> essay_list = new ArrayList();
			while(rs.next()){
				while(count!=1){
					for(int i=0;i<bean.Page.PAGE_COUNT;i++){
							rs.next();
						}
					count--;
					}//这个循环只在大循环第一次进入的时候才调用
				Essay essay = new Essay(rs.getInt("id"),rs.getString("essayName"),rs.getString("essayContent"));
				essay_list.add(essay);
				}
			Page page = new Page(essay_list,nowPage,allessay/bean.Page.PAGE_COUNT);
			Log.debug(this.getClass().getName(), "我返回了一个有值的page");
			return page;
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			linkdb.releaseConnection(coon);
		}
		return null;
	}

	@Override
	public List<Essay> getEssayByWriterName(String name) {
		//根据用户名来找文章
		Connection coon = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			//获得数据库连接
			coon = linkdb.getConnection();
			//获得statement对象
			stmt = coon.createStatement();
			//发送sql语句
			String sql="select * from article where writerName='"+name+"'";

			rs = stmt.executeQuery(sql);
			List<Essay> essay_list = new ArrayList();
			while(rs.next()){
				//如果存在用户名
				 Essay essay = new Essay(rs.getInt("id"),rs.getString("essayName"),rs.getString("writerName")
						 ,rs.getString("essayContent"),rs.getString("issueDate"),rs.getString("lastChange")
						 ,rs.getString("otherInfo"),rs.getInt("essayKind"),rs.getInt("seeCount"));
				essay_list.add(essay);
			}
			return essay_list;
		
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			linkdb.releaseConnection(coon);
		}
		return null;
	}

	@Override
	public Essay getEssayById(int id) {
		//根据文章id来查找一篇文章
		Connection coon = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			//获得数据库连接
			coon = linkdb.getConnection();
			//获得statement对象
			stmt = coon.createStatement();
			//发送sql语句
			String sql="select * from article where id='"+id+"'";

			rs = stmt.executeQuery(sql);
			if(rs.next()){
				//如果存在id
				Essay essay = new Essay(rs.getInt("id"),rs.getString("essayName"),rs.getString("writerName")
						,rs.getString("essayContent"),rs.getString("issueDate"),rs.getString("lastChange")
						,rs.getString("otherInfo"),rs.getInt("essayKind"),rs.getInt("seeCount"));
				this.addEssaySeeCount(id);
				return essay;
			}
			
			return null;
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			linkdb.releaseConnection(coon);
		}
		return null;
	}


	@Override
	public Essay updateEssay(int id, String essayName, String essayContent,
			String otherInfo, int essayKind) {
		//更改一篇文章的信息，记住，先检测改文章是否存在,修改最后一次修改日期，其中最后一次修改日期获取系统当前时间
		Connection coon = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			//获得数据库连接
			coon = linkdb.getConnection();
			//获得statement对象
			stmt = coon.createStatement();
			//发送sql语句
			//判断有没有这个ID
			String sql = "select * from article where id="+id;
			rs = stmt.executeQuery(sql);
			if(!rs.next()){
				//结果集为空，返回null
				return null;
			}
			String writerName = rs.getString("writerName");
			String  issueDate = rs.getString("issueDate");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String lastChange = sdf.format(new Date());//发布日期与最后修改日期
			 sql = "Update article set "+
						"essayName='"
						+essayName
						+"',writerName='"
						+writerName
						+"',essayContent='"
						+essayContent
						+"',issueDate='"
						+issueDate
						+"',lastChange='"
						+lastChange
						+"',otherInfo='"
						+otherInfo
						+"',essayKind="+essayKind+",SeeCount="+0
						+" where id="+id;
			int num = stmt.executeUpdate(sql);
			if(num > 0){
				Essay essay = new Essay(essayName,writerName,essayContent,otherInfo,essayKind);
				essay.setIssueDate(issueDate);
				essay.setLastChange(lastChange);
				essay.setId(id);
				essay.setSeeCount(0);
				return essay;
			}
			return null;
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			linkdb.releaseConnection(coon);
		}
		return null;
	}

	@Override
	public boolean addEssaySeeCount(int id) {
		//增加一次阅读量
		Connection coon = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			//获得数据库连接
			coon = linkdb.getConnection();
			//获得statement对象
			stmt = coon.createStatement();
			//发送sql语句
			String sql="select * from article where id="+id;

			rs = stmt.executeQuery(sql);
			if(rs.next()){
				//如果存在id
				int new_seecount = rs.getInt("SeeCount")+1;
				System.out.println(new_seecount);
				sql = "Update article set "+
						"essayName='"
						+rs.getString("essayName")
						+"',writerName='"
						+rs.getString("writerName")
						+"',essayContent='"
						+rs.getString("essayContent")
						+"',issueDate='"
						+rs.getString("issueDate")
						+"',lastChange='"
						+rs.getString("lastChange")
						+"',otherInfo='"
						+rs.getString("otherInfo")
						+"',essayKind="+rs.getInt("essayKind")+",SeeCount="+new_seecount
						+" where id="+id;
				int num = stmt.executeUpdate(sql);
				if(num > 0){
					return true;
				}
			}
			return false;
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			linkdb.releaseConnection(coon);
		}
		return false;
	}

	@Override
	public boolean deleteEssay(int id) {
		//删除这一篇文章
		Connection coon = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			//获得数据库连接
			coon = linkdb.getConnection();
			//获得statement对象
			stmt = coon.createStatement();
			//发送sql语句
			String sql="select * from article where id="+id;
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				//如果存在id
				sql = "delete from article where id="+id;
				int num = stmt.executeUpdate(sql);
				if(num > 0){
					return true;
				}
			}
			return false;
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			linkdb.releaseConnection(coon);
		}
		return false;
	}
}







/*
package dao.impl;

import java.util.ArrayList;
import java.util.List;

import test.InfoTest;
import test.TestWrite;
import utils.Log;
import utils.SUtil;
import bean.Essay;
import bean.Page;
import dao.EssayDao;

public class EssayDaoImpl implements EssayDao {

	@Override
	public Essay addEssay(String essayName, String writerName,
			String essayContent, String otherInfo, int essayKind) {
		// TODO Auto-generated method stub
		TestWrite testWrite = new TestWrite();
		return testWrite.addEssay(essayName, writerName, essayContent, otherInfo, essayKind);
	}

	@Override
	public Page getEssayByEssaySeeCount(int nowPage) {
		// TODO Auto-generated method stub
		return InfoTest.getTestPage(nowPage);
	}

	@Override
	public Page getEssayByEssayName(String name,int nowPage, int order) {
		// TODO Auto-generated method stub
		return InfoTest.getTestPageByEssayName(name, nowPage, order);
	}

	@Override
	public Page getEssayByEssayKind(int essayKind, int nowPage, int order) {
		// TODO Auto-generated method stub
		
		return InfoTest.getTestPageByKind(essayKind, nowPage, order);
	}

	@Override
	public List<Essay> getEssayByWriterName(String name) {
		// TODO Auto-generated method stub
		List<Essay> essayList = null;
		if(name.equals("小乞儿李")){
			essayList = new ArrayList<Essay>();
			essayList.add(new Essay(1, "深入理解JVM", "lne", "hello", "2018-08-07", 
					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 999));
			essayList.add(new Essay(2, "算法竞赛入门经典", "lne", "hello", "2018-08-07", 
					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 999));
			essayList.add(new Essay(3, "第一行代码", "lne", "hello", "2018-08-07", 
					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 999));
			essayList.add(new Essay(4, "algorithm", "lne", "hello", "2018-08-07", 
					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 999));
		}
		return essayList;
	}

	@Override
	public Essay updateEssay(int id, String essayName, String essayContent,
			String otherInfo, int essayKind) {
		// TODO Auto-generated method stub
		Log.debug(this.getClass().getName(), "update id=" + id);
		TestWrite testWrite = new TestWrite();
		return testWrite.updateEssay(id, essayName, essayContent, otherInfo, essayKind);
	}

	@Override
	public boolean addEssaySeeCount(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEssay(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Essay getEssayById(int id) {
		// TODO Auto-generated method stub
		TestWrite testWrite = new TestWrite();
		return testWrite.getEssayById(id);
	}

}
*/