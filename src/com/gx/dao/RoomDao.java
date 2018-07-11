package com.gx.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gx.domain.Guestinfo;
import com.gx.domain.Kind;
import com.gx.domain.OrderState;
import com.gx.domain.Room;
import com.gx.domain.Sign;
import com.gx.domain.User;
import com.gx.domain.UserType;
import com.gx.utils.DataSourceUtils;

public class RoomDao {

	public List<Room> findEmptyRoomList() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from room where sign=?";
		return runner.query(sql, new BeanListHandler<Room>(Room.class),1);
	}

	public List<Room> findReservationRoomList() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from room where sign=?";
		return runner.query(sql, new BeanListHandler<Room>(Room.class),2);
	}

	public List<Kind> findAllRoomKind() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from roomkind";
		return runner.query(sql, new BeanListHandler<Kind>(Kind.class));
	}
	public List<Sign> findAllRoomSign() throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from roomstatu";
		return runner.query(sql,new BeanListHandler<Sign>(Sign.class));
	}

	public int getCountByKid(String kid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from room where kind=?";
		Long query = (Long) runner.query(sql,new ScalarHandler(),kid);
		return query.intValue();
	}
	public int getCountBySign(String sign) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from room where sign=?";
		Long query = (Long) runner.query(sql,new ScalarHandler(),sign);
		return query.intValue();
	}

	public List<Room> findRoomByKid(String kid, int index, int currentCount) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from room where kind=? limit ?,?";
		return runner.query(sql,new BeanListHandler<Room>(Room.class),kid,index,currentCount);
		
	}

	public Room findRoomByRid(String rid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from room where rid=?";
		return runner.query(sql,new BeanHandler<Room>(Room.class),rid);
		
	}

	public List<Room> findRoomBySign(String sign, int index, int currentCount) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from room where sign=? limit ?,?";
		return runner.query(sql,new BeanListHandler<Room>(Room.class),sign,index,currentCount);
	}

	public int addGuestinfo(Guestinfo guestinfo) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql="insert into guestinfo(gid,idcard,rid,arrivaltime,departuretime,deposit,operator,name,sex,phone,ordertime,total) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn=DataSourceUtils.getConnection();
		return runner.update(conn, sql, guestinfo.getGid(),guestinfo.getIdcard(),guestinfo.getRid(),guestinfo.getArrivaltime(),guestinfo.getDeparturetime(),guestinfo.getDeposit(),guestinfo.getOperator(),guestinfo.getName(),guestinfo.getSex(),guestinfo.getPhone(),guestinfo.getOrdertime(),guestinfo.getTotal());
	}

	public void updateGuestStateByGid(String gid, Integer state) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update guestinfo set state=? where gid=?";
		runner.update(sql,state,gid);
		
	}

	public void updateGuestDepositByGid(String gid, BigDecimal deposit) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update guestinfo set deposit=? where gid=?";
		runner.update(sql,deposit,gid);
	}

	public Integer findRoomSign(String rid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select sign from room where rid=?";
		return (Integer) runner.query(sql,new ScalarHandler(),rid);
	}

	public void updateRoomSign(String rid, Integer i) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update room set sign=? where rid=?";
		runner.update(sql,i,rid);
	}

	public List<Guestinfo> findAllGuestByOpe(String uid,int index, int currentCount) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from guestinfo where operator=? limit ?,?";
		return runner.query(sql,new BeanListHandler<Guestinfo>(Guestinfo.class),uid,index,currentCount);
		
	}

	public int getCountGuestByOpe(String uid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from guestinfo where operator=?";
		Long query = (Long) runner.query(sql,new ScalarHandler(),uid);
		return query.intValue();
	}

	public int addRoom(Room room) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql="insert into room(roomnum,kind,sign) values(?,?,?)";
		Connection conn=DataSourceUtils.getConnection();
		return runner.update(conn, sql,room.getRoomnum(),room.getKind(),room.getSign());
	}

	public List<Guestinfo> findAllGuest() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from guestinfo order by guestinfo.ordertime DESC";
		return runner.query(sql,new BeanListHandler<Guestinfo>(Guestinfo.class));
		
	}

	public Integer checkRoomGuestTime(String rid, String starttime, String endtime) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from guestinfo where rid=? and departuretime>? and arrivaltime<? and state!=4";
		Long query = (Long) runner.query(sql,new ScalarHandler(),rid,starttime,endtime);
		return query.intValue();
	}

	public List<OrderState> findAllOrderState() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from orderstate";
		return runner.query(sql,new BeanListHandler<OrderState>(OrderState.class));
	}

	public Map<String, Object> findGuestinfoByGid(String gid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select r.roomnum,k.kind,k.kid,k.price,g.* from guestinfo g,room r,roomkind k where g.rid=r.rid and r.kind=k.kid and g.gid=?";
		return runner.query(sql, new MapHandler(),gid);
	}

	public List<Map<String, Object>> findAllRoomInfo() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select r.rid,r.roomnum,k.kind,s.statu,k.price from room r,roomkind k,roomstatu s where r.sign=s.sign and r.kind=k.kid order by r.rid ASC";
		return runner.query(sql, new MapListHandler());
	}

	public int adminEditRoomByRid(Room room) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update room set roomnum=?,kind=?,sign=? where rid=?";
		return runner.update(sql,room.getRoomnum(),room.getKind(),room.getSign(),room.getRid());
	}

	public int deleteRoomByRid(String rid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from room where rid=?";
		return runner.update(sql,rid);
	}

	public int adminAddRoomKind(Kind kind) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql="insert into roomkind(kind,price) values(?,?)";
		Connection conn=DataSourceUtils.getConnection();
		return runner.update(conn, sql,kind.getKind(),kind.getPrice());
	}

	public int adminEditRoomKindByKid(Kind kind) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update roomkind set kind=?,price=? where kid=?";
		return runner.update(sql,kind.getKind(),kind.getPrice(),kind.getKid());
	}

	public int deleteRoomKindByKid(String kid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from roomkind where kid=?";
		return runner.update(sql,kid);
	}

	public int adminEditRoomStateBySign(Sign sign) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update roomstatu set statu=? where sign=?";
		return runner.update(sql,sign.getStatu(),sign.getSign());
	}

	public int adminAddRoomState(Sign sign) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql="insert into roomstatu(sign,statu) values(?,?)";
		Connection conn=DataSourceUtils.getConnection();
		return runner.update(conn, sql,sign.getSign(),sign.getStatu());
	}

	public int deleteRoomStateBySign(String sign) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from roomstatu where sign=?";
		return runner.update(sql,sign);
	}

	public List<User> findAllUser() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where sign>0 order by user.sign ASC";
		return runner.query(sql,new BeanListHandler<User>(User.class));
	}

	public List<UserType> findAllUserType() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from usertype order by usertype.sign ASC";
		return runner.query(sql,new BeanListHandler<UserType>(UserType.class));
	}

	public List<Map<String, Object>> findAllTodayLeaveGuest(String date) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select g.*,r.roomnum,k.price from guestinfo g,room r,roomkind k where g.departuretime=? and g.rid=r.rid and g.state!=4 and r.kind=k.kid";
		return runner.query(sql,new MapListHandler(),date);
	}

	public List<Map<String, Object>> roomGuestdinfo(String rid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select g.arrivaltime,g.departuretime from guestinfo g where rid=? and state!=4";
		return runner.query(sql,new MapListHandler(),rid);
	}

	public Guestinfo findGuestByGid(String gid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from guestinfo where gid=?";
		return runner.query(sql, new BeanHandler<Guestinfo>(Guestinfo.class),gid);
	}

	public int findRoomStateByGuestRid(String rid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from guestinfo where rid=? and state!=4";
		Long query = (Long) runner.query(sql,new ScalarHandler(),rid);
		return query.intValue();
	}

	public void updateGuestLeavetimeByGid(String gid, Timestamp leavetime) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update guestinfo set leavetime=? where gid=?";
		runner.update(sql,leavetime,gid);
	}

	public List<Map<String, Object>> findAllNoTodayLeaveGuest(String date) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select g.*,r.roomnum,k.price from guestinfo g,room r,roomkind k where g.departuretime!=? and g.rid=r.rid and g.state!=4 and r.kind=k.kid";
		return runner.query(sql,new MapListHandler(),date);
	}

	public Room findRoomByRoomnum(String roomnum) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from room where roomnum=?";
		return runner.query(sql,new BeanHandler<Room>(Room.class),roomnum);
		
	}

	public List<Room> findRoomByTimeAndKind(String arrivaltime, String departuretime, String roomkind) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from room where rid not in (select rid from guestinfo where departuretime>? and arrivaltime<? and state!=4) and kind=? and sign!=4";
		return runner.query(sql,new BeanListHandler<Room>(Room.class),arrivaltime,departuretime,roomkind);
		
	}

	public List<Room> findRoomByKeyword(String keyword) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from room where locate(?,roomnum)>0 or kind=any(select kid from roomkind where locate(?,kind)>0) or sign=any(select sign from roomstatu where locate(?,statu)>0)";
		return runner.query(sql,new BeanListHandler<Room>(Room.class),keyword,keyword,keyword);
	}

	public List<Guestinfo> findGuestinfoByKeyword(String keyword) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from guestinfo where locate(?,gid)>0 or locate(?,idcard)>0 or rid=any(select rid from room where locate(?,roomnum)>0) or locate(?,operator)>0 or locate(?,name)>0 or state=any(select state from orderstate where locate(?,message)>0) or locate(?,phone)>0 or locate(?,arrivaltime)>0 or locate(?,departuretime)>0";
		return runner.query(sql,new BeanListHandler<Guestinfo>(Guestinfo.class),keyword,keyword,keyword,keyword,keyword,keyword,keyword,keyword,keyword);
	}

	public int countNewGuest(String date) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from guestinfo where locate(?,ordertime)>0";
		Long query = (Long) runner.query(sql,new ScalarHandler(),date);
		return query.intValue();
	}

	public int countFinishGuest(String date) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from guestinfo where locate(?,leavetime)>0";
		Long query = (Long) runner.query(sql,new ScalarHandler(),date);
		return query.intValue();
	}

	public BigDecimal sumAddMoney(String date) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select sum(deposit) from guestinfo where locate(?,leavetime)>0";
		return (BigDecimal) runner.query(sql,new ScalarHandler(),date);
	}

	public int countIncompletegusetGuest() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from guestinfo where state!=4";
		Long query = (Long) runner.query(sql,new ScalarHandler());
		return query.intValue();
	}
	public BigDecimal allDepositNotFinish() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select sum(deposit) from guestinfo where state!=4";
		return (BigDecimal) runner.query(sql,new ScalarHandler());
	}
	public BigDecimal allTotalNotFinish() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select sum(total) from guestinfo where state!=4";
		return (BigDecimal) runner.query(sql,new ScalarHandler());
	}

	


	

}
