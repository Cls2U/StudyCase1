package com.gx.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.domain.Kind;
import com.gx.domain.Room;
import com.gx.domain.Sign;
import com.gx.service.RoomService;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomService service = new RoomService();
		//准备空房间列表--List<Room>
		List<Room> emptyRoomList=service.findEmptyRoomList();
		//准备已预定房间列表--List<Room>
		List<Room> reservationRoomList=service.findReservationRoomList();
		List<Kind> allRoomKind=service.findAllRoomKind();
		List<Sign> allRoomSign=service.findAllRoomSign();
	    request.setAttribute("emptyRoomList", emptyRoomList);
	    request.setAttribute("reservationRoomList", reservationRoomList);
	    request.setAttribute("allRoomKind", allRoomKind);
	    request.setAttribute("allRoomSign", allRoomSign);
	    request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
