<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>房间状态</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container-fluid">
			<!-- 引入header.jsp -->
			<jsp:include page="/header.jsp"></jsp:include>
			<div class="container-fluid">
			<div class="col-md-3" style="padding-top:10px;">
					<a class="btn btn-success" role="button" href="${pageContext.request.contextPath}/roomListByStatu?sign=${allRoomStatu[0].sign}">${allRoomStatu[0].statu}</a>
			</div>
			<div class="col-md-3" style="padding-top:10px;">
					<a class="btn btn-info" role="button" href="${pageContext.request.contextPath}/roomListByStatu?sign=${allRoomStatu[1].sign}">${allRoomStatu[1].statu}</a>
			</div>
			<div class="col-md-3" style="padding-top:10px;">
					<a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/roomListByStatu?sign=${allRoomStatu[2].sign}">${allRoomStatu[2].statu}</a>
			</div>
			<div class="col-md-3" style="padding-top:10px;">
					<a class="btn btn-danger" role="button" href="${pageContext.request.contextPath}/roomListByStatu?sign=${allRoomStatu[3].sign}">${allRoomStatu[3].statu}</a>
			</div>
			</div>
			<!-- 引入footer.jsp -->
			<jsp:include page="/footer.jsp"></jsp:include>
			
		</div>
	</body>

</html>