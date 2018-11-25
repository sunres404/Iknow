package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Page;
import service.impl.MainServiceImpl;
import utils.Log;
import utils.SUtil;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
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
		String nowPage = request.getParameter("nowPage");
		Log.debug(this.getClass().getName(), "nowPage= " + nowPage);
		MainServiceImpl mainService = new MainServiceImpl();
		Page page = mainService.getEssayByEssaySeeCount(nowPage);
		HttpSession session = request.getSession();
		session.setAttribute(SUtil.SESSION_NAME_PAGE, page);
		if(page != null){
			Log.debug(this.getClass().getName(), "获取数据成功，即将跳转至main.jsp");
			Log.debug(this.getClass().getName(), page.getEssaies().get(0).getEssayName());
		}
		response.sendRedirect(SUtil.URL_PAGE_MAIN);
	}

}
