package com.gx.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.gx.domain.Sign;
import com.gx.service.RoomService;
import com.gx.utils.MyBeanUtils;

/**
 * Servlet implementation class AdminEditRoomStateBySignServlet
 */
public class AdminEditRoomStateBySignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditRoomStateBySignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String[]>properties=request.getParameterMap();
		Sign sign=MyBeanUtils.populate(Sign.class, properties);
		RoomService service = new RoomService();
		boolean isEditSucces=service.adminEditRoomStateBySign(sign);
		if(isEditSucces){
			String msg="修改成功！";
			//request.getSession().setAttribute("msg", msg);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/adminAllRoomStateList").forward(request, response);
		}else
		{
			String msg="修改失败！请检查标识名是否重复或联系管理员！";
			//request.getSession().setAttribute("msg", msg);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/adminAllRoomStateList").forward(request, response);
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
