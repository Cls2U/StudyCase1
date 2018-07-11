<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>我的订单</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>

<body>


	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin: 0 auto;">
		<div class="row col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin: 0 auto;">
			<div style="margin: 0 auto; margin-top: 10px; width: 1300px;">
				<strong>我的订单</strong>
				<table class="table table-hover">
				<c:forEach items="${pageBean.list }" var="guest">
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
							<td >${guest.arrivaltime }&nbsp;&nbsp;~&nbsp;&nbsp;${guest.departuretime }</td>
							<td >￥${guest.total }</td>
							<td ><span class="subtotal">￥${guest.deposit}</span></td>	
							<td >${guest.ordertime }</td>
							<c:if test="${guest.state!=4&&loginUser.sign<2 }">
							<td><a class="btn btn-warning" role="button"
									href="${pageContext.request.contextPath}/checkOutInfo?gid=${guest.gid }">退房</a>
							</td>
							</c:if>
						</tr>
					</tbody>
				</c:forEach>
				<tr>
				<td></td><td></td><td></td><td></td><td></td>
				<td>
				<div style="width: 180px; margin: 0 auto; margin-top: 5px; text-align: center;">
		<ul class="pagination" style="text-align: center; margin-top: 10px;">
		<c:if test="${pageBean.currentPage==1 }">
		<li class="disabled">
		   <a href="javascript:void(0)" aria-label="Previous">
		   <span aria-hidden="ture">&laquo;</span>
		   </a>
		</li>
		</c:if>
		<c:if test="${pageBean.currentPage!=1 }">
		<li>
		   <a href="${pageContext.request.contextPath }/orderlist?currentPage=${pageBean.currentPage-1}" aria-label="Previous">
		   <span aria-hidden="ture">&laquo;</span>
		   </a>
		</li>
		</c:if>
		<c:forEach begin="1" end="${pageBean.totalPage}" var="page">
		   <c:if test="${page==pageBean.currentPage }">
		   <li class="active"><a href="javascript:void(0);">${page }</a></li>
		   </c:if>
		   <c:if test="${page!=pageBean.currentPage }">
		   <li><a href="${pageContext.request.contextPath }/orderlist?currentPage=${page}">${page }</a></li>
		   </c:if>
		</c:forEach>
		<c:if test="${pageBean.currentPage==pageBean.totalPage}">
		<li class="disabled">
		   <a href="javascript:void(0) aria-label=Next">
		   <span aria-hidden="ture">&raquo;</span>
		   </a>
		</li>
		</c:if>
		<c:if test="${pageBean.currentPage!=pageBean.totalPage}">
		<li>
		   <a href="${pageContext.request.contextPath }/orderlist?currentPage=${pageBean.currentPage+1}" aria-label="Next">
		   <span aria-hidden="ture">&raquo;</span>
		   </a>
		</li>
		</c:if>
		</ul>
	</div>
				</td><td></td><td></td><td></td>
				</tr>
				</table>
			
	</div>
	</div>
</div>
	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>
	
</body>

</html>