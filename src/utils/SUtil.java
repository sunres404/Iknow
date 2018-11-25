package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class SUtil {
	public static String[] noFilterUrl = new String[]{};
	public static String URL_NAME = "/Iknow";
	public static String URL_PAGE_LOGIN = URL_NAME + "/pages/user/login.jsp";
	public static String URL_PAGE_REGISTER = URL_NAME + "/pages/user/register.jsp";
	public static String URL_PAGE_USER = URL_NAME + "/pages/user/user.jsp";
	public static String URL_PAGE_MAIN = URL_NAME + "/pages/essay/main.jsp";
	public static String URL_PAGE_KIND = URL_NAME + "/pages/essay/kind.jsp";
	public static String URL_PAGE_RESULT = URL_NAME + "/pages/essay/result.jsp";
	public static String URL_PAGE_ESSAY = URL_NAME + "/pages/essay/essay.jsp";
	public static String URL_PAGE_WRITE = URL_NAME + "/pages/essay/write.jsp";
	public static String URL_SERVLET_USER = URL_NAME + "/UserServlet";
	
	public static String REQUEST_USER_ERROR = "usererror";
	
	public static String SESSION_NAME_ESSAYNAME = "essayName";
	//这个是暂时性设置搜索名称的，正确的做法应该是传到page里面
	public static String SESSION_NAME_USER = "user";
	public static String SESSION_NAME_PAGE = "page";
	public static String SESSION_NAME_ESSAY = "essay";
	public static String SESSION_NAME_ESSAYLIST = "essaylist";
	
	public static String COOKIE_NAME_AUTOLOGIN = "autologin";
	public static String COOKIE_SPLIT = "@";
	
	public static String PARAMETER_WAY = "way";
	public static String PARAMETER_ID = "id";
	public static String PARAMETER_USERNAME = "userName";
	public static String PARAMETER_PASSWORD = "userPassowrd";
	public static String PARAMETER_ESSAYNAME = "essayName";
	public static String PARAMETER_KIND = "kind";
	public static String PARAMETER_ESSAYKIND = "essayKind";
	public static String PARAMETER_NOWPAGE = "nowPage";
	public static String PARAMETER_ORDER = "order";
	public static String PARAMETER_ESSAYCONTENT = "essayContent";
	public static String PARAMETER_OTHERINFO = "otherInfo";
	
	//public static String INFO_DEFAULT = "这个人很懒，什么都没写...";
	public static String INFO_DEFAULT = "adfafasfas";
	public static int PAGE_DEFAULT = 1;
	public static int COOKIE_MAXAGE = 60 * 24;
	
	
	public static String decode(String s){
		try {
			s = URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.debug("解码失败： ", s);
		}
		return s;
	}
	
	public static String encode(String s){
		try {
			s = URLEncoder.encode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.debug("编码失败： ", s);
		}
		return s;
	}
	
}
