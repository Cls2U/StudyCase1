package com.gx.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.service.RoomService;

/**
 * Servlet implementation class DeleteRoomStateBySignServlet
 */
public class DeleteRoomStateBySignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRoomStateBySignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sign = request.getParameter("sign");
		RoomService service = new RoomService();
		boolean isEditSucces=service.deleteRoomStateBySign(sign);
		if(isEditSucces){
			String msg="删除成功！";
			//request.getSession().setAttribute("msg", msg);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/adminAllRoomStateList").forward(request, response);
		}else
		{
			String msg="删除失败！请检查标识名及是否还存在带有该标识的房间或联系管理员！";
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
