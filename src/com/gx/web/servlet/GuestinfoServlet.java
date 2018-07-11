package com.gx.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.gx.utils.CommonsUtils;
import com.gx.utils.MyBeanUtils;

/**
 * Servlet implementation class GuestinfoServlet
 */
public class GuestinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuestinfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		String rid=request.getParameter("rid");
		RoomService service = new RoomService();
		Integer roomstate=service.findRoomSign(rid);
		if(roomstate==null){
			String msg = "您预定的房间不存在，或服务器正忙！请联系管理员！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/index").forward(request, response);
			return;
		}else if(roomstate==4){
			String msg = "您预定的房间正在维修，亲可以看看其他的房间哟~";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/roomListByStatu?sign=1").forward(request, response);
			return;	
		}
		Integer check=service.checkRoomGuestTime(rid,request.getParameter("arrivaltime"),request.getParameter("departuretime"));
		if(check>0)
		{
			String msg = "您预定的房间该时间段已经被预定了，亲可以看看其他的房间哟~";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/roomListByStatu?sign=1").forward(request, response);
			return;
		}
		Map<String, String[]> properties = request.getParameterMap();
		Guestinfo guestinfo=MyBeanUtils.populate(Guestinfo.class, properties);
		String gid=CommonsUtils.getUUID();
		guestinfo.setGid(gid);
		guestinfo.setOperator(user.getUid());
		Date date = new Date();
		Timestamp ordertime = new Timestamp(date.getTime());
		guestinfo.setOrdertime(ordertime);
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
		long from = 0;
		long to = 0;
		try {
			from = simpleFormat.parse(request.getParameter("arrivaltime")).getTime();
			to = simpleFormat.parse(request.getParameter("departuretime")).getTime();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BigDecimal days = new BigDecimal(String.valueOf((to - from) / (1000 * 60 * 60 * 24)));
		BigDecimal price = new BigDecimal(request.getParameter("price"));
		BigDecimal total = days.multiply(price).setScale(2, BigDecimal.ROUND_HALF_UP);
		guestinfo.setTotal(total);
		request.setAttribute("total", total);
		request.getSession().setAttribute("guestinfo", guestinfo);
		Room room =service.findRoomByRid(rid);
		List<Kind> kind=service.findAllRoomKind();
		request.setAttribute("room", room);
		request.setAttribute("kind", kind);
		request.getRequestDispatcher("/order_info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
