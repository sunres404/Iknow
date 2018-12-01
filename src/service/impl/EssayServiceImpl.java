package service.impl;

import dao.impl.EssayDaoImpl;
import bean.Essay;
import service.EssayService;
import utils.Log;

public class EssayServiceImpl implements EssayService {

	@Override
	public Essay getEssayById(String id) {
		// TODO Auto-generated method stub
		Essay essay = null;
		int essayId;
		if(id == null) return null;//如果参数为空的话
		try{
			Log.debug(this.getClass().getName(), "要获取的id= " + id);
			essayId = Integer.parseInt(id);
			//根据id号来请求文章
		}catch(Exception e){
			Log.error(this.getClass().getName(), e.getMessage());
			//出错输出出错信息
			return null;
		}
		
		EssayDaoImpl essayDao = new EssayDaoImpl();
		essay = essayDao.getEssayById(essayId);
		return essay;
	}

	@Override
	public boolean deleteEssayById(String id){
		int essayId;
		if(id == null) return false;//如果参数为空的话
		try{
			Log.debug(this.getClass().getName(), "要获取的id= " + id);
			essayId = Integer.parseInt(id);
			//根据id号来请求文章
		}catch(Exception e){
			Log.error(this.getClass().getName(), e.getMessage());
			//出错输出出错信息
			return false;
		}
		EssayDaoImpl essayDao = new EssayDaoImpl();
		return essayDao.deleteEssay(essayId);
	}
}
