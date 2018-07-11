package com.gx.service;

import java.sql.SQLException;

import com.gx.dao.UserDao;
import com.gx.domain.User;

public class UserService {

	public boolean regist(User user) {
		UserDao dao = new UserDao();
		int row = 0;
		try {
			row = dao.regist(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row>0?true:false;
	}

	public void active(String activeCode) {
		UserDao dao = new UserDao();
		try {
			dao.active(activeCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean checkUid(String uid) {
		UserDao dao=new UserDao();
		Long isExist = 0L;
		try {
			isExist = dao.checkUid(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist>0?true:false;
	}

	public boolean checkEmail(String email) {
		UserDao dao=new UserDao();
		Long isExist = 0L;
		try {
			isExist = dao.checkEmail(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist>0?true:false;
	}

	public boolean checkPhone(String phone) {
		UserDao dao=new UserDao();
		Long isExist = 0L;
		try {
			isExist = dao.checkPhone(phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist>0?true:false;
	}

	public User login(User user) {
		UserDao dao=new UserDao();
		User loginUser = null;
		try {
			loginUser = dao.checkUser(user.getUid(),user.getUpd());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginUser;
	}

	public boolean editUserByUid(User user) {
		UserDao dao=new UserDao();
		int isExist=0;
		try {
			isExist=dao.editUserByUid(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isExist==0)
			return false;
	        else
	        	return true;
	}

	public User findUserByUid(String uid) {
		UserDao dao=new UserDao();
		User user=null;
		try {
			user = dao.findUserByUid(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public boolean deleteUserByUid(String uid) {
		UserDao dao=new UserDao();
		int isExist=0;
		try {
			isExist = dao.deleteUserByUid(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isExist==0)
			return false;
	        else
	        	return true;
	}

	public boolean checkGid(String gid) {
		UserDao dao=new UserDao();
		Long isExist = 0L;
		try {
			isExist = dao.checkGid(gid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist>0?true:false;
	}

	public boolean checkIdcard(String idcard) {
		UserDao dao=new UserDao();
		Long isExist = 0L;
		try {
			isExist = dao.checkIdcard(idcard);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist>0?true:false;
	}

	public boolean checkRoomnum(String roomnum) {
		UserDao dao=new UserDao();
		Long isExist = 0L;
		try {
			isExist = dao.checkRoomnum(roomnum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist>0?true:false;
	}

}
