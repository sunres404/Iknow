package bean;

import java.util.List;

public class Page {
	public static int PAGE_COUNT = 5;//一页返回多少片文章
	//返回文章的排序类型
	public static int ORDER_NEW = 1;
	public static int ORDER_OLD = 2;
	public static int ORDER_HOT = 3;
	public static int ORDER_COLD = 4;
	public static int ORDER_RANDOM = 5;
	
	private List<Essay> essaies;//返回的文章列表，当前页面的文章列表
	private int nowPage;//当前页面
	private int maxPage;//最大多少页
	
	public List<Essay> getEssaies() {
		return essaies;
	}
	public void setEssaies(List<Essay> essaies) {
		this.essaies = essaies;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
}
