package com.gx.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.domain.User;
import com.gx.service.UserService;
import com.gx.utils.CookieUtils;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String servletPath = request.getServletPath();
		if(servletPath.startsWith("/login")){
			chain.doFilter(request, response);
			return;
		}
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		if(loginUser!=null){
			chain.doFilter(request, response);
			return;
		}
		Cookie userCookie = CookieUtils.getCookie(request.getCookies(), "autoLoginCookie");
		if(userCookie==null){
			chain.doFilter(request, response);
			return;
		}
		String[] split=userCookie.getValue().split("@");
		String uid=split[0];
		String upd=split[1];
		User user=new User();
		user.setUid(uid);
		user.setUpd(upd);
		try{
			UserService service = new UserService();
			loginUser=service.login(user);
			if (loginUser != null) {
				String autoLogin = request.getParameter("autoLogin");
				if ("1".equals(autoLogin)) {
					Cookie autoLoginCookie = new Cookie("autoLoginCookie", user.getUid() + "@" + user.getUpd());
					autoLoginCookie.setPath("/");
					autoLoginCookie.setMaxAge(60 * 60 * 24 * 7);
					response.addCookie(autoLoginCookie);
				} else {
					Cookie autoLoginCookie = new Cookie("autoLoginCookie", "");
					autoLoginCookie.setPath("/");
					autoLoginCookie.setMaxAge(0);
					response.addCookie(autoLoginCookie);
				}
				if (loginUser.getState() == 0) {
					request.setAttribute("msg", "您的账号未激活，请尽快登陆邮箱进行激活！");
					response.sendRedirect(request.getContextPath() + "/login.jsp");
					chain.doFilter(request, response);
					return;
				} else {
					request.getSession().setAttribute("loginUser", loginUser);
					chain.doFilter(request, response);
					return;
				}
			} else {
				chain.doFilter(request, response);
				return;
			}
		}catch(Exception e){
			System.out.println("自动登录异常！已忽略自动登录！");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
