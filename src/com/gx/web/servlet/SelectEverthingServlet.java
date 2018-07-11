package com.gx.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gx.domain.Guestinfo;
import com.gx.domain.Kind;
import com.gx.domain.Room;
import com.gx.domain.User;
import com.gx.service.RoomService;

/**
 * Servlet implementation class SelectEverthingServlet
 */
public class SelectEverthingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectEverthingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword=request.getParameter("keyword");
		if(keyword.isEmpty()||keyword.trim().isEmpty()){
		    response.sendRedirect(request.getContextPath()+"/index");
		}
		else{
		RoomService service=new RoomService();
		List<Room> roomlist=service.findRoomByKeyword(keyword);
		List<Guestinfo> guestlist=service.findGuestinfoByKeyword(keyword);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		List<Kind> allRoomKind=service.findAllRoomKind();
		request.setAttribute("allRoomKind", allRoomKind);
		if(user.getSign()==2)
		{
			List<Guestinfo> ownguestlist = null;
			for(Guestinfo guest:guestlist)
			{
				if(guest.getOperator().equals(user.getUid()))
				{
					ownguestlist.add(guest);
				}
			}
			request.setAttribute("roomlist", roomlist);
			request.setAttribute("guestlist", ownguestlist);
			request.getRequestDispatcher("/find.jsp").forward(request, response);
			return;
		}
		request.setAttribute("roomlist", roomlist);
		request.setAttribute("guestlist", guestlist);
		request.getRequestDispatcher("/find.jsp").forward(request, response);
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
