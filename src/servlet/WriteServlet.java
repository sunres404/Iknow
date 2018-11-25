package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Essay;
import bean.User;
import service.WriteService;
import service.impl.WriteServiceImpl;
import utils.Log;
import utils.SUtil;

/**
 * Servlet implementation class WriteServlet
 */
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SUtil.SESSION_NAME_USER);
		String way = request.getParameter(SUtil.PARAMETER_WAY);
		String id  = request.getParameter(SUtil.PARAMETER_ID);
		String essayName = request.getParameter(SUtil.PARAMETER_ESSAYNAME);
		String essayContent = request.getParameter(SUtil.PARAMETER_ESSAYCONTENT);
		String otherInfo = request.getParameter(SUtil.PARAMETER_OTHERINFO);
		String essayKind = request.getParameter(SUtil.PARAMETER_ESSAYKIND);
		WriteServiceImpl writeService = new WriteServiceImpl();
		Essay essay = writeService.writeEssay(way, id, essayName, user.getUserName(),
				essayContent, otherInfo, essayKind);
		session.setAttribute(SUtil.SESSION_NAME_ESSAY, essay);
		int w;
		try{
			w = Integer.parseInt(way);
		}catch(Exception e){
			w = WriteService.WAY_WRITE_NEW_ESSAY;
			Log.debug(this.getClass().getName(), "转化way出错，way=" + way);
		}
		//暂时先靠这个来确定是
		if(w == WriteService.WAY_GET_ESSAY_ID){
			//获得一篇文章去修改...
			response.sendRedirect(SUtil.URL_PAGE_WRITE);
			
		}else if(w == WriteService.WAY_UPDATE_ESSAY){
			//更新一篇文章
			response.sendRedirect(SUtil.URL_PAGE_ESSAY);
		}else{
			//新增加了一篇文章
			response.sendRedirect(SUtil.URL_PAGE_ESSAY);
		}
	}
}
