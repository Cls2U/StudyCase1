<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>今日收银汇总</title>
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
				<table class="table table-hover">
					<tbody>
						<tr class="warning">
							<th>今日新增订单数</th>
							<th>今日完成订单数</th>
							<th>今日收款</th>
							<th>未完成订单数</th>
							<th>待结金额</th>
						</tr>
						<tr class="active">
							<td >${map.newguest }</td>
							<td >${map.finishguest }</td>
							<td >${map.addmoney }</td>
							<td >${map.incompleteguset }</td>
							<td >${map.waitmoney }</td>
						</tr>
					</tbody>
				</table>
	</div>
	</div>
</div>
	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>
	
</body>

</html>