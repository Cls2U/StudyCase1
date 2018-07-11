package com.gx.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.domain.Guestinfo;
import com.gx.service.RoomService;

/**
 * Servlet implementation class CheckGuestinfoServlet
 */
public class CheckGuestinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckGuestinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gid = request.getParameter("gid");
		String roomnum = request.getParameter("roomnum");
		RoomService service = new RoomService();
		service.updateGuestStateByGid(gid,3);
		String rid = service.findRidByRoomnum(roomnum);
		service.updateRoomSign(rid,3);
		Guestinfo guest=service.findGuestByGid(gid);
		String sex=null;
		if(guest.getSex().equals("male"))
			sex="男士";
		else
			sex="女士";
		String msg=guest.getName()+sex+"已成功入住，预定时间为"+guest.getArrivaltime()+"--"+guest.getDeparturetime()+",请注意退房时间。";
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/index").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
