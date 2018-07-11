package com.gx.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gx.domain.Guestinfo;
import com.gx.domain.PageBean;
import com.gx.domain.User;
import com.gx.service.RoomService;

/**
 * Servlet implementation class OrderListServlet
 */
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		RoomService service = new RoomService();
		String operator = user.getUid();
		String currentPageStr=request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage=Integer.parseInt(currentPageStr);
		int currentCount=10;
		PageBean <Guestinfo> pageBean=service.findAllGuestByOpe(operator,currentPage,currentCount);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/order_list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
