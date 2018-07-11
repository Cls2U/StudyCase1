package com.gx.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.domain.Guestinfo;
import com.gx.service.RoomService;

/**
 * Servlet implementation class SubmitCheckOutServlet
 */
public class SubmitCheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitCheckOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomService service=new RoomService();
		String gid = request.getParameter("gid");
		Guestinfo guest = service.findGuestByGid(gid);
		if(!(request.getParameter("deposit").isEmpty()||request.getParameter("deposit").trim().isEmpty()))
		{
		BigDecimal deposit=guest.getDeposit();
		BigDecimal newdeposit = new BigDecimal(request.getParameter("deposit"));
		service.updateGuestDepositByGid(gid, deposit.add(newdeposit));}
		if(guest.getDeposit().compareTo(guest.getTotal())>=-1)//
		{service.updateGuestStateByGid(gid, 4);
		Date date = new Date();
		Timestamp leavetime = new Timestamp(date.getTime());
		service.updateGuestLeavetimeByGid(gid,leavetime);
		String rid = guest.getRid();
		boolean isEmpty=service.findRoomStateByGuestRid(rid);//如果没有找到状态不是已完成的订单的房间就变为空房间
		if(isEmpty)
			service.updateRoomSign(rid,1);
		String msg="退房成功！";
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/index").forward(request, response);}
		else
		{
			String msg="退房失败，结账金额不足！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/checkOutList").forward(request, response);
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
