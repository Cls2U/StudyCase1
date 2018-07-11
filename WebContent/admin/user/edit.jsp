<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
<script type="text/javascript">
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
		$("#editUserForm").validate({
			rules:{
				"upd":{
					"required":true,
					"rangelength":[6,16]
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
				}
			},
			messages:{
				"upd":{
					"required":"密码不能为空",
					"rangelength":"密码长度为6-16位"
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
	<body>
		<!--  -->
		<form id="editUserForm" name="editUserForm" action="${pageContext.request.contextPath}/editUser" method="post">
			
			<table class="table table-bordered table-hover" width="100%">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑用户</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						用户名：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="uid" readonly="readonly" value="${user.uid }" id="uid" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						 密码：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="upd" value="${user.upd }" id="upd" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						邮箱：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="email" value="${user.email }" id="email" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						电话：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="phone" value="${user.phone }" id="phone" class="bg"/>
					</td>
				</tr>
				<tr>
				<td>
				<input type="hidden" name="sign" readonly="readonly" value="${user.sign }">
				<input type="hidden" name="state" readonly="readonly" value="${user.state }">
				<input type="hidden" name="code" readonly="readonly" value="${user.code }">
				</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="btn">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="btn">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="btn" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>