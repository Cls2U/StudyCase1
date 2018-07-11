<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
		$(function(){
			if("${requestScope.msg}"!="")
				alert("${requestScope.msg}");
			$.post(
					"${pageContext.request.contextPath}/adminAllRoomKindServlet",
					function(data){
						//[{"kid":"xx","kind":"xx","price":"xx"}]
						//拼接<option value=""></option>
						var content="";
						for(var i=0;i<data.length;i++){
							content+="<option value="+data[i].kid+">"+data[i].kind+"</option>";
						}
						$("#kind").html(content);
					},
					"json"
					);
			$.post(
					"${pageContext.request.contextPath}/adminAllRoomStatuServlet",
					function(data){
						var content="";
						for(var i=0;i<data.length;i++){
							content+="<option value="+data[i].sign+">"+data[i].statu+"</option>";
						}
						$("#sign").html(content);
					},
					"json"
					);
			
		});
		
		</script>
	</HEAD>
	
	<body>
		<!--  -->
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/adminEditRoomByRid" method="post">
			&nbsp;
			<table class="table table-bordered table-hover" width="100%">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑房间</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
				    <td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						房间编号：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="rid" readonly="readonly" value="${param.rid }" id="rid" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						房间号：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="roomnum" value="${param.roomnum }" id="roomnum" class="bg"/>
					</td>
				</tr>
				<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						房间类型：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select id="kind" name="kind">
							
						</select>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						房间状态：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select name="sign" id="sign">
						</select>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="width: 100%" align="center"
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