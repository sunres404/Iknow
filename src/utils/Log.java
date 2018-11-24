package utils;

public class Log {
	public static void debug(String name, String info){
		System.out.println(name + " : " + info);
	}
	public static void error(String name, String info){
		System.err.println(name + " : " + info);
	}
}
