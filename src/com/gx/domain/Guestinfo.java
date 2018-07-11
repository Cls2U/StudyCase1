package com.gx.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Guestinfo {
	private String gid;
	private String idcard;
	private String rid;
	private String operator;
	private String name;
	private String sex;
	private Integer state;
	private Date arrivaltime;
	private Date departuretime;
	private String phone;
	private Timestamp leavetime;
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Timestamp getLeavetime() {
		return leavetime;
	}
	public void setLeavetime(Timestamp leavetime) {
		this.leavetime = leavetime;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	private BigDecimal deposit;//已付款项
	private Timestamp ordertime;
	private BigDecimal total;//订单金额
	public Timestamp getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getstate() {
		return state;
	}
	public void setstate(Integer state) {
		this.state = state;
	}
	public Date getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(Date arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public Date getDeparturetime() {
		return departuretime;
	}
	public void setDeparturetime(Date departuretime) {
		this.departuretime = departuretime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public BigDecimal getDeposit() {
		return deposit;
	}
	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}
	
}
