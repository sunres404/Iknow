package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import utils.Log;

/**
 * Servlet Filter implementation class SetEncodeFilter
 */
public class SetEncodeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SetEncodeFilter() {
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
		Log.debug(this.getClass().getName(), "设置编码utf-8...");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		CharacterRequest characterRequest = new CharacterRequest(req);
		//设置请求和响应的编码,拦截所有
		// pass the request along the filter chain
		chain.doFilter(characterRequest, resp);
	}

//get类的转码，转成utf-8
class CharacterRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	
	public CharacterRequest(HttpServletRequest request){
		super(request);
		this.request = request;
	}
	
	public String getParameter(String name){
		String value = super.getParameter(name);
		if(value == null){
			return null;
		}
		String method = super.getMethod();
		if("get".equalsIgnoreCase(method)){
			Log.debug(this.getClass().getName(), "get提交方式");
			try{
				value = new String(value.getBytes("iso-8859-1"), "utf-8");
			}catch(Exception e){
				Log.debug(this.getClass().getName(), e.getMessage());
			}
		}
		return value;
	}
}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
