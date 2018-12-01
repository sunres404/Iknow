package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Page;
import service.impl.KindServiceImpl;
import utils.Log;
import utils.SUtil;

/**
 * Servlet implementation class KindServlet
 */
public class KindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KindServlet() {
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
		String kind = request.getParameter(SUtil.PARAMETER_KIND);
		String nowPage = request.getParameter(SUtil.PARAMETER_NOWPAGE);
		String order = request.getParameter(SUtil.PARAMETER_ORDER);
		Log.debug(this.getClass().getName(), "kind=" + kind + " nowPage="
												+ nowPage + " order=" + order);
		session.setAttribute(SUtil.SESSION_NAME_KIND, kind);
		session.setAttribute(SUtil.SESSION_NAME_ORDER, order);
		KindServiceImpl kindService = new KindServiceImpl();
		Page page = kindService.getEssayByKind(kind, nowPage, order);
		if(page != null){
			session.setAttribute(SUtil.SESSION_NAME_PAGE, page);
			Log.debug(this.getClass().getName(), "page不为空，将重定向到kind.jsp");
		}else{
			Log.debug(this.getClass().getName(), "page为空");
		}
		response.sendRedirect(SUtil.URL_PAGE_KIND);
	}

}
