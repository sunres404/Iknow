package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Page;
import service.impl.ResultServiceImpl;
import utils.Log;
import utils.SUtil;

/**
 * Servlet implementation class ResultServlet
 */
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
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
		String essayName = request.getParameter(SUtil.PARAMETER_ESSAYNAME);
		String nowPage = request.getParameter(SUtil.PARAMETER_NOWPAGE);
		String order = request.getParameter(SUtil.PARAMETER_ORDER);
		Log.debug(this.getClass().getName(), "name=" + essayName + "nowPage=" + nowPage +
				nowPage + " order=" + order);
		ResultServiceImpl resultService = new ResultServiceImpl();
		Page page = resultService.getEssayByName(essayName, nowPage, order);
		HttpSession session = request.getSession();
		session.setAttribute(SUtil.SESSION_NAME_ESSAYNAME, essayName);
		//这个是暂时性设置搜索名称的，正确的做法应该是传到page里面
		session.setAttribute(SUtil.SESSION_NAME_PAGE, page);
		if(page != null){
			session.setAttribute(SUtil.SESSION_NAME_ESSAY, essayName);
			Log.debug(this.getClass().getName(), "请求结果page对象不为空,重定向到result.jsp");
		}
		
		response.sendRedirect(SUtil.URL_PAGE_RESULT);
	}

}
