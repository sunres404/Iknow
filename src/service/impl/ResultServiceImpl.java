package service.impl;


import dao.impl.EssayDaoImpl;
import bean.Page;
import service.ResultService;
import utils.Log;

public class ResultServiceImpl implements ResultService {

	@Override
	public Page getEssayByName(String name, String np, String od) {
		// TODO Auto-generated method stub
		if(name == null) return null;
		int nowPage;
		try{
			nowPage = Integer.parseInt(np);
		}catch(Exception e){
			e.printStackTrace();
			Log.error(this.getClass().getName(), "nowPage" + np);
			nowPage = 1;
		}
		
		int order;
		try{
			order = Integer.parseInt(od);
		}catch(Exception e){
			e.printStackTrace();
			Log.error(this.getClass().getName(), "order=" + od);
			order = Page.ORDER_HOT;
		}
		EssayDaoImpl essayDao = new EssayDaoImpl();
		return essayDao.getEssayByEssayName(name, nowPage, order);
	}

}
