<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/adminEditRoomKindByKid" method="post">
			&nbsp;
			<table class="table table-bordered table-hover" width="100%">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑房间分类</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						分类标识：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="kid" value="${param.kid }" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						分类名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="kind" value="" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						该类日格：
					</td>
				<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="price" value="${param.price }" id="userAction_save_do_logonName" class="bg"/>
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