package dao.impl;

import java.util.ArrayList;
import java.util.List;

import test.InfoTest;
import test.TestWrite;
import utils.SUtil;
import bean.Essay;
import bean.Page;
import dao.EssayDao;

public class EssayDaoImpl implements EssayDao {

	@Override
	public Essay addEssay(String essayName, String writerName,
			String essayContent, String otherInfo, int essayKind) {
		// TODO Auto-generated method stub
		TestWrite testWrite = new TestWrite();
		return testWrite.addEssay(essayName, writerName, essayContent, otherInfo, essayKind);
	}

	@Override
	public Page getEssayByEssaySeeCount(int nowPage) {
		// TODO Auto-generated method stub
		return InfoTest.getTestPage(nowPage);
	}

	@Override
	public Page getEssayByEssayName(String name,int nowPage, int order) {
		// TODO Auto-generated method stub
		return InfoTest.getTestPageByEssayName(name, nowPage, order);
	}

	@Override
	public Page getEssayByEssayKind(int essayKind, int nowPage, int order) {
		// TODO Auto-generated method stub
		
		return InfoTest.getTestPageByKind(essayKind, nowPage, order);
	}

	@Override
	public List<Essay> getEssayByWriterName(String name) {
		// TODO Auto-generated method stub
		List<Essay> essayList = null;
		if(name.equals("小乞儿李")){
			essayList = new ArrayList<Essay>();
			essayList.add(new Essay(1, "深入理解JVM", "lne", "hello", "2018-08-07", 
					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 999));
			essayList.add(new Essay(2, "算法竞赛入门经典", "lne", "hello", "2018-08-07", 
					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 999));
			essayList.add(new Essay(3, "第一行代码", "lne", "hello", "2018-08-07", 
					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 999));
			essayList.add(new Essay(4, "algorithm", "lne", "hello", "2018-08-07", 
					"2018-11-25", SUtil.INFO_DEFAULT, Essay.KIND_ANDROID, 999));
		}
		return essayList;
	}

	@Override
	public Essay updateEssay(int id, String essayName, String essayContent,
			String otherInfo, int essayKind) {
		// TODO Auto-generated method stub
		TestWrite testWrite = new TestWrite();
		return testWrite.updateEssay(id, essayName, essayContent, otherInfo, essayKind);
	}

	@Override
	public boolean addEssaySeeCount(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEssay(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Essay getEssayById(int id) {
		// TODO Auto-generated method stub
		TestWrite testWrite = new TestWrite();
		return testWrite.getEssayById(id);
	}

}
