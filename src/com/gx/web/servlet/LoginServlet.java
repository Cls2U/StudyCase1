package com.gx.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.domain.User;
import com.gx.service.UserService;
import com.gx.utils.MyBeanUtils;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = MyBeanUtils.populate(User.class, request.getParameterMap());
		UserService service = new UserService();
		User loginUser = service.login(user);
		if (loginUser != null) {
			String autoLogin = request.getParameter("autoLogin");
			String rememberme=request.getParameter("rememberme");
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
			if("1".equals(rememberme)){
				Cookie remembermeCookie = new Cookie("remembermeCookie",user.getUid());
				remembermeCookie.setPath("/");
				remembermeCookie.setMaxAge(60*60*24*7);
				response.addCookie(remembermeCookie);
			}
			else{
				Cookie remembermeCookie = new Cookie("remembermeCookie", "");
				remembermeCookie.setPath("/");
				remembermeCookie.setMaxAge(0);
				response.addCookie(remembermeCookie);
			}
			if (loginUser.getState() == 0) {
				request.setAttribute("msg", "您的账号未激活，请尽快登陆邮箱进行激活！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			} else {
				request.getSession().setAttribute("loginUser", loginUser);
				response.sendRedirect(request.getContextPath() + "/index");
				return;
			}
		} else {
			request.setAttribute("msg", "用户名或密码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
