package service.impl;


import dao.impl.EssayDaoImpl;
import bean.Essay;
import bean.Page;
import service.KindService;
import utils.Log;

public class KindServiceImpl implements KindService {

	@Override
	public Page getEssayByKind(String kd, String np, String od) {
		// TODO Auto-generated method stub
		int kind;
		try{
			kind = Integer.parseInt(kd);
		}catch(Exception e){
			Log.error(this.getClass().getName(), "kind=" + kd);
			e.printStackTrace();
			kind = Essay.KIND_ANDROID;
		}
		
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
		
		String info = "kind=" + kind + " nowPage=" + nowPage + " order=" + order;
		
		Log.debug(this.getClass().getName(), info);
		
		EssayDaoImpl essayDao = new EssayDaoImpl();
		Page page = essayDao.getEssayByEssayKind(kind, nowPage, order);
		//根据文章类型，排序方式，以及当前页码来获取当前页的文章
		return page;//如果没有查询到，则返回空值
	}

}
