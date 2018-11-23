package bean;

public class Essay {
	public static int KIND_C = 0;
	public static int KIND_CPLUSPLUS = 1;
	public static int KIND_JAVA= 2;
	public static int KIND_PYTHON = 3;
	public static int KIND_ANDROID = 4;
	public static int KIND_HTML = 5;
	public static int KIND_SQL = 6;
	private int id;
	private String essayName;//文章名
	private String writerName;//作者id
	private String essayContent;//文章内容
	private String issueDate;//发布日期
	private String lastChange;//最后修改日期
	private int essayKind;//文章类型
	private int seeCount;// 浏览量
	Essay(String eName, String wName, String eContent, String iDate,
			String lChange, int eKind, int sCount){
		this.essayName = eName;
		this.writerName = wName;
		this.essayContent = eContent;
		this.issueDate = iDate;
		this.lastChange = lChange;
		this.essayKind = eKind;
		this.seeCount = sCount;
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
