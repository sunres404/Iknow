package bean;

public class User {
	public static int KIND_USER = 0;
	public static int KIND_MANAGER = 1;
	
	private String userName;
	private String userPassword;
	private String registerDate;//注册日期
	private int userKind;//用户的等级，0代表是普通用户，1代表是管理员
	private int essayCount;//用户发布文章数
	private int seeEssayCount;//用户看帖数量
	
	public User(String name, String password, int kind){
		//注册时用这个对象即可，注册时需要set注册日期
		this.userName = name;
		this.userPassword = password;
		this.userKind = kind;
		this.essayCount = 0;
		this.seeEssayCount =0;
	}
	
	public User(String name, String password, String registerDate, int kind, int essayCount, int seeEssayCount){
		//查询用户数据，需返回这个对象
		this.userName = name;
		this.userPassword = password;
		this.registerDate = registerDate;
		this.userKind = kind;
		this.essayCount = essayCount;
		this.seeEssayCount = seeEssayCount;
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
	
	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public int getUserKind() {
		return userKind;
	}
	public void setUserKind(int userKind) {
		this.userKind = userKind;
	}


	public int getEssayCount() {
		return essayCount;
	}


	public void setEssayCount(int essayCount) {
		this.essayCount = essayCount;
	}


	public int getSeeEssayCount() {
		return seeEssayCount;
	}


	public void setSeeEssayCount(int seeEssayCount) {
		this.seeEssayCount = seeEssayCount;
	}
	
}
