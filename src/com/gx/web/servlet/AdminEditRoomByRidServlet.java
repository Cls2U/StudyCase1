package com.gx.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.domain.Room;
import com.gx.service.RoomService;
import com.gx.utils.MyBeanUtils;

/**
 * Servlet implementation class AdminEditRoomByRidServlet
 */
public class AdminEditRoomByRidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditRoomByRidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String[]>properties=request.getParameterMap();
		Room room=MyBeanUtils.populate(Room.class, properties);
		RoomService service = new RoomService();
		boolean isEditSucces=service.adminEditRoomByRid(room);
		if(isEditSucces){
			String msg="修改成功！";
			//request.getSession().setAttribute("msg", msg);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/adminAllRoomList").forward(request, response);
		}else
		{
			String msg="修改失败！请检查房间名是否重复或联系管理员！";
			//request.getSession().setAttribute("msg", msg);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/adminAllRoomList").forward(request, response);
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
