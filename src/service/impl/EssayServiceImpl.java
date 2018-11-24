package service.impl;

import dao.impl.EssayDaoImpl;
import bean.Essay;
import service.EssayService;

public class EssayServiceImpl implements EssayService {

	@Override
	public Essay getEssayById(String id) {
		// TODO Auto-generated method stub
		Essay essay=null;
		try{
			int essayId = Integer.parseInt(id);
			EssayDaoImpl essayDao = new EssayDaoImpl();
			essay = essayDao.getEssayById(essayId);
			//根据id号来请求文章
		}catch(Exception e){
			essay = null;
		}finally{
			return essay;
		}
		
		
		//return null;
	}

}
