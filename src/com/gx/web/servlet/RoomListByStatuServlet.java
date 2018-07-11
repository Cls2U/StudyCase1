package com.gx.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.domain.Kind;
import com.gx.domain.PageBean;
import com.gx.domain.Room;
import com.gx.service.RoomService;

/**
 * Servlet implementation class RoomListByStatuServlet
 */
public class RoomListByStatuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomListByStatuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomService service = new RoomService();
		String sign = request.getParameter("sign");
		String currentPageStr=request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage=Integer.parseInt(currentPageStr);
		int currentCount=10;
		
		PageBean<Room> pageBean=service.findRoomBySign(sign,currentPage,currentCount);
		request.setAttribute("pageBean", pageBean);
		List<Kind> allRoomKind=service.findAllRoomKind();
		request.setAttribute("allRoomKind", allRoomKind);
		request.setAttribute("sign", sign);
		List<Room> historyRoomList = new ArrayList<Room>();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie : cookies){
				if("rids".equals(cookie.getName())){
					String rids=cookie.getValue();
					String[] split=rids.split("-");
					for(String rid:split){
						Room room=service.findRoomByRid(rid);
						historyRoomList.add(room);
					}
				}
			}
		}
		request.setAttribute("roomstate", service.findAllRoomSign());
		request.setAttribute("historyRoomList", historyRoomList);
		request.getRequestDispatcher("/roomlistbystatu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
