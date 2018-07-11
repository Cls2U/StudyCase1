<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>待处理订单</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
	$(function() {
		if ("${requestScope.msg}" != "")
			alert("${requestScope.msg}");
	});
</script>
<body>
	<div class="container-fluid">
		<!-- 引入header.jsp -->
		<jsp:include page="/header.jsp"></jsp:include>
		<div>
			<div>
				<table class="table table-bordered table-hover">
					<c:forEach items="${list}" var="guest">
						<tbody>
							<tr class="success">
								<th colspan="5">订单编号:${guest.gid }</th>
							</tr>
							<tr class="warning">
								<th width="7%">姓名</th>
								<th width="5%">性别</th>
								<th width="15%">身份证</th>
								<th width="10%">电话</th>
								<th width="5%">房间号</th>
								<th width="7%">单日价格</th>
								<th width="20%">入住时间段</th>
								<th width="5%">已付金额</th>
								<th width="5%">应付金额</th>
								<th width="15%">下单时间</th>
								<th width="6"></th>
							</tr>
							<tr class="active">
								<td>${guest.name }</td>
								<td>${guest.sex }</td>
								<td>${guest.idcard }</td>
								<td>${guest.phone }</td>
								<td>${guest.roomnum }</td>
								<td>￥${guest.price }</td>
								<td>${guest.arrivaltime }&nbsp;&nbsp;~&nbsp;&nbsp;${guest.departuretime }</td>
								<td>￥${guest.deposit }</td>
								<td>￥${guest.total}</td>
								<td>${guest.ordertime}</td>
								<td><a class="btn btn-warning" role="button"
									href="${pageContext.request.contextPath}/checkOutInfo?gid=${guest.gid }">退房</a>
								</td>
							</tr>
						</tbody>
					</c:forEach>
					<c:forEach items="${historylist}" var="guest">
						<tbody>
							<tr class="success">
								<th colspan="5">订单编号:${guest.gid }</th>
							</tr>
							<tr class="warning">
								<th width="7%">姓名</th>
								<th width="5%">性别</th>
								<th width="15%">身份证</th>
								<th width="10%">电话</th>
								<th width="5%">房间号</th>
								<th width="7%">单日价格</th>
								<th width="20%">入住时间段</th>
								<th width="5%">已付金额</th>
								<th width="5%">应付金额</th>
								<th width="15%">下单时间</th>
								<th width="6"></th>
							</tr>
							<tr class="active">
								<td>${guest.name }</td>
								<td>${guest.sex }</td>
								<td>${guest.idcard }</td>
								<td>${guest.phone }</td>
								<td>${guest.roomnum }</td>
								<td>￥${guest.price }</td>
								<td>${guest.arrivaltime }&nbsp;&nbsp;~&nbsp;&nbsp;${guest.departuretime }</td>
								<td>￥${guest.deposit }</td>
								<td>￥${guest.total}</td>
								<td>${guest.ordertime}</td>
								<td><a class="btn btn-warning" role="button"
									href="${pageContext.request.contextPath}/checkOutInfo?gid=${guest.gid }">退房</a>
								</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
		<!-- 引入footer.jsp -->
		<jsp:include page="/footer.jsp"></jsp:include>

	</div>
</body>

</html>