package com.gx.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gx.domain.User;
import com.gx.service.UserService;

/**
 * Servlet implementation class AdminDeletUserServlet
 */
public class AdminDeletUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeletUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		HttpSession session = request.getSession();
		User loginuser = (User) session.getAttribute("loginUser");
		if (loginuser == null) {
			response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
			return;
		}
		UserService service= new UserService();
		User user=service.findUserByUid(uid);
		if(loginuser.getSign()>=user.getSign()){
			String msg = "您的权限不够！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/adminAllUserList").forward(request, response);;
			return;
		}
		boolean isDeleteSuccess = service.deleteUserByUid(uid);
		if(isDeleteSuccess)
		{
			String msg = "删除成功！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/adminAllUserList").forward(request, response);;
			return;
		}else{
			String msg = "删除失败！请开发人员 13237304001 ";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/adminAllUserList").forward(request, response);;
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
