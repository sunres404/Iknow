package test;

import java.util.ArrayList;
import java.util.List;

import utils.Log;
import utils.SUtil;
import bean.Essay;

public class TestWrite {
	public static List<Essay> essayList;
	static{
		essayList = new ArrayList<Essay>();
		essayList.add(new Essay(1, "lne", "asdfa", "adfasf", "2018-11-24",
				"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 99));
		essayList.add(new Essay(2, "terri", "算法竞赛入门经典", "我的征途是星辰大海！", "2018-11-24",
				"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 99));
		essayList.add(new Essay(3, "小乞儿李", "第一行代码", "我所有的向往！", "2018-11-24",
				"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 99));
		essayList.add(new Essay(4, "不闻不问不听不在乎~", "algorithm", "hello world!", "2018-11-24",
				"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 99));
	}
	
	public Essay getEssayById(int id){
		Essay essay = null;
		Log.debug(this.getClass().getName(), "list size is:" + essayList.size());
		if(id >= essayList.size() || id < 0)return null;
		essay = essayList.get(id);
		return essay;
	}
	
	public Essay updateEssay(int id, String essayName, String essayContent,
			String otherInfo, int essayKind){
		Essay essay = null;
		Log.debug(this.getClass().getName(), "list size is:" + essayList.size());
		if(id >= essayList.size() || id < 0)return null;
		essayList.get(id).setEssayName(essayName);
		essayList.get(id).setEssayContent(essayContent);
		essayList.get(id).setOtherInfo(otherInfo);
		essayList.get(id).setEssayKind(essayKind);
		essay = essayList.get(id);
		return essay;
	}
	
	public Essay addEssay(String essayName, String writerName,
			String essayContent, String otherInfo, int essayKind){
		Log.debug(this.getClass().getName(), "list size is:" + essayList.size());
		Essay essay = null;
		essay = new Essay(essayList.size(), essayName, writerName, essayContent,
				 "2018-11-22", "2018-11-25",otherInfo, essayKind, 99);
		essayList.add(essay);
		return essay;
	}
}
