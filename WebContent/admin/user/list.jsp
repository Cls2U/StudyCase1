<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(function() {
	if("${requestScope.msg}"!="")
		alert("${requestScope.msg}");
	});
</script>
</HEAD>
<body>
	<br>
		<table class="table table-bordered table-hover">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>用户列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table class="table table-bordered table-hover"
							width="100%">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 20px; BACKGROUND-COLOR: #afd1f3">

								<td align="center" width="10%">用户名</td>
								<td align="center" width="10%">密码</td>
								<td align="center" width="10%">用户类型</td>
								<td align="center" width="15%">邮箱</td>
								<td align="center" width="10%">电话</td>
								<td align="center" width="10%">激活状态</td>
								<td align="center" width="15%">激活码</td>
								<td align="center" width="10%">编辑</td>
								<td align="center" width="10%">删除</td>
							</tr>
							<c:forEach items="${list }" var="user">
							<tr onmouseover="this.style.backgroundColor = 'white'"
								onmouseout="this.style.backgroundColor = '#F5FAFE';">
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">${user.uid }</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">${user.upd }</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="5%">${type[user.sign].kind }</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="15%">${user.email }</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">${user.phone }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="5%">${user.state }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="35%">${user.code }</td>
							    <td align="center" style="HEIGHT: 22px">
							    <form id="hiddenForm${user.uid }" name="hiddenForm${user.uid }" action="${pageContext.request.contextPath}/adminEditUser" method="post">
									<input type="hidden" name="uid" readonly="readonly" value="${user.uid }">
									<input type="hidden" name="upd" readonly="readonly" value="${user.upd }">
									<input type="hidden" name="sign" readonly="readonly" value="${user.sign }">
									<input type="hidden" name="email" readonly="readonly" value="${user.email }">
									<input type="hidden" name="phone" readonly="readonly" value="${user.phone }">
									<input type="hidden" name="state" readonly="readonly" value="${user.state }">
									<input type="hidden" name="code" readonly="readonly" value="${user.code }">
							     <input type="submit" value="" style="background: url('./images/i_edit.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);">
								</form>
								</td>
								<td align="center" style="HEIGHT: 22px"><a href="${pageContext.request.contextPath}/adminDeletUser?uid=${user.uid}"> <img
										src="${pageContext.request.contextPath}/images/i_del.gif"
										width="16" height="16" border="0" style="CURSOR: hand">
								</a></td>
							</tr>
							</c:forEach>
						</table>
					</td>
				</tr>

			</TBODY>
		</table>
</body>
</HTML>

