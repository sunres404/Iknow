package test;

import java.util.ArrayList;
import java.util.List;

import utils.Log;
import utils.SUtil;
import bean.Essay;
import bean.Page;

public class InfoTest {
	public static Page getTestPage(int nowPage){
		Page page = null;
		if(nowPage > 4)return null;
		List<Essay> essayList = null;
		essayList = new ArrayList<Essay>();
		switch(nowPage){
		case 1:
			essayList.add(new Essay(1, "afda", "asdfaf"));
			break;
		case 2:
			essayList.add(new Essay(2, "算法竞赛入门经典", "我的征途是星辰大海！"));
			essayList.add(new Essay(3, "第一行代码", "我所有的向往！"));
			break;
		case 3:
			essayList.add(new Essay(4, "algorithm", "hello world!"));
			break;
		}	
		page = new Page(essayList, nowPage, nowPage + 1);
		return page;
	}
	public static Page getTestPageByKind(int kind, int nowPage, int order){
		Log.debug("类型页面请求的参数为：", "kind= " + kind + " nowPage="
										+ nowPage + " order=" + order);
		Page page = null;
		if(nowPage > 4)return null;
		List<Essay> essayList = null;
		essayList = new ArrayList<Essay>();
		switch(nowPage){
		case 1:
			essayList.add(new Essay(1, "afdaf", "adaf"));
			break;
		case 2:
			essayList.add(new Essay(2, "算法竞赛入门经典", "我的征途是星辰大海！"));
			essayList.add(new Essay(3, "第一行代码", "我所有的向往！"));
			break;
		case 3:
			essayList.add(new Essay(4, "algorithm", "hello world!"));
			break;
		}	
		page = new Page(essayList, nowPage, nowPage + 1);
		return page;
	}
	
	public static Page getTestPageByEssayName(String name, int nowPage, int order){
		Log.debug("搜索结果页面请求的参数为：", "name= " + name + " nowPage="
										+ nowPage + " order=" + order);
		Page page = null;
		if(nowPage > 4)return null;
		List<Essay> essayList = null;
		essayList = new ArrayList<Essay>();
		switch(nowPage){
		case 1:
			//essayList.add(new Essay(1, "good", "永远相信美好的事情即将发生！"));
			essayList.add(new Essay(1, "good", "safasf"));
			break;
		case 2:
			essayList.add(new Essay(2, "算法竞赛入门经典", "我的征途是星辰大海！"));
			essayList.add(new Essay(3, "第一行代码", "我所有的向往！"));
			break;
		case 3:
			essayList.add(new Essay(4, "algorithm", "hello world!"));
			break;
		}	
		page = new Page(essayList, nowPage, nowPage + 1);
		return page;
	}
	
	public static Essay getEssayById(int id){
		Essay essay = null;
		Log.debug("根据Id来请求文章...", "id=" + id);
		switch(id){
		case 1:
//			essay = new Essay(1, "lne", "深入理解JVM", "永远相信美好的事情即将发生！", "2018-11-24",
//					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 99);
			essay = new Essay(1, "lne", "sdaffdaJVM", "asdfas", "2018-11-24",
					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 99);
			break;
		case 2:
			essay = new Essay(2, "terri", "asdfasf", "adfaf", "2018-11-24",
					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 99);
//			essay = new Essay(2, "terri", "算法竞赛入门经典", "我的征途是星辰大海！", "2018-11-24",
//					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 99);
			break;
		case 3:
			essay = new Essay(3, "小乞儿李", "第一行代码", "我所有的向往！", "2018-11-24",
					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 99);
			break;
		case 4:
			essay = new Essay(4, "不闻不问不听不在乎~", "algorithm", "hello world!", "2018-11-24",
					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 99);
			break;
		}
		if(essay != null){
			Log.debug("返回的id=", Integer.toString(id));
		}
		return essay;
	}
}
