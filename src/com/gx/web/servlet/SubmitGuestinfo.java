package com.gx.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gx.domain.Guestinfo;
import com.gx.domain.User;
import com.gx.service.RoomService;
import com.gx.utils.MyBeanUtils;

/**
 * Servlet implementation class SubmitGuestinfo
 */
public class SubmitGuestinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitGuestinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		Map<String,String[]>properties = request.getParameterMap();
		Guestinfo guestinfo=MyBeanUtils.populate(Guestinfo.class, properties);
		Guestinfo guest=(Guestinfo) request.getSession().getAttribute("guestinfo");
		String rid=guest.getRid();
		RoomService service = new RoomService();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String startdate = format.format(guest.getArrivaltime());
		String enddate=format.format(guest.getDeparturetime());
		Integer check=service.checkRoomGuestTime(rid,startdate,enddate);
		if(check>0)
		{
			String msg = "您预定的房间该时间段已经被预定了，亲可以看看其他的房间哟~";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/roomListByStatu?sign=1").forward(request, response);
			return;
		}
		guestinfo.setGid(guest.getGid());
		guestinfo.setRid(guest.getRid());
		guestinfo.setArrivaltime(guest.getArrivaltime());
		guestinfo.setDeparturetime(guest.getDeparturetime());
		guestinfo.setOperator(guest.getOperator());
		guestinfo.setOrdertime(guest.getOrdertime());
		guestinfo.setTotal(guest.getTotal());
		boolean isGuestinfoSucces=service.submitGuestinfo(guestinfo);
		if(isGuestinfoSucces){
			if(user.getSign()==2)
				service.updateRoomSign(rid,2);//如果是用户操作变为已预定。根据用户类型变更房间状态，如果是管理员前台操作变为已入住代替入住事件
				else
					service.updateRoomSign(rid,3);//如果是非用户操作变为已入住
			if(guestinfo.getDeposit()==guestinfo.getTotal())
			{ 
				if(user.getSign()==2)
				service.updateGuestStateByGid(guestinfo.getGid(),1);//如果是前台操作变为已入住。根据用户类型变更房间状态，如果是管理员前台操作变为已入住代替入住事件
			    else
				service.updateGuestStateByGid(guestinfo.getGid(),3);
				//如果是非用户操作变为已入住
				//根据付款多少设定state的值
		    //BigDecimal deposit = guestinfo.getTotal();//根据付款多少设定deposit的值
			}
			else
			{
				if(request.getParameter("deposit").isEmpty()||request.getParameter("deposit").trim().isEmpty())
				service.updateGuestStateByGid(guestinfo.getGid(),0);
				else
					service.updateGuestStateByGid(guestinfo.getGid(),2);
			}
		    response.sendRedirect(request.getContextPath()+"/index");
			//service.updateGuestDepositByGid(guestinfo.getGid(),deposit);
		}else
			{
			request.setAttribute("msg", "订单提交失败！检查输入金额！请联系管理员！");
			request.getRequestDispatcher("/roomInfo?rid="+rid+"").forward(request, response);
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
