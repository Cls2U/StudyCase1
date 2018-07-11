package com.gx.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gx.domain.User;
import com.gx.utils.DataSourceUtils;

public class UserDao {

	public int regist(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?)";
		int update = runner.update(sql,user.getUid(),user.getUpd(),user.getEmail(),user.getPhone(),user.getSign(),user.getState(),user.getCode());
		return update;
	}

	public void active(String activeCode) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set state=? where code=?";
		runner.update(sql,1,activeCode);
		
	}

	public Long checkUid(String uid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from user where uid=?";
		Long query = (Long) runner.query(sql, new ScalarHandler(),uid);
		return query;
	}

	public Long checkEmail(String email) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from user where email=?";
		Long query = (Long) runner.query(sql, new ScalarHandler(),email);
		return query;
	}

	public Long checkPhone(String phone) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from user where phone=?";
		Long query = (Long) runner.query(sql, new ScalarHandler(),phone);
		return query;
	}

	public User checkUser(String uid, String upd) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where uid=? and upd=?";
		User user = runner.query(sql, new BeanHandler<User>(User.class), uid,upd);
		return user;
	}

	public int editUserByUid(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update user set upd=?,email=?,phone=?,state=? where uid=?";
		return runner.update(sql,user.getUpd(),user.getEmail(),user.getPhone(),user.getState(),user.getUid());
	}

	public User findUserByUid(String uid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where uid=?";
		return runner.query(sql,new BeanHandler<User>(User.class),uid);
	}

	public int deleteUserByUid(String uid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from user where uid=?";
		return runner.update(sql,uid);
	}

	public Long checkGid(String gid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from guestinfo where gid=?";
		Long query = (Long) runner.query(sql, new ScalarHandler(),gid);
		return query;
	}

	public Long checkIdcard(String idcard) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from guestinfo where idcard=?";
		Long query = (Long) runner.query(sql, new ScalarHandler(),idcard);
		return query;
	}

	public Long checkRoomnum(String roomnum) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from guestinfo where rid=(select rid from room where roomnum=?)";
		Long query = (Long) runner.query(sql, new ScalarHandler(),roomnum);
		return query;
	}
	
}
