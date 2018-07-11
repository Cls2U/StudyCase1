<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>搜索结果</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<c:if test="${empty roomlist&&empty guestlist}">
<h1>没有搜索到任何内容！</h1>
</c:if>
<c:if test="${!empty roomlist }">
<div class="row" style="width: 1210px; margin: 0 auto;">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li>搜索到的房间</li>
			</ol>
		</div>
		<c:forEach items="${roomlist }" var="room">
		<div class="col-md-2">
			<a href="${pageContext.request.contextPath }/roomInfo?rid=${room.rid}"> 
			</a>
			<p>
				<a class="btn btn-default" role="button" href="${pageContext.request.contextPath }/roomInfo?rid=${room.rid}" style='color: green'>${room.roomnum}</a>
			</p>
			<p>
				<font color="#FF0000">&yen;${allRoomKind[room.kind-1].price}</font>
			</p>
		</div>
		</c:forEach>
</div>
</c:if>
<c:if test="${!empty guestlist  }">
<div class="container col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin: 0 auto;">
		<div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin: 0 auto;">
			<div style="margin: 0 auto; margin-top: 10px; width: 1300px;">
				<ol class="breadcrumb"><li>搜索到的订单</li></ol>
				<table class="table table-hover">
				<c:forEach items="${guestlist }" var="guest">
					<tbody>
						<tr class="success">
							<th colspan="5">订单编号:${guest.gid }</th>
							<th>状态：<c:if test="${guest.state!=4 }">未完成</c:if>
							        <c:if test="${guest.state==4 }">已完成</c:if>	
							</th>
						</tr>
						<tr class="warning">
							<th width="8%">姓名</th>
							<th width="5%">性别</th>
							<th width="15%">身份证</th>
							<th width="10%">电话</th>
							<th width="7%">房间编号</th>
							<th width="10%">价格</th>
							<th width="20%">时间</th>
							<th width="5%">应付金额</th>
							<th width="5%">实付金额</th>
							<th width="15%">下单时间</th>
							<c:if test="${guest.state!=4&&loginUser.sign<2 }">
							<th></th>
							</c:if>
						</tr>
						<tr class="active">
							<td >${guest.name }</td>
							<td >${guest.sex }</td>
							<td >${guest.idcard }</td>
							<td >${guest.phone }</td>
							<td >${guest.rid }</td>
							<td >￥298.00</td>
							<td >${guest.arrivaltime }&nbsp;&nbsp;~&nbsp;&nbsp;${guest.departuretime }</td>
							<td >￥${guest.total }</td>
							<td ><span class="subtotal">￥${guest.deposit}</span></td>	
							<td >￥${guest.ordertime }</td>
							<c:if test="${guest.state!=4&&loginUser.sign<2 }">
							<td><a class="btn btn-warning" role="button"
									href="${pageContext.request.contextPath}/checkOutInfo?gid=${guest.gid }">退房</a>
							</td>
							</c:if>
						</tr>
					</tbody>
				</c:forEach>
				</table>
	</div>
	</div>
</div>
</c:if>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>