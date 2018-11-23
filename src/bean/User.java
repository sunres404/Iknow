package bean;

public class User {
	public static int KIND_USER = 0;
	public static int KIND_MANAGER = 1;
	
	private String userName;
	private String userPassword;
	private int userKind;//用户的等级，0代表是普通用户，1代表是管理员
	
	User(String name, String password, int kind){
		this.userName = name;
		this.userPassword = password;
		this.userKind = kind;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserKind() {
		return userKind;
	}
	public void setUserKind(int userKind) {
		this.userKind = userKind;
	}
	
}
