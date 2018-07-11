<%@ page language="java" pageEncoding="UTF-8"%>
<html>

	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
		<style type="text/css">
BODY {
	MARGIN: 0px;
	BACKGROUND-COLOR: #ffffff
}

BODY {
	FONT-SIZE: 12px;
	COLOR: #000000
}

TD {
	FONT-SIZE: 12px;
	COLOR: #000000
}

TH {
	FONT-SIZE: 12px;
	COLOR: #000000
}

</style>
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
setInterval(refresh,1000);
function refresh(){
	$("#datetime").html(new Date().toString());
}
</script>
	</head>
	<body>
		<table width="100%" height="70%"  class="table table-hover">
			<tr>
				<td width="100%" background="${pageContext.request.contextPath}/images/admintopbk.jpg">
				</td>
			</tr>
		</table>
		<table width="100%" class="table table-hover">
			<tr>
				<td height="30" valign="bottom"  background="${pageContext.request.contextPath}/images/mis_01.jpg">
					<table width="100%" class="table table-hover">
						<tr>
							<td width="85%" align="left">
							 <div id="datetime"></div>
							</td>
							<td width="15%">
								<table width="100%" class="table table-hover">
									<tr>
										<td width="16" background="${pageContext.request.contextPath}/images/mis_05b.jpg"
											>
											<img
												src="${pageContext.request.contextPath}/images/mis_05a.jpg"
												width="6" height="18">
										</td>
										<td width="155" valign="bottom"
										background="${pageContext.request.contextPath}/images/mis_05b.jpg"
											>
                                            
											用户名：
											<font color="blue">${loginUser.uid}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="${pageContext.request.contextPath}/logout" target="_top">注销</a>
										</td>
										<td width="10" align="right"
											background="${pageContext.request.contextPath}/images/mis_05b.jpg">
											<img src="${pageContext.request.contextPath}/images/mis_05c.jpg" width="6" height="18">
										</td>
									</tr>
								</table>
							</td>
							<td align="right" width="5%">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</HTML>
