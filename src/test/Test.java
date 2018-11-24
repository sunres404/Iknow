package test;

import bean.User;
import utils.Log;

public class Test {
	
	public static void main(String[] args){
		A a = new A();
		a.test();
		System.out.print("aaa");
		User u = new User("1", ":", 1);
		
	}
}

class A{
	public void test(){
		Log.debug(this.getClass().getName(), "要获取的id= ");
		try{
			int a = Integer.parseInt(null);
		}catch(Exception e){
			//e.printStackTrace();
			
			Log.error(this.getClass().getName(), "要获取的id= " + e.getMessage());
			return;
		}
		System.out.print("bbb");
	}
}
