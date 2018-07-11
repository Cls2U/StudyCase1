<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Gx工作室</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container-fluid">

			<!-- 引入header.jsp -->
			<jsp:include page="/header.jsp"></jsp:include>

			<div class="container-fluid">
				<div class="main_con">
					<h2>系统简介</h2>
					<hr/>
					<div>
						<p>
							<h4><font color="blue">“Gx工作室”</font>是由湖南人文科技学院2014级计科一班学生创立，本系统为该工作室毕业设计作品。</h4>
						

						<p>
						<h4>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本系统的在已有的酒店管理系统的基础上，针对客房管理、客房预订、用户入住以及记账结算等业务要求进行一个轻量化的设计，开发模型基于MVC（Model-View-Controller),数据库采用MySQL,以此达到开发成本降至最低的目的，设计并实现了小型酒店管理系统。系统主要包括了预定管理，包括客户预定和前台预定，收银管理、房间管理、入住登记、退房审核等功能，重点解决房间管理、客户入住和收银结算等核心功能。
							本酒店管理系统是一个轻量化、快捷、易操作的管理平台，可以为酒店管理人员提供一个信息共享、工作便捷的工作环境。本系统的大致内容如下：
						</h4>
						

						<p><h4>
							1.本系统基于B/S的应用实现模式，在MVC设计模式的基础上设计并实现了小型酒店管理系统，包括了前台操作与后台操作两个大的模块，前台操作有注册、登录、房间预订、入住登记、退房审核、收银结算六个功能模块，重点解决前台繁琐的日常业务管理，房间信息的及时反馈功能和访问系统的安全性问题，后台操作有登录、用户管理、房间管理、订单管理、收银汇总五个模块功能，重点解决管理者的整体数据查看与管理。
						   </h4>
						

						<p><h4>
							2.本系统的开发过程遵循软件工程的理论，采用了瀑布开发的模型，详细地介绍了小型酒店管理系统的开发背景、研究现状、系统业务的需求、功能需求、数据库设计、安全设计，给出了核心功能模块的界面实现和代码实现过程，并对系统做了较为详细的功能测试和性能测试，保证了系统的正确与高效。
						</h4>
						
					</div>
				</div>
			</div>
		</div>
		
		<!-- 引入footer.jsp -->
		<jsp:include page="/footer.jsp"></jsp:include>

	</body>

</html>