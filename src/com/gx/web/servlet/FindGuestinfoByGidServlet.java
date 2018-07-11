package com.gx.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gx.service.RoomService;

/**
 * Servlet implementation class FindGuestinfoByGidServlet
 */
public class FindGuestinfoByGidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindGuestinfoByGidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gid=request.getParameter("gid");
		RoomService service = new RoomService();
		Map<String,Object> map =service.findGuestinfoByGid(gid);
		Gson gson=new Gson();
		String json=gson.toJson(map);
		/*System.out.println(json);
		 * {"total":399.00,"phone":"666666666666","price":399.00,"deposit":399.00,"gid":"116fe4c9-a507-4d6f-bbb0-34cad5a2c383","kind":"贵宾房     两室一厅二卫 2双人床 3电视 3空调 ","roomnum":"616"}
		*/
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
