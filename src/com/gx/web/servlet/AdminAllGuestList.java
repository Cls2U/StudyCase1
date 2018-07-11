package com.gx.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.domain.Guestinfo;
import com.gx.domain.OrderState;
import com.gx.service.RoomService;

/**
 * Servlet implementation class AdminAllGuestList
 */
public class AdminAllGuestList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAllGuestList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomService service = new RoomService();
		List<Guestinfo> list = service.findAllGuest();
		List<OrderState>States = service.findAllOrderState();
		request.setAttribute("States", States);
		request.setAttribute("list", list);
		request.setAttribute("msg", request.getAttribute("msg"));
		request.getRequestDispatcher("/admin/order/list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
