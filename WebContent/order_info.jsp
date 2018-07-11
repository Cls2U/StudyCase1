<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>订单录入</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
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
</style>
</head>
<script type="text/javascript">
	function confirmOder() {
		$("#orderForm").validate({
			rules : {
				"idcard" : {
					"required" : true,
					"rangelength" : [ 18, 18 ]
				},
				"phone" : {
					"required" : true,
					"rangelength" : [ 6, 13 ]
				},
				messages : {
					"idcard" : {
						"required" : "请输入正确的身份证号码",
						"rangelength" : "身份证长度为18位"
					},
					"phone" : {
						"required" : "请输入正确的手机号码",
						"rangelength" : "手机号码长度为6-13位"
					}
				}
			}
		});
		$("#orderForm").submit();
	}
</script>
<body>
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong>订单详情</strong>
				<table class="table table-bordered">
					<tbody>
						<tr class="warning">
							<th>图片</th>
							<th>房号</th>
							<th>日价</th>
							<th>时长</th>
							<th>小计</th>
						</tr>
						<tr class="active">
							<td width="60" width="40%"><input type="hidden" name="id"
								value="22"> <c:if test="${room.kind==1 }">
						<img style="opacity: 1; width: 200px; height: 150px;" title=""
							class="medium" src="images/norSingle.jpg">
					</c:if>
					<c:if test="${room.kind==2 }">
						<img style="opacity: 1; width: 200px; height: 150px;" title=""
							class="medium" src="images/norDouble.jpg">
					</c:if>
					<c:if test="${room.kind==3 }">
						<img style="opacity: 1; width: 200px; height: 150px;" title=""
							class="medium" src="images/graDouble.jpg">
					</c:if>
					<c:if test="${room.kind==4 }">
						<img style="opacity: 1; width: 200px; height: 150px;" title=""
							class="medium" src="images/graMulti.jpg">
					</c:if></td>
							<td width="30%"><a target="_blank"> ${room.roomnum }</a></td>
							<td width="20%">￥${kind[room.kind-1].price }/天</td>
							<td width="10%">${total/kind[room.kind-1].price }天</td>
							<td width="15%"><span class="subtotal">￥${total }</span></td>
						</tr>
					</tbody>
				</table>
			</div>

			<div style="text-align: right; margin-right: 120px;">
				支付金额: <strong style="color: #ff6600;">￥${total }元</strong>
			</div>

		</div>

		<div>
			<hr />
			<form class="form-horizontal" id="orderForm" action="${pageContext.request.contextPath }/submitguestinfo" method="post"
				style="margin-top: 5px; margin-left: 150px;">
				<div class="form-group">
					<label for="text" class="col-sm-2 control-label">姓名:</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="请输入您身份证上的姓名">
					</div>
				</div>
				<div class="form-group">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别:</label>
						<div class="col-sm-5">
							<label class="radio-inline"> 
								<input type="radio" name="sex" id="male" value="male" >男
							</label> 
							<label class="radio-inline"> 
								<input type="radio" name="sex" id="female" value="female">女
							</label>
						</div>
					</div>
				<div class="form-group">
					<label for="text" class="col-sm-2 control-label">身份证号:</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="idcard" name="idcard"
							placeholder="请输您的身份证号">
					</div>
				</div>
				<div class="form-group">
					<label for="text" class="col-sm-2 control-label">电话:</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="phone" name="phone" pattern="[0-9]"
							placeholder="请输入联系方式">
					</div>
				</div>
				<hr />
				<div class="form-group">
					<label for="text" class="col-sm-2 control-label">实付金额/押金:</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="deposit" name="deposit" placeholder="请输入已付金额">
					</div>
				</div>
			<hr />
			<div style="margin-top: 5px; margin-left: 150px;">
				<hr />
				<p style="text-align: right; margin-right: 100px;">
					<a href="javascript:;" onclick="confirmOder()">
						<img src="./images/finalbutton.gif" width="204" height="51"
						border="0" />
					</a>
				</p>
				<hr />

			</div>
			</form>
		</div>

	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>