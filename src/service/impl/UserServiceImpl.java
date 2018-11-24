package service.impl;

import java.util.List;

import dao.impl.EssayDaoImpl;
import bean.Essay;
import service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public List<Essay> getEssayByWriterName(String name) {
		// TODO Auto-generated method stub
		if(name == null)return null;
		EssayDaoImpl essayDao = new EssayDaoImpl();
		return essayDao.getEssayByWriterName(name);
	}

}
