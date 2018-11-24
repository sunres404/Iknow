package service;
import java.util.List;
import bean.Essay;

public interface KindService {
	public List<Essay> getEssayByKind(int kind, int page, int order);
	//分类页面
}
