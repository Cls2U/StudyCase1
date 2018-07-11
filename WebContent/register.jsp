<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<!-- 引入表单校验jquery插件 -->
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
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

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}

.error{
	color:red
}
</style>



<script type="text/javascript">
	
	//自定义校验规则
	$.validator.addMethod(
		//规则的名称
		"checkUid",
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
				"url":"${pageContext.request.contextPath}/checkUid",
				"data":{"uid":value},
				"type":"POST",
				"dataType":"json",
				"success":function(data){
					flag = data.isExist;
				}
			});
			//返回false代表该校验器不通过
			return !flag;
		}
		
	);
	$.validator.addMethod(
			//规则的名称
			"checkEmail",
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
					"url":"${pageContext.request.contextPath}/checkEmail",
					"data":{"email":value},
					"type":"POST",
					"dataType":"json",
					"success":function(data){
						flag = data.isExist;
					}
				});
				//返回false代表该校验器不通过
				return !flag;
			}
		);
	$.validator.addMethod(
			//规则的名称
			"checkPhone",
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
					"url":"${pageContext.request.contextPath}/checkPhone",
					"data":{"phone":value},
					"type":"POST",
					"dataType":"json",
					"success":function(data){
						flag = data.isExist;
					}
				});
				//返回false代表该校验器不通过
				return !flag;
			}
		);
	$(function(){
		$("#registerForm").validate({
			rules:{
				"uid":{
					"required":true,
					"checkUid":true,
					"rangelength":[6,16]
				},
				"upd":{
					"required":true,
					"rangelength":[6,16]
				},
				"reupd":{
					"equalTo":"#upd"
				},
				"email":{
					"required":true,
					"email":true,
					"checkEmail":true
				},
				"phone":{
					"required":true,
					"rangelength":[11,11],
					"number":true,
					"checkPhone":true
				},
				"sign":{
					"required":true
				}
			},
			messages:{
				"uid":{
					"required":"用户名不能为空",
					"checkUid":"此用户名已注册",
					"rangelength":"用户名长度为6-16位"
				},
				"upd":{
					"required":"密码不能为空",
					"rangelength":"密码长度为6-16位"
				},
				"reupd":{
					"equalTo":"两次密码不一致"
				},
				"email":{
					"required":"邮箱不能为空",
					"email":"邮箱格式不正确",
					"checkEmail":"此邮箱已注册"
				},
				"phone":{
					"required":"手机号码不能为空",
					"rangelength":"请输入正确格式的手机号码",
					"number":"请输入正确格式的手机号码",
					"checkPhone":"此手机号码已注册"
				}
			}
		});
	});

</script>

</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp" flush="false"></jsp:include>

	<div class="container-fluid"
		style="width: 100%; height: 1024px; background-image: url(images/slider2.jpg);">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>用户注册</font>USER REGISTER
				<form id="registerForm" class="form-horizontal" action="${pageContext.request.contextPath }/register" method="post" style="margin-top: 0px;">
					<div class="form-group" style='margin: 20px auto;'>
						<label for="uid" class="col-sm-2 control-label">用户名:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="uid" name="uid" placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group" style='margin: 20px auto;'>
						<label for="upd" class="col-sm-2 control-label">密码:</label>
						<div class="col-sm-6">
							<input type="password" class="form-control"  id="upd" name="upd" placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group" style='margin: 20px auto;'>
						<label for="reupd" class="col-sm-2 control-label">确认密码:</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="reupd" name="reupd" placeholder="请确认密码">
						</div>
					</div>
					<div class="form-group" style='margin: 20px auto;'>
						<label for="email" class="col-sm-2 control-label">Email:</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="email" name="email" placeholder="Email">
						</div>
					</div>
					<div class="form-group" style='margin: 20px auto;'>
						<label for="phone" class="col-sm-2 control-label">手机号码:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机号码">
						</div>
					</div>
					<div class="form-group opt" style='margin: 20px auto;'>
						<label for="sign" class="col-sm-2 control-label">用户类型:</label>
						<div class="col-sm-6">
							<label class="radio-inline"> 
								<input type="radio" name="sign" id="sign1" value="2" >会员
							</label> 
							<label class="radio-inline"> 
								<input type="radio" name="sign" id="sign2" value="1">管理员
							</label>
							<label class="error" for="sign" style="display:none ">请选择要注册的用户类型</label>
						</div>
					</div>
					<div class="form-group" style='margin: 20px auto;'>
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit"
								style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>




