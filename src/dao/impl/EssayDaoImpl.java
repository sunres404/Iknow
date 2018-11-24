package dao.impl;

import java.util.List;

import bean.Essay;
import bean.Page;
import dao.EssayDao;

public class EssayDaoImpl implements EssayDao {

	@Override
	public Essay addEssay(String essayName, String writerName,
			String essayContent, String otherInfo, int essayKind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page getEssayByEssaySeeCount(int nowPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page getEssayByEssayName(String name,int nowPage, int order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page getEssayByEssayKind(int essayKind, int nowPage, int order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Essay> getEssayByWriterName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Essay updateEssay(int id, String essayName, String essayContent,
			String otherInfo, int essayKind) {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

}
