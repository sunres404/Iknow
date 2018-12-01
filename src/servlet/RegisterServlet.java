package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import service.impl.RegisterServiceImpl;
import utils.Log;
import utils.SUtil;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String userName = request.getParameter(SUtil.PARAMETER_USERNAME);
		String password = request.getParameter(SUtil.PARAMETER_PASSWORD);
		String kind = request.getParameter(SUtil.PARAMETER_KIND);
		//此项为用户类型，普通用户与管理员
		RegisterServiceImpl registerService = new RegisterServiceImpl();
		User user = registerService.addUser(userName, password, kind);
		if(user != null){
			Log.debug(this.getClass().getName(), "成功注册，userName=" + user.getUserName());
			//成功注册
			HttpSession session = request.getSession();
			session.setAttribute(SUtil.SESSION_NAME_USER, user);
			response.sendRedirect(SUtil.URL_SERVLET_USER);
			//用户界面
		}else{
			//没有成功注册
			Log.debug(this.getClass().getName(), "未能成功注册userName=" + userName + "userPassword=" + password);
			response.sendRedirect(SUtil.URL_PAGE_REGISTER);
			//退回到注册页面
		}
	}

}
