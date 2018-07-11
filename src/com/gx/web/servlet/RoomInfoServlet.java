package com.gx.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.domain.Kind;
import com.gx.domain.Room;
import com.gx.service.RoomService;

/**
 * Servlet implementation class RoomInfoServlet
 */
public class RoomInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("rid");
		RoomService service = new RoomService();
		Room room =service.findRoomByRid(rid);
		List<Kind> kind=service.findAllRoomKind();
		Integer roomstate=service.findRoomSign(rid);
		if(roomstate==4){
			String msg = "您选择的房间正在维修!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/index").forward(request, response);
			return;	
		}
		request.setAttribute("room", room);
		request.setAttribute("kind", kind);
		Cookie[] cookies = request.getCookies();
		String rids = rid;
		if(cookies!=null){
			for(Cookie cookie : cookies){
				if("rids".equals(cookie.getName())){
					rids = cookie.getValue();
					String[] split=rids.split("-");
					List<String> aslist=Arrays.asList(split);
					LinkedList<String> list = new LinkedList<String>(aslist);
					if(list.contains(rid)){
						list.remove(rid);
					}
					    list.addFirst(rid);
					    StringBuffer sb= new StringBuffer();
					    for(int i=0;i<list.size()&&i<6;i++){
					    	sb.append(list.get(i));
					    	sb.append("-");
					    }
					    rids = sb.substring(0,sb.length()-1);    
				}	
			}	 
		}
		Cookie cookie_rids = new Cookie("rids",rids);
		List<Map<String,Object>> guesttimelist=service.roomGuestdinfo(rid);
		request.setAttribute("guesttimelist", guesttimelist);
		response.addCookie(cookie_rids);
		request.getRequestDispatcher("/roominfo.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
