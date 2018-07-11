<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
</head>
<body>

<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">
	
		d = new dTree('d');
		d.add('01',-1,'系统菜单树');
		d.add('0102','01','房间信息管理','','','mainFrame');
		d.add('010201','0102','房间分类管理','${pageContext.request.contextPath}/adminAllRoomKindList','','mainFrame');
		d.add('010202','0102','房间状态管理','${pageContext.request.contextPath}/adminAllRoomStateList','','mainFrame');
		d.add('0103','01','用户管理','','','mainFrame');
		d.add('010301','0103','用户管理','${pageContext.request.contextPath}/adminAllUserList','','mainFrame');
		d.add('0104','01','房间管理');
		d.add('010401','0104','房间管理','${pageContext.request.contextPath}/adminAllRoomList','','mainFrame');
		d.add('0105','01','订单管理');
		d.add('010501','0105','订单管理','${pageContext.request.contextPath}/adminAllGuestList','','mainFrame');
		document.write(d);
		
	</script>
</div>
</body>
</html>
