package service;
import java.util.List;
import bean.Essay;

public interface ResultService {
	public List<Essay> getEssayByName(String name, int page, int order);
	//请求结果
}
