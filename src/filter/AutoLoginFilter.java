package filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.impl.LoginServiceImpl;
import utils.Log;
import utils.SUtil;
import bean.User;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
public class AutoLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//session和cookies均没有用户，跳转到登陆界面
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(SUtil.SESSION_NAME_USER);//获取用户
		if(user == null){
			//不能获取到用户
			Log.debug(this.getClass().getName(), "session中没有user");
			Cookie[] cookies = req.getCookies();
			String autologin = null;
			for(int i=0;i<cookies.length; i++){
				if(SUtil.COOKIE_NAME_AUTOLOGIN.equals(SUtil.decode(cookies[i].getName()))){
					//取到了存放账号密码的cookie
					autologin = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
					break;
				}
			}
			if(autologin != null){
				//找到了账号密码
				Log.debug(this.getClass().getName(), "cookies中有账号密码");
				String[] parts = autologin.split(SUtil.COOKIE_SPLIT);
				String userName = parts[0];
				String userPassword = parts[1];
				LoginServiceImpl loginService = new LoginServiceImpl();
				user = loginService.loginUser(userName, userPassword);
				if(user != null){
					//检测的账号是正确的,将用户设置到session域中
					session.setAttribute(SUtil.SESSION_NAME_USER, user);
					Log.debug(this.getClass().getName(), "cookies账号和密码正确并设置了session");
				}else{
					//检测的账号或者密码错误
					Log.debug(this.getClass().getName(), "cookies中的账号密码是错误的");
					resp.sendRedirect(SUtil.URL_PAGE_LOGIN);
					//转到登陆页面
				}
				
			}else{
				//cookies 中没有账号密码
				Log.debug(this.getClass().getName(), "cookies没有账号密码");
				resp.sendRedirect(SUtil.URL_PAGE_LOGIN);
				//转到登陆页面
			}
		}else{
			Log.debug(this.getClass().getName(), "session中有user");
		}
		//可以获取到用户就直接放行
		// pass the request along the filter chain
		chain.doFilter(req, resp);
	}
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
