<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>酒店首页</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</head>
<script type="text/javascript">
	$(function() {
		if("${msg}"!="")
			alert("${msg}");
	});
</script>
	<body>
		<div class="container-fluid">
			<!-- 引入header.jsp -->
			<jsp:include page="/header.jsp"></jsp:include>
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>空房间</h2>
				</div>
				<div class="col-md-10">
				    <c:forEach items="${emptyRoomList}" var="emptyRoom">
				    
				    <div class="col-md-2 btn btn-lg" style="text-align:center;height:100px;padding:10px 0px;">
						<p><a class="btn btn-success" role="button" href="${pageContext.request.contextPath }/roomInfo?rid=${emptyRoom.rid}">${emptyRoom.roomnum}</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;${allRoomKind[emptyRoom.kind-1].price}</font></p>
					</div>
					
				    </c:forEach>
				</div>
			</div>
			<div class="container-fluid">
				<div class="col-md-12"><h2>已预定房间</h2></div>
				<div class="col-md-10">
					<c:forEach items="${reservationRoomList}" var="reservationRoom">
				 
				    <div class="col-md-2" style="text-align:center;height:100px;padding:10px 0px;">
						<!-- <a href="product_info.htm"><img src="products/hao/small03.jpg" width="130" height="130" style="display: inline-block;"></a> -->
						<p><a class="btn btn-info" role="button" href="${pageContext.request.contextPath }/roomInfo?rid=${reservationRoom.rid}">${reservationRoom.roomnum}</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;${allRoomKind[reservationRoom.kind-1].price}</font></p>
					</div>
					
				    </c:forEach>

				</div>
			</div>			
			
			<!-- 引入footer.jsp -->
			<jsp:include page="/footer.jsp"></jsp:include>
			
		</div>
	</body>

</html>