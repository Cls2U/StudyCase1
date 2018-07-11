package com.gx.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gx.dao.RoomDao;
import com.gx.domain.Guestinfo;
import com.gx.domain.Kind;
import com.gx.domain.OrderState;
import com.gx.domain.PageBean;
import com.gx.domain.Room;
import com.gx.domain.Sign;
import com.gx.domain.User;
import com.gx.domain.UserType;
import com.gx.utils.DataSourceUtils;

public class RoomService {
	public List<Room> findEmptyRoomList() {
		RoomDao dao = new RoomDao();
		List<Room> emptyRoomList = null;
		try {
			emptyRoomList= dao.findEmptyRoomList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emptyRoomList;
	}
	public List<Room> findReservationRoomList() {
		RoomDao dao = new RoomDao();
		List<Room> reservationRoomList = null;
		try {
			reservationRoomList= dao.findReservationRoomList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservationRoomList;
	
	}
	public List<Kind> findAllRoomKind() {
		RoomDao dao = new RoomDao();
		List<Kind> allRoomKind = null;
		try {
			allRoomKind= dao.findAllRoomKind();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allRoomKind;
}	
	public List<Sign> findAllRoomSign() {
		RoomDao dao = new RoomDao();
		List<Sign> allRoomSign = null;
		try {
			allRoomSign= dao.findAllRoomSign();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allRoomSign;
}
	public PageBean<Room> findRoomByKid(String kid,int currentPage,int currentCount) {
		RoomDao dao=new RoomDao();
		PageBean<Room> pageBean=new PageBean<Room>();
		
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		int totalCount = 0;
		try {
			totalCount = dao.getCountByKid(kid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		int index=(currentPage-1)*currentCount;
		List<Room> list=null;
		try {
			list=dao.findRoomByKid(kid,index,currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setList(list);
		return pageBean;
		
	}
	public Room findRoomByRid(String rid) {
		RoomDao dao=new RoomDao();
		Room room=null;
		try {
			room = dao.findRoomByRid(rid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return room;
	}
	public PageBean<Room> findRoomBySign(String sign, int currentPage, int currentCount) {
		RoomDao dao=new RoomDao();
		PageBean<Room> pageBean=new PageBean<Room>();
		
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		int totalCount = 0;
		try {
			totalCount = dao.getCountBySign(sign);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		int index=(currentPage-1)*currentCount;
		List<Room> list=null;
		try {
			list=dao.findRoomBySign(sign,index,currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setList(list);
		return pageBean;
	}
	public boolean submitGuestinfo(Guestinfo guestinfo) {
		RoomDao dao = new RoomDao();
		int isExist=0;
        try {
        	//开启事务
			DataSourceUtils.startTransaction();
			isExist=dao.addGuestinfo(guestinfo);
		} catch (SQLException e) {
			//回滚事务
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			//提交事务
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
        if(isExist==0)
		return false;
        else
        	return true;
	}
	public void updateGuestStateByGid(String gid, Integer state) {
		RoomDao dao = new RoomDao();
		try {
			dao.updateGuestStateByGid(gid,state);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateGuestDepositByGid(String gid, BigDecimal deposit) {
		RoomDao dao = new RoomDao();
		try {
			dao.updateGuestDepositByGid(gid,deposit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Integer findRoomSign(String rid) {
		RoomDao dao = new RoomDao();
		Integer sign=null;
		try {
			sign = dao.findRoomSign(rid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sign;
	}
	public void updateRoomSign(String rid, Integer i) {
		RoomDao dao = new RoomDao();
		try {
			dao.updateRoomSign(rid,i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;

	}
	public PageBean<Guestinfo> findAllGuestByOpe(String uid,int currentPage, int currentCount) {
		RoomDao dao = new RoomDao();
		PageBean<Guestinfo> pageBean=new PageBean<Guestinfo>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		int totalCount = 0;
		try {
			totalCount = dao.getCountGuestByOpe(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		int index=(currentPage-1)*currentCount;
		List<Guestinfo> guestlist = null;
		try {
			guestlist = dao.findAllGuestByOpe(uid,index,currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setList(guestlist);
		return pageBean;
	}
	public boolean addRoom(Room room) {
		RoomDao dao = new RoomDao();
		int isExist=0;
        try {
        	//开启事务
			DataSourceUtils.startTransaction();
			isExist=dao.addRoom(room);
		} catch (SQLException e) {
			//回滚事务
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			//提交事务
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
        if(isExist==0)
		return false;
        else
        	return true;
	}
	public List<Guestinfo> findAllGuest() {
		RoomDao dao=new RoomDao();
		List<Guestinfo> list=null;
		try {
			list = dao.findAllGuest();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Integer checkRoomGuestTime(String rid, String starttime, String endtime) {
		RoomDao dao=new RoomDao();
		Integer i=null;
		try {
			i = dao.checkRoomGuestTime(rid,starttime,endtime);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public List<OrderState> findAllOrderState() {
		RoomDao dao=new RoomDao();
		List<OrderState> states=null;
		try {
			states = dao.findAllOrderState();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return states;
	}
	public Map<String, Object> findGuestinfoByGid(String gid) {
		RoomDao dao=new RoomDao();
		Map<String, Object> map=null;
		try {
			map=dao.findGuestinfoByGid(gid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	public List<Map<String, Object>> findAllRoomInfo() {
		RoomDao dao=new RoomDao();
		List<Map<String, Object>> mapList=null;
		try {
			mapList = dao.findAllRoomInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapList;
	}
	public boolean adminEditRoomByRid(Room room) {
		RoomDao dao=new RoomDao();
		int isExist=0;
		try {
			isExist=dao.adminEditRoomByRid(room);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isExist==0)
			return false;
	        else
	        	return true;
	}
	public boolean deleteRoomByRid(String rid) {
		RoomDao dao=new RoomDao();
		int isExist=0;
		try {
			isExist = dao.deleteRoomByRid(rid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isExist==0)
			return false;
	        else
	        	return true;
	}
	public boolean adminAddRoomKind(Kind kind) {
		RoomDao dao = new RoomDao();
		int isExist=0;
        try {
        	//开启事务
			DataSourceUtils.startTransaction();
			isExist=dao.adminAddRoomKind(kind);
		} catch (SQLException e) {
			//回滚事务
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			//提交事务
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
        if(isExist==0)
		return false;
        else
        	return true;
	}
	public boolean adminEditRoomKindByKid(Kind kind) {
		RoomDao dao=new RoomDao();
		int isExist=0;
		try {
			isExist=dao.adminEditRoomKindByKid(kind);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isExist==0)
			return false;
	        else
	        	return true;
	}
	public boolean deleteRoomKindByKid(String kid) {
		RoomDao dao=new RoomDao();
		int isExist=0;
		try {
			isExist = dao.deleteRoomKindByKid(kid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isExist==0)
			return false;
	        else
	        	return true;
	}
	public boolean adminEditRoomStateBySign(Sign sign) {
		RoomDao dao=new RoomDao();
		int isExist=0;
		try {
			isExist=dao.adminEditRoomStateBySign(sign);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isExist==0)
			return false;
	        else
	        	return true;
	}
	public boolean adminAddRoomState(Sign sign) {
		RoomDao dao = new RoomDao();
		int isExist=0;
        try {
        	//开启事务
			DataSourceUtils.startTransaction();
			isExist=dao.adminAddRoomState(sign);
		} catch (SQLException e) {
			//回滚事务
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			//提交事务
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
        if(isExist==0)
		return false;
        else
        	return true;
	
    }
	public boolean deleteRoomStateBySign(String sign) {
		RoomDao dao=new RoomDao();
		int isExist=0;
		try {
			isExist = dao.deleteRoomStateBySign(sign);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isExist==0)
			return false;
	        else
	        	return true;
	}
	public List<User> findAllUser() {
		RoomDao dao = new RoomDao();
		List<User> list=null;
		try {
			list = dao.findAllUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<UserType> findAllUserType() {
		RoomDao dao = new RoomDao();
		List<UserType> list=null;
		try {
			list = dao.findAllUserType();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Map<String, Object>> checkOutList() {
		RoomDao dao = new RoomDao();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());//字符型时间
		List<Map<String, Object>> list=null;
		try {
			list = dao.findAllTodayLeaveGuest(date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Map<String, Object>> roomGuestdinfo(String rid) {
		RoomDao dao = new RoomDao();
		List<Map<String, Object>> list=null;
		try {
			list = dao.roomGuestdinfo(rid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Guestinfo findGuestByGid(String gid) {
		RoomDao dao = new RoomDao();
		Guestinfo guestinfo=null;
		try {
			guestinfo = dao.findGuestByGid(gid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return guestinfo;
	}
	public boolean findRoomStateByGuestRid(String rid) {
		RoomDao dao=new RoomDao();
		int isExist=0;
		try {
			isExist = dao.findRoomStateByGuestRid(rid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isExist==0)
			return true;
	        else
	        	return false;
	}
	public void updateGuestLeavetimeByGid(String gid, Timestamp leavetime) {
		RoomDao dao = new RoomDao();
		try {
			dao.updateGuestLeavetimeByGid(gid,leavetime);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Map<String, Object>> checkOutNormalList() {
		RoomDao dao = new RoomDao();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());//字符型时间
		List<Map<String, Object>> list=null;
		try {
			list = dao.findAllNoTodayLeaveGuest(date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public String findRidByRoomnum(String roomnum) {
		RoomDao dao = new RoomDao();
		String rid=null;
		Room room=null;
		try {
			room = dao.findRoomByRoomnum(roomnum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rid=room.getRid().toString();
		return rid;
	}
	public List<Room> findRoomByTimeAndKind(String arrivaltime, String departuretime, String roomkind) {
		RoomDao dao = new RoomDao();
		List<Room> list = null;
		try {
			list = dao.findRoomByTimeAndKind(arrivaltime,departuretime,roomkind);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Room> findRoomByKeyword(String keyword) {
		RoomDao dao = new RoomDao();
		List<Room> list = null;
		try {
			list = dao.findRoomByKeyword(keyword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Guestinfo> findGuestinfoByKeyword(String keyword) {
		RoomDao dao = new RoomDao();
		List<Guestinfo> list = null;
		try {
			list = dao.findGuestinfoByKeyword(keyword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Map<String, Object> countGuest() {
		RoomDao dao = new RoomDao();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());//字符型时间
		Map<String, Object> map=new HashMap<String, Object>();
		int newguest=0;
		int finishguest=0;
		int addmoney=0;
		int incompleteguset=0;
		int waitmoney=0;
		try {
			newguest=dao.countNewGuest(date);
			finishguest=dao.countFinishGuest(date);
			if(dao.sumAddMoney(date)!=null)
				addmoney=dao.sumAddMoney(date).intValue();
			incompleteguset=dao.countIncompletegusetGuest();
			waitmoney=dao.allTotalNotFinish().intValue()-dao.allDepositNotFinish().intValue();
			if(waitmoney<0)
				waitmoney=0;
			addmoney=addmoney-50*finishguest+newguest*50;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("newguest", newguest);
		map.put("finishguest", finishguest);
		map.put("addmoney", addmoney);
		map.put("incompleteguset",incompleteguset);
		map.put("waitmoney", waitmoney);
		return map;
	}
}