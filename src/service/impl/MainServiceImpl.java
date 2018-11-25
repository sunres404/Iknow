package service.impl;

import dao.impl.EssayDaoImpl;
import bean.Page;
import service.MainService;
import utils.Log;

public class MainServiceImpl implements MainService {

	@Override
	public Page getEssayByEssaySeeCount(String np) {
		// TODO Auto-generated method stub
		int nowPage;
		try{
			nowPage = Integer.parseInt(np);
		}catch(Exception e){
			Log.error(this.getClass().getName(), "nowPage= " + np);
			nowPage = 1;
		}
		Log.debug(this.getClass().getName(), "主页面请求，nowPage=" + nowPage);
		EssayDaoImpl essayDao = new EssayDaoImpl();
		return essayDao.getEssayByEssaySeeCount(nowPage);
	}

}
