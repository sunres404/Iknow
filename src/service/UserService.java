package service;

import java.util.List;
import bean.Essay;

public interface UserService {
	//其中能查看用用户页肯定已经获得了用户对象，因此只用查询其文章即可
	public List<Essay> getEssayByWriterName(String name);
}
