package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Essay;
import service.impl.EssayServiceImpl;
import utils.Log;
import utils.SUtil;

/**
 * Servlet implementation class EssayServlet
 */
public class EssayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EssayServlet() {
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
		String id = request.getParameter(SUtil.PARAMETER_ID);
		EssayServiceImpl essayService = new EssayServiceImpl();
		Essay essay = essayService.getEssayById(id);
		if(essay != null){
			Log.debug(this.getClass().getName(), "essayName=" + essay.getEssayName());
			HttpSession session = request.getSession();
			session.setAttribute(SUtil.SESSION_NAME_ESSAY, essay);
			response.sendRedirect(SUtil.URL_PAGE_ESSAY);
			//成功就转到文章页
		}else{
			Log.debug(this.getClass().getName(), "获取文章失败，id=" + id);
			response.sendRedirect(SUtil.URL_PAGE_MAIN);
			//跳转到首页
		}
	}

}
