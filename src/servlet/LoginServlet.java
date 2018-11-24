package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import service.impl.LoginServiceImpl;
import utils.Log;
import bean.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String name = request.getParameter("userName");
		String password = request.getParameter("userPassowrd");
		Log.debug(this.getClass().getName(), "登陆：name=" + name + " password=" + password);
		LoginServiceImpl loginService = new LoginServiceImpl();
		User user = loginService.loginUser(name, password);
		if(user != null){
			//存在该用户,跳转到我的页面
			Log.debug(this.getClass().getName(), "该用户存在！");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//在session域中设置用户的存在
			Cookie cookie = new Cookie("autologin", URLEncoder.encode(user.getUserName() +
					"@" + user.getUserPassword(), "UTF-8"));
			cookie.setMaxAge(60*24);//设定cookie有效期为一天
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
			//在cookie中添加了账号与密码
//			RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() 
//					+ "/pages/user/test.jsp");
//			Log.debug(this.getClass().getName(), request.getContextPath() + "/pages/user/test.jsp");
//			dispatcher.forward(request, response);
			response.sendRedirect("/Iknow/pages/user/test.jsp");
		}else{
			//不存在该用户
			Log.debug(this.getClass().getName(), "该用户不存在！");
		}
	}

}
