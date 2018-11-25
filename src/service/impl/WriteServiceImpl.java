package service.impl;

import dao.impl.EssayDaoImpl;
import bean.Essay;
import service.WriteService;
import utils.Log;

public class WriteServiceImpl implements WriteService {

	
	
	private Essay getEssayById(String id) {
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


	private Essay addEssay(String essayName, String writerName,
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

	private Essay updateEssay(String id, String essayName, String essayContent,
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
	
	
	
	@Override
	public Essay writeEssay(String w, String id, String essayName, String writerName,
			String essayContent, String otherInfo, String essayKind){
		//way=1 即update的时候，收集这些信息去更新
		//不存在way参数或者way参数为其他的时候，则新建一篇文章！
		Essay essay = null;
		int way;
		try{
			way = Integer.parseInt(w);
		}catch(Exception e){
			Log.error(this.getClass().getName(), e.getMessage());
			way = WAY_WRITE_NEW_ESSAY;
			Log.debug(this.getClass().getName(), "没有way或者way=" + way + "默认新建文章");
		}
		if(way == WAY_GET_ESSAY_ID){
			//获得一篇文章
			Log.debug(this.getClass().getName(), "获得一篇文章");
			essay = this.getEssayById(id);
		}else if(way == WAY_UPDATE_ESSAY){
			//更新一篇文章
			Log.debug(this.getClass().getName(), "更新一篇文章");
			essay = this.updateEssay(id, essayName, essayContent, otherInfo, essayKind);
		}else{
			//默认新则增加了一篇文章
			Log.debug(this.getClass().getName(), "新增加了一篇文章");
			essay = this.addEssay(essayName, writerName, essayContent, otherInfo, essayKind);
		}
		if(essay != null){
			Log.debug(this.getClass().getName(),
					"返回的essay不为空，essayName=" + essay.getEssayName());
		}
		return essay;
	}
	

}
