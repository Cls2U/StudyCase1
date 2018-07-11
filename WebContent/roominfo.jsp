<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>房间信息</title>
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
		if("${msg}"!="")
			alert("${msg}");
		var picker1 = $('#arrivaltime').datetimepicker({
			language:'zh-CN',
			format : 'yyyy-mm-dd',
			autoclose:true,
			minView:2,
			startDate:new Date()
		}).on("click",function(){
			$("#arrivaltime").datetimepicker("setEndDate",$("#departuretime").val())
		});
		var picker2 = $('#departuretime').datetimepicker({
			language:'zh-CN',
			format : 'yyyy-mm-dd',
			autoclose:true,
			minView:2,
			startDate:new Date()
		}).on("click",function(){
			$("#departuretime").datetimepicker("setStartDate",$("#arrivaltime").val())
		});
		$("#dateForm").validate({
			rules : {
				"arrivaltime" : {
					"required" : true,
					"date" : true
				},
				"departuretime" : {
					"required" : true,
					"date" : true
				},
				messages : {
					"arrivaltime" : {
						"required" : "请输入入住时间",
						"rangelength" : "请输入正确格式的日期"
					},
					"departuretime" : {
						"required" : "请输入离宿时间",
						"rangelength" : "请输入正确格式的日期"
					}
				}
			}
		});
	});
</script>
</head>

<body>
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div
				style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
				<a href="${pageContext.request.contextPath}/index">首页&nbsp;&nbsp;&gt;</a>
				<a href="javascript:" onclick="self.location=document.referrer;">房间列表&nbsp;&nbsp;&gt;</a>
				<a>房间信息</a>
			</div>

			<div style="margin: 0 auto; width: 950px;">
				<div class="col-md-6">
					<c:if test="${room.kind==1 }">
						<img style="opacity: 1; width: 400px; height: 350px;" title=""
							class="medium" src="images/norSingle.jpg">
					</c:if>
					<c:if test="${room.kind==2 }">
						<img style="opacity: 1; width: 400px; height: 350px;" title=""
							class="medium" src="images/norDouble.jpg">
					</c:if>
					<c:if test="${room.kind==3 }">
						<img style="opacity: 1; width: 400px; height: 350px;" title=""
							class="medium" src="images/graDouble.jpg">
					</c:if>
					<c:if test="${room.kind==4 }">
						<img style="opacity: 1; width: 400px; height: 350px;" title=""
							class="medium" src="images/graMulti.jpg">
					</c:if>
				</div>

				<div class="col-md-6">
					<div>
						<strong>${room.roomnum }</strong>
					</div>
					<div
						style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
						<div>编号：${room.rid }</div>
					</div>

					<div style="margin: 10px 0 10px 0;">
						亿家价: <strong style="color: #ef0101;">￥：${kind[room.kind-1].price }元/天</strong>&nbsp;&nbsp;&nbsp;&nbsp;参
						考 价：
						<del>￥${kind[room.kind-1].price+100 }元/天</del>
					</div>
					<div style="margin: 20px 0 10px 0;; text-align: center;">
						<form class="form-horizontal" style="margin-top: 5px;" id="dateForm"
							action="${pageContext.request.contextPath}/guestinfo">
							<div class='col-sm-6'>
								<div class="form-group">
									<label>选择开始时间：</label>
									<!--指定 date标记-->
									<div class='input-group date'>
										<input type='text' class="form-control" id='arrivaltime' name="arrivaltime" />
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>
							<div class='col-sm-6'>
								<div class="form-group">
									<label>选择结束时间：</label>
									<!--指定 date标记-->
									<div class='input-group date'>
										<input type='text' class="form-control" id='departuretime' name="departuretime" />
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>
							<input type="hidden" name="price" value="${kind[room.kind-1].price}">
							<input type="hidden" name="rid" value="${room.rid }">
							<div style="text-align: right;">
								<input
									style="background: url('./images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0); height: 36px; width: 127px;"
									value="入住登记" type="submit">
							</div>
						</form>
					</div>
					<c:if test="${not empty guesttimelist}">
					    <table class="table table-hover">
					    <tr><td>已预定时间段</td></tr>
					    <c:forEach items="${guesttimelist }" var="time">
					    <tr>
					    <td>${time.arrivaltime }</td><td>${time.departuretime }</td>
					    </tr>
					    </c:forEach>
					    </table>
					</c:if>
				</div>
			</div>
		</div>
	</div>


	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>