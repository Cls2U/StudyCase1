package com.gx.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.service.RoomService;

/**
 * Servlet implementation class AdminAllRoomListServlet
 */
public class AdminAllRoomListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAllRoomListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomService service = new RoomService();
		List<Map<String,Object>> mapList = service.findAllRoomInfo();
		//String msg=(String) request.getSession().getAttribute("msg");
		request.setAttribute("mapList", mapList);
		request.setAttribute("msg", request.getAttribute("msg"));
		request.getRequestDispatcher("/admin/room/list.jsp").forward(request, response);
		//request.getSession().removeAttribute("msg");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
