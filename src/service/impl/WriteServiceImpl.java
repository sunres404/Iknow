package service.impl;

import dao.impl.EssayDaoImpl;
import bean.Essay;
import service.WriteService;
import utils.Log;

public class WriteServiceImpl implements WriteService {

	@Override
	public Essay getEssayById(String id) {
		// TODO Auto-generated method stub
		Essay essay;
		if(id == null) return null;//如果参数为空的话
		try{
			Log.debug(this.getClass().getName(), "要获取的id= " + id);
			int essayId = Integer.parseInt(id);
			EssayDaoImpl essayDao = new EssayDaoImpl();
			essay = essayDao.getEssayById(essayId);
			//根据id号来请求文章
		}catch(Exception e){
			essay = null;
			Log.error(this.getClass().getName(), e.getMessage());
			//出错输出出错信息
			e.printStackTrace();
		}
		return essay;
	}

	@Override
	public Essay addEssay(String essayName, String writerName,
			String essayContent, String otherInfo, String esKd) {
		// TODO Auto-generated method stub
		if(essayName == null || writerName == null || essayContent == null
				|| esKd == null)return null;
		if(otherInfo == null)otherInfo = "这个人很懒，什么都没写...";
		int essayKind;
		try{
			essayKind = Integer.parseInt(esKd);
		}catch(Exception e){
			e.printStackTrace();
			Log.error(this.getClass().getName(), "essayKind= " + esKd);
			essayKind = Essay.KIND_ANDROID;
		}
		EssayDaoImpl essayDao = new EssayDaoImpl();
		return essayDao.addEssay(essayName, writerName, essayContent, otherInfo, essayKind);
	}

	@Override
	public Essay updateEssay(String id, String essayName, String essayContent,
			String otherInfo, String esKd) {
		// TODO Auto-generated method stub
		int essayId;
		int essayKind;
		if(id == null || essayName == null || essayContent == null || esKd == null)return null;
		try{
			essayId = Integer.parseInt(id);
			essayKind = Integer.parseInt(esKd);
		}catch(Exception e){
			e.printStackTrace();
			Log.error(this.getClass().getName(), "id=" + id + " kind=" + esKd);
			return null;
		}
		if(otherInfo == null) otherInfo = "这个人很懒，什么都没写";
		EssayDaoImpl essayDao = new EssayDaoImpl();
		return essayDao.updateEssay(essayId, essayName, essayContent, otherInfo, essayKind);
	}

}
