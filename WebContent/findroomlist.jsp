<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>搜索结果</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
	width: 100%;
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


	<div class="row" style="width: 1210px; margin: 0 auto;">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="#">房间列表</a></li>
			</ol>
		</div>
		<c:forEach items="${RoomList }" var="room">
		<div class="col-md-2">
			<a href="${pageContext.request.contextPath }/roomInfo?rid=${room.rid}"> 
			</a>
			<p>
				<a class="btn btn-default" role="button" href="${pageContext.request.contextPath }/roomInfo?rid=${room.rid}" style='color: green'>${room.roomnum}</a>
			</p>
			<p>
				<font color="#FF0000">&yen;${allRoomKind[room.kind-1].price}/晚</font>
			</p>
		</div>
		</c:forEach>
	</div>
	<!--商品浏览记录-->
	<div
		style="width: 1210px; margin: 0 auto; padding: 0 9px; border: 1px solid #ddd; border-top: 2px solid #999; height: 246px;">

		<h4 style="width: 50%; float: left; font: 14px/30px 微软雅黑">浏览记录</h4>
		<div style="width: 50%; float: right; text-align: right;">
			<a href="">more</a>
		</div>
		<div style="clear: both;"></div>

		<div style="overflow: hidden;">

			<ul style="list-style: none;">
			    <c:forEach items="${historyRoomList }" var="historyRoom">
			    <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<p><a href="${pageContext.request.contextPath }/roomInfo?rid=${historyRoom.rid}" style='color:#666'>${historyRoom.roomnum}</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;${allRoomKind[historyRoom.kind-1].price}</font></p>
				</div>
			    </c:forEach>
				
			</ul>

		</div>
	</div>


	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>