package bean;

public class Essay {
	public static int KIND_C = 0;
	public static int KIND_CPLUSPLUS = 1;
	public static int KIND_JAVA= 2;
	public static int KIND_PYTHON = 3;
	public static int KIND_ANDROID = 4;
	public static int KIND_HTML = 5;
	public static int KIND_SQL = 6;

	private int id; //文章的id号， sql里面自增长的
	private String essayName;//文章名
	private String writerName;//用户名
	private String essayContent;//文章内容.length测字数
	private String issueDate;//发布日期
	private String lastChange;//最后修改日期
	private String otherInfo;//其他信息
	private int essayKind;//文章类型
	private int seeCount;// 浏览量
	public Essay(String eName, String wName, String eContent, String oInfo, int eKind){
		//新增一篇文章用这个，记得set 发布日期以及最后一次修改日期一致
		this.essayName = eName;
		this.writerName = wName;
		this.essayContent = eContent;
		this.otherInfo = oInfo;
		this.essayKind = eKind;
		this.seeCount = 0;
	}
	
	public Essay(int id, String eName, String wName, String eContent, String iDate,
			String lChange, String oInfo, int eKind, int sCount){
		//查询返回的对象要是这个
		this.id = id;
		this.essayName = eName;
		this.writerName = wName;
		this.essayContent = eContent;
		this.issueDate = iDate;
		this.lastChange = lChange;
		this.otherInfo = oInfo;
		this.essayKind = eKind;
		this.seeCount = sCount;
	}
	
	public Essay(int id, String name, String content){
		//nowPage请求时，返回Page里面List里面的对象此构造
		this.id = id;
		this.essayName = name;
		this.essayContent = content;//这个只用展示前几字Page.PAGE_ESSAY_COUNT,多余的去掉
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEssayName() {
		return essayName;
	}
	public void setEssayName(String essayName) {
		this.essayName = essayName;
	}
	
	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getEssayContent() {
		return essayContent;
	}

	public void setEssayContent(String essayContent) {
		this.essayContent = essayContent;
	}
	
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getLastChange() {
		return lastChange;
	}
	public void setLastChange(String lastChange) {
		this.lastChange = lastChange;
	}
	
	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public int getEssayKind() {
		return essayKind;
	}
	public void setEssayKind(int essayKind) {
		this.essayKind = essayKind;
	}
	public int getSeeCount() {
		return seeCount;
	}
	public void setSeeCount(int seeCount) {
		this.seeCount = seeCount;
	}

}
