package test;

import utils.Log;

public class Test {
	
	public static void main(String[] args){
		A a = new A();
		a.test();
	}
}

class A{
	public void test(){
		Log.debug(this.getClass().getName(), "要获取的id= ");
		Log.error(this.getClass().getName(), "要获取的id= ");
	}
}
