package com.gx.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.domain.Kind;
import com.gx.service.RoomService;
import com.gx.utils.MyBeanUtils;

/**
 * Servlet implementation class AdminAddRoomKindServlet
 */
public class AdminAddRoomKindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddRoomKindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String[]>properties=request.getParameterMap();
		Kind kind=MyBeanUtils.populate(Kind.class, properties);
		RoomService service = new RoomService();
		boolean isAddSucces=service.adminAddRoomKind(kind);
		if(isAddSucces){
			String msg="添加成功！";
			//request.getSession().setAttribute("msg", msg);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/adminAllRoomKindList").forward(request, response);
		}else
		{
			String msg="添加失败！请检查您输入的内容或联系管理员！";
			request.setAttribute("msg", msg);
			//request.getSession().setAttribute("msg", msg);
			request.getRequestDispatcher("/adminAllRoomKindList").forward(request, response);
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
