<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>入住登记</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/jquery.validate.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</head>
<script type="text/javascript">
	$(function() {
		if("${msg}"!="")
			alert("${msg}");
		$.validator.addMethod(
				//规则的名称
				"checkGid",
				//校验的函数
				function(value,element,params){
					
					//定义一个标志
					var flag = false;
					
					//value:输入的内容
					//element:被校验的元素对象
					//params：规则对应的参数值
					//目的：对输入的username进行ajax校验
					$.ajax({
						"async":false,
						"url":"${pageContext.request.contextPath}/checkGid",
						"data":{"gid":value},
						"type":"POST",
						"dataType":"json",
						"success":function(data){
							flag = data.isExist;
						}
					});
					//返回true代表该校验器不通过
					return flag;
				}
				
			);
		$.validator.addMethod(
				//规则的名称
				"checkIdcard",
				//校验的函数
				function(value,element,params){
					
					//定义一个标志
					var flag = false;
					
					//value:输入的内容
					//element:被校验的元素对象
					//params：规则对应的参数值
					//目的：对输入的username进行ajax校验
					$.ajax({
						"async":false,
						"url":"${pageContext.request.contextPath}/checkIdcard",
						"data":{"idcard":value},
						"type":"POST",
						"dataType":"json",
						"success":function(data){
							flag = data.isExist;
						}
					});
					//返回true代表该校验器不通过
					return flag;
				}
				
				
			);
		$.validator.addMethod(
				//规则的名称
				"checkRoomnum",
				//校验的函数
				function(value,element,params){
					
					//定义一个标志
					var flag = false;
					
					//value:输入的内容
					//element:被校验的元素对象
					//params：规则对应的参数值
					//目的：对输入的username进行ajax校验
					$.ajax({
						"async":false,
						"url":"${pageContext.request.contextPath}/checkRoomnum",
						"data":{"roomnum":value},
						"type":"POST",
						"dataType":"json",
						"success":function(data){
							flag = data.isExist;
						}
					});
					//返回true代表该校验器不通过
					return flag;
				}
				
			);
			$("#orderForm").validate({
				rules : {
					"roomnum":{
						"checkRoomnum" : true,
						"required" : true
					},
					"gid" : {
						"checkGid" : true,
						"required" : true
					},
					"idcard" : {
						"checkIdcard":true,
						"required" : true,
						"rangelength" : [ 18, 18 ]
					},
					messages : {
						"roomnum":{
							"checkRoomnum": "没有查询到该房间的预定信息！",
							"required" : "请输入房间号！"
						},
						"gid" : {
							"checkGid" : "没有查询到该订单！",
							"required" : "请输入订单编号！"
						},
						"idcard" : {
							"checkIdcard": "没有查询到该身份证的预订信息！",
							"required" : "请输入身份证号码!",
							"rangelength" : "身份证长度为18位"
						}
					}
				}
			});
	});
	
</script>
	<body>
		<div class="container-fluid">
			<!-- 引入header.jsp -->
			<jsp:include page="/header.jsp"></jsp:include>
			<div>
			<hr />
			<form class="form-horizontal" id="orderForm" action="${pageContext.request.contextPath }/checkGuestinfo" method="post"
				style="margin-top: 5px; margin-left: 150px;">
				<div class="form-group">
					<label for="text" class="col-sm-2 control-label">身份证号:</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="idcard" name="idcard"
							placeholder="请输您的身份证号">
					</div>
				</div>
				<div class="form-group">
					<label for="text" class="col-sm-2 control-label">房间号:</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="roomnum" name="roomnum" pattern="[0-9]"
							placeholder="请输入房间号">
					</div>
				</div>
				<div class="form-group">
					<label for="text" class="col-sm-2 control-label">订单号:</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="gid" name="gid" placeholder="请输入订单编号">
					</div>
				</div>
			<hr />
			<div style="margin-top: 5px; margin-left: 150px;">
				
				<p style="text-align: right; margin-right: 100px;">
					<div class="form-group" style='margin: 20px auto;'>
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="提交" name="submit"
								style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</p>
				

			</div>
			</form>
		</div>	
			
			<!-- 引入footer.jsp -->
			<jsp:include page="/footer.jsp"></jsp:include>
			
		</div>
	</body>

</html>