package com.gx.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.service.RoomService;

/**
 * Servlet implementation class DeleteRoomKindByKidServlet
 */
public class DeleteRoomKindByKidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRoomKindByKidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomService service = new RoomService();
		String kid = request.getParameter("kid");
		boolean isSuccess = service.deleteRoomKindByKid(kid);
		if(isSuccess){
			String msg="删除成功！";
			//request.getSession().setAttribute("msg", msg);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/adminAllRoomKindList").forward(request, response);
		}else
		{
			String msg="删除失败！请检查标识名或联系管理员！";
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
