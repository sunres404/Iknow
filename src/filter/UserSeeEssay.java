package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.impl.UserServiceImpl;
import utils.Log;
import utils.SUtil;
import bean.User;

/**
 * Servlet Filter implementation class UserSeeEssay
 */
public class UserSeeEssay implements Filter {

    /**
     * Default constructor. 
     */
    public UserSeeEssay() {
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
		//用户看帖数量+1
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//session和cookies均没有用户，跳转到登陆界面
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(SUtil.SESSION_NAME_USER);//获取用户
		UserServiceImpl userService = new UserServiceImpl();
		if(userService.addSeeEssayCount(user.getUserName())){
			Log.debug(this.getClass().getName(), "成功增加" + user.getUserName() + "看帖次数！");
		}else{
			Log.debug(this.getClass().getName(), "增加" + user.getUserName() + "看帖次数失败！");
		}
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
