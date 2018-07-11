package com.gx.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.domain.Kind;
import com.gx.domain.Room;
import com.gx.service.RoomService;

/**
 * Servlet implementation class FindRoomByTimeAndKindServlet
 */
public class FindRoomByTimeAndKindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindRoomByTimeAndKindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomkind = request.getParameter("roomkind");
		String arrivaltime = request.getParameter("arrivaltime");
		String departuretime = request.getParameter("departuretime");
		RoomService service = new RoomService();
		List<Kind> kind=service.findAllRoomKind();
		List<Room> list = service.findRoomByTimeAndKind(arrivaltime,departuretime,roomkind);
		if(list==null)
			{
			request.setAttribute("msg", "很抱歉，该时段没有空余的房间~");
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			}
		else
			{
			request.setAttribute("RoomList", list);
			request.setAttribute("allRoomKind", kind);
		    request.getRequestDispatcher("/findroomlist.jsp").forward(request, response);
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
