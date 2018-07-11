package com.gx.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gx.domain.User;
import com.gx.service.UserService;
import com.gx.utils.MailUtils;
import com.gx.utils.MyBeanUtils;

/**
 * Servlet implementation class EditUserServlet
 */
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String,String[]>properties = request.getParameterMap();
		User user = MyBeanUtils.populate(User.class, properties);
		user.setState(0);
		UserService service = new UserService();
		boolean isEditSuccess = service.editUserByUid(user);
		if(isEditSuccess&&user.getSign()==2){
			//发送激活邮件
			String emailMsg = "恭喜您注册成功，请点击下面的连接进行激活账户"
					+ "<a href='http://localhost:8080/HotelManagement/active?activeCode="+user.getCode()+"'>"
							+ "http://localhost:8080/HotelManagement/active?activeCode="+user.getCode()+"</a>";
			try {
				MailUtils.sendMail(user.getEmail(), emailMsg);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			String msg="修改成功，请尽快激活你的账号！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/adminAllUserList").forward(request, response);
		}else{
			String msg="修改失败，请检查您输入的内容或联系管理员！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/adminAllUserList").forward(request, response);
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
