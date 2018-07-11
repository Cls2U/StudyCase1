package com.gx.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.domain.User;
import com.gx.service.UserService;
import com.gx.utils.MyBeanUtils;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = MyBeanUtils.populate(User.class, request.getParameterMap());
		UserService service = new UserService();
		User loginUser = service.login(user);
		if (loginUser != null) {
			if (loginUser.getState() == 0) {
				request.setAttribute("msg", "您的账号未激活，请尽快登陆邮箱进行激活！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			} else if(loginUser.getSign()==0) {
				request.getSession().setAttribute("loginUser", loginUser);
				request.getRequestDispatcher("/admin/home.jsp").forward(request, response);;
				return;
			}else
			{
				request.setAttribute("msg", "您的账号没有权限进入后台！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
		} else {
			request.setAttribute("msg", "用户名或密码错误！");
			request.getRequestDispatcher("/admin.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
