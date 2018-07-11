<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<title>HotelManagement</title>
</head>
<!-- 导航条 -->
<div class="container-fluid" style="margin-top: 20px; width: 100%">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="${pageContext.request.contextPath}/home.jsp">首页</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="${pageContext.request.contextPath}/allRoomKind">房间类别</a></li>
							<li><a href="${pageContext.request.contextPath}/allRoomStatu">房间状态</a></li>
						</ul>
						<ul class="nav navbar-nav">
							 <c:if test="${loginUser.sign<2 }">
							    <li><a href="${pageContext.request.contextPath}/checkOutList">待处理订单</a></li>
							    <li><a href="${pageContext.request.contextPath}/comming.jsp">入住登记</a></li>
							    <li><a href="${pageContext.request.contextPath}/countGuest">今日收银汇总</a></li>
							    <li><a href="${pageContext.request.contextPath}/admin.jsp">后台管理</a></li>
						     </c:if>
						</ul>
						<form class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath}/selectEverthing" method="post">
							<div class="input-group">
								<input type="text" class="form-control" name="keyword">
							</div>
							<!-- /input-group -->
							<!--<div class="form-group">
										<input type="text" class="form-control" placeholder="Search">
									</div>-->
							<button type="submit" class="btn btn-default">搜索</button>
						</form>
						<ul class="nav navbar-nav navbar-right">
						<c:if test="${empty loginUser }">
							<li><a href="login.jsp">登录</a></li>
							<li><a href="register.jsp">注册</a></li>
					    </c:if>
					    <c:if test="${not empty loginUser }">
					    <li><a href="${pageContext.request.contextPath}/orderlist">我的订单</a></li>
					    <li><a href="${pageContext.request.contextPath}/logout">注销</a></li>
						</c:if>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>
	</div>
</div>