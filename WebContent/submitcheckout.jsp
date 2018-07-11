<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>退房</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<script src="js/moment-with-locales.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<script src="js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
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
<script type="text/javascript">
	$(function() {
		if("${requestScope.msg}"!="")
			alert("${requestScope.msg}");
	});
</script>
</head>

<body>
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container-fluid" width="100%">
		<div class="row" width="100%">
			<div style="margin: 0 auto; width: 100%;">
				<div class="col-md-2">
					<c:if test="${guest.kid==1 }">
						<img style="opacity: 1; width: 300px; height: 300px;"
							class="medium" src="images/norSingle.jpg">
					</c:if>
					<c:if test="${guest.kid==2 }">
						<img style="opacity: 1; width: 300px; height: 330px;"
							class="medium" src="images/norDouble.jpg">
					</c:if>
					<c:if test="${guest.kid==3 }">
						<img style="opacity: 1; width: 300px; height: 300px;"
							class="medium" src="images/graDouble.jpg">
					</c:if>
					<c:if test="${guest.kid==4 }">
						<img style="opacity: 1; width: 300px; height: 300px;"
							class="medium" src="images/graMulti.jpg">
					</c:if>
				</div>
				<div class="col-md-10">
					<div>
						<strong>${guest.roomnum }</strong>
					</div>
					<div
						style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
						<div>编号：${guest.rid }</div>
					</div>

					<div style="margin: 10px 0 10px 0;">
						亿家价: <strong style="color: #ef0101;">￥：${guest.price }元/天</strong>&nbsp;&nbsp;&nbsp;&nbsp;参
						考 价：
						<del>￥${guest.price+100 }元/天</del>
					</div>
					<div style="margin: 10px 0 10px 0;; text-align: right;">
					<table class="table table-bordered table-hover">
						<tbody>
							<tr class="success">
								<th colspan="5">订单编号:${guest.gid }</th>
							</tr>
							<tr class="warning">
								<th width="7%">姓名</th>
								<th width="5%">性别</th>
								<th width="15%">身份证</th>
								<th width="10%">电话</th>
								<th width="20%">入住时间段</th>
								<th width="5%">已付金额</th>
								<th width="5%">应付金额</th>
								<th width="8%">操作人</th>
								<th width="20%">下单时间</th>
							</tr>
							<tr class="active">
								<td>${guest.name }</td>
								<td>${guest.sex }</td>
								<td>${guest.idcard }</td>
								<td>${guest.phone }</td>
								<td>${guest.arrivaltime }&nbsp;&nbsp;~&nbsp;&nbsp;${guest.departuretime }</td>
								<td>￥${guest.deposit }</td>
								<td>￥${guest.total}</td>
								<td>${guest.operator}</td>
								<td>${guest.ordertime}</td>
							</tr>
						</tbody>
				     </table>
						<form class="form-horizontal" id="dateForm"
							action="${pageContext.request.contextPath}/submitCheckOut">	
								<div style="text-align: left;">  
									<label for="deposit">付款：</label><input type='text' class="form-control" id='deposit' name="deposit" placeholder="${guest.total-guest.deposit}" />
								</div>
							<input type="hidden" name="gid" value="${guest.gid }">
							<div style="text-align: right;">
								<input
									style="background: url('./images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0); height: 36px; width: 127px;"
									value="退房提交" type="submit">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>