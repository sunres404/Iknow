package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.Log;
import utils.SUtil;

/**
 * Servlet Filter implementation class DeleteEditEssay
 */
public class DeleteEditEssay implements Filter {

    /**
     * Default constructor. 
     */
    public DeleteEditEssay() {
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
		//这一条是删除想要编辑的Essay
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//session和cookies均没有用户，跳转到登陆界面
		String uri = req.getRequestURI();
		Log.debug(this.getClass().getName(), "");
		List<String> noFilterUrls = new ArrayList<String>(Arrays.asList(SUtil.noFilterUrl_deleteEditEssay));
		if(!noFilterUrls.contains(uri)){
			HttpSession session = req.getSession();
			if(session.getAttribute(SUtil.SESSION_NAME_WRITEESSAY) !=null){
				session.removeAttribute(SUtil.SESSION_NAME_WRITEESSAY);
				Log.debug(this.getClass().getName(), "非写作页面，存在writeEssay，删除session！");
			}else{
				Log.debug(this.getClass().getName(), "非写作页面，不存在writeEssay，不删除session！");
			}
			
			
		}
		// pass the request along the filter chain
		
		//当离开了编辑的页面时，就要删掉想要编辑的页面。。。还没写
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
