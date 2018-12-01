package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Essay;
import bean.User;
import service.impl.LoginServiceImpl;
import service.impl.UserServiceImpl;
import utils.Log;
import utils.SUtil;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		if(user != null){
			LoginServiceImpl loginService = new LoginServiceImpl();
			user = loginService.loginUser(user.getUserName(), user.getUserPassword());
			session.setAttribute(SUtil.SESSION_NAME_USER, user);
			Log.debug(this.getClass().getName(), "获取name=" + user.getUserName() + "所写文章信息");
			UserServiceImpl userService = new UserServiceImpl();
			List<Essay> essayList = userService.getEssayByWriterName(user.getUserName());
			session.setAttribute(SUtil.SESSION_NAME_ESSAYLIST, essayList);
			Log.debug(this.getClass().getName(), "获取完将跳转至" + SUtil.URL_PAGE_USER);
			response.sendRedirect(SUtil.URL_PAGE_USER);
		}
	}

}
