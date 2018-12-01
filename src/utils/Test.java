package utils;

import dao.impl.UserDaoImpl;
import dao.impl.EssayDaoImpl;
import bean.User;
import bean.Page;

import java.util.List;

import bean.Essay;

public class Test {
	public static void main(String args[]){
		/*
		UserDaoImpl cz = new UserDaoImpl();
		
		User user = cz.addUser("1233", "1233", 0);
		
		System.out.println(user.getUserKind());
		System.out.println(user.getUserName());
		System.out.println(user.getUserPassword());
		
		boolean b = cz.isExistUser("abcd");
		System.out.println(b);
		
		User user = cz.loginUser("admin0","admin");
		
		boolean c = cz.addSeeEssayCount("admin");
		System.out.println(c);
		*/
		
		EssayDaoImpl esscz= new EssayDaoImpl();
		/*
		String essayContent="abcd"
				+ "\n"
				+ "efgh"
				+ "hijk";
				
		//Essay essay = esscz.addEssay("text2", "admin", essayContent, "None", 2);
		List<Essay> essay_list = esscz.getEssayByWriterName("admin");
		for(Essay essay : essay_list) {
		    System.out.println(essay.getEssayName()+" "+essay.getWriterName()+" "+essay.getEssayContent());
		}
		//System.out.println("print:");
		*/
		//Page b =  esscz.getEssayByEssayName("的",1,3);
		Essay essay = esscz.addEssay("newTest3", "admin1","再测试一下","测试员",1 );
		System.out.println(essay.getLastChange()+" "+essay.getIssueDate());
		System.out.println(essay.getEssayContent());
		//boolean b = esscz.deleteEssay(4);
		//System.out.println(b.getEssaies().get(0).getEssayName()+" "+b.getEssaies().get(1).getEssayName());
		
	}
}
