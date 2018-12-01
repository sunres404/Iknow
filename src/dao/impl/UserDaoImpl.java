package dao.impl;

import bean.User;
import dao.UserDao;
import utils.Log;
import utils.linkdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDaoImpl implements UserDao {

	@Override
	public User addUser(String name, String password, int kind) {
		//增加一个用户，成功增加,失败null，注册日期获取系统当前时间
		Connection coon = null;
		Statement stmt = null;
		
		User user = new User(name,password,kind);
		Log.debug(this.getClass().getName(), "name=" + name + " password" + password
				+ " kind=" + kind);
		boolean b = isExistUser(name);
		
		if(b == true){
			Log.debug(this.getClass().getName(), "用户名已经存在，不能再插入");
			return null;
		}
		
		try{
			//获得数据库连接
			coon = linkdb.getConnection();
			//获得statement对象
			stmt = coon.createStatement();
			//发送sql语句
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String registerDate = sdf.format(new Date());//日期
			String sql = "INSERT INTO user(username,password,registerDate,level,seeEssayCount,essayCount)"+
						"VALUES('"
						+name
						+"','"
						+password
						+"','"
						+registerDate
						+"',"
						+0
						+","
						+0
						+","
						+0+")";
			int num = stmt.executeUpdate(sql);
			if(num > 0){
				user.setRegisterDate(registerDate);
				Log.debug(this.getClass().getName(), "插入成功");
				return user;
			}
			Log.debug(this.getClass().getName(), "没有插入成功");
			return null;
			
			
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			linkdb.releaseConnection(coon);
		}
		return null;
	}

	@Override
	public boolean isExistUser(String name) {
		//根据用户名判断该用户名是否存在
		Connection coon = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			//获得数据库连接
			coon = linkdb.getConnection();
			//获得statement对象
			stmt = coon.createStatement();
			String sql="select * from user where username='"+name+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				//结果集不为空，用户名存在
				//System.out.println("用户名(已存在):"+rs.getString("username"));
				return true;
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			linkdb.releaseConnection(coon);
		}
		return false;
	}

	@Override
	public User loginUser(String name, String password) {
		//比对用户信息，无误则返回user对象，有误则null
		Connection coon = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			//获得数据库连接
			coon = linkdb.getConnection();
			//获得statement对象
			stmt = coon.createStatement();
			String sql="select * from user where username='"+name+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				//用户名存在
				//System.out.println(rs.getString("username")+" "+rs.getString("password"));
				//System.out.println(name+" "+password);
				if(rs.getString("username").equals(name) && rs.getString("password").equals(password)){
					User user = new User(name,password,rs.getInt("level"));
					user.setEssayCount(rs.getInt("essayCount"));
					user.setRegisterDate(rs.getString("registerDate"));
					user.setSeeEssayCount(rs.getInt("seeEssayCount"));
					//System.out.println("匹配成功");
					return user;
				}
			}
			else{
				//System.out.println("用户名不已存在");
			}
			//System.out.println("匹配失败");
			return null;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			linkdb.releaseConnection(coon);
		}
		return null;
	}

	@Override
	public boolean addSeeEssayCount(String name) {
		//增加用户看文章的数量，每次+1
		Connection coon = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			//获得数据库连接
			coon = linkdb.getConnection();
			//获得statement对象
			stmt = coon.createStatement();
			String sql="select * from user where username='"+name+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				//结果集不为空，用户名存在
				String password = rs.getString("password");
				int userKind = rs.getInt("level");
				String registerDate = rs.getString("registerDate"); 
				int essayCount = rs.getInt("essayCount");
				int seeEssayCount = rs.getInt("seeEssayCount")+1;
				//Update table1 set user=?,password=?,age=? where id=?
				sql = "Update user set username='"+name+"',password='"+password+"',level="+userKind
						+",registerDate='"+registerDate+"',essayCount="+essayCount
						+",seeEssayCount="+seeEssayCount+" where username='"+name+"'";
				int num = stmt.executeUpdate(sql);
				if(num > 0){
					return true;
				}
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			linkdb.releaseConnection(coon);
		}
		return false;
	}


}



/*
package dao.impl;

import bean.User;
import dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public User addUser(String name, String password, int kind) {
		// TODO Auto-generated method stub
		User user = null;
		if(!"lne".equals(name)){
			user = new User(name, password, "2018-08-07", User.KIND_USER, 1, 22);
		}
		return user;
	}

	@Override
	public boolean isExistUser(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User loginUser(String name, String password) {
		// TODO Auto-generated method stub
		User user = null;
		if(name.equals("小乞儿李") && password.equals("小乞儿李")){
			user = new User(name, password, "2018-11-24", User.KIND_MANAGER, 9, 99);
		}else if(name.equals("lne") && password.equals("lne")){
			user = new User(name, password, "2018-08-07", User.KIND_USER, 1, 22);
		}
		return user;
	}

	@Override
	public boolean addSeeEssayCount(String name) {
		// TODO Auto-generated method stub
		return false;
	}


}
*/