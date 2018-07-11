<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		
		<!-- 弹出层插件 -->
		<link href="${pageContext.request.contextPath}/css/popup_layer.css" type="text/css" rel="stylesheet"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/popup_layer.js"></script>		
		<!-- 调用插件弹出层的方法 -->
		<script type="text/javascript">
			$(function(){
				//弹出层插件调用
				new PopupLayer({
					trigger:".clickedElement",
					popupBlk:"#showDiv",
					closeBtn:"#closeBtn",
					useOverlay:true
				});
				
			});
			function findOrderInfoByGid(gid){
				$.post(
						"${pageContext.request.contextPath }/findGuestinfoByGid",
						
						{"gid":gid},
						
						function(data){
							
							var content="<tr id='showTableTitle'><th width='10%'>房间号</th><th width='35%'>房间类型</th><th width='10%'>价格</th><th width='15%'>住客电话</th><th width='15%'>应收金额</th><th width='15%'>实收金额</th></tr>";
							content+="<tr style='text-align: center;'><td>"+data.roomnum+"</td><td>"+data.kind+"</td><td>"+data.price+"</td><td>"+data.phone+"</td><td>￥"+data.total+"</td>";
							content+="<td>￥"+data.deposit+"</td></tr>";
						$("#showDivTab").html(content);	
						$("#shodDivOid").html(data.gid);
						
						},
						"json"
						);
			}
			
			
			
		</script>
		
	</HEAD>
	<body>
	
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table class="table table-bordered table-hover" width="100%">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单列表</strong>
						</TD>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table class="table table-bordered table-hover" width="100%">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="15%">
										下单时间
									</td>
									<td align="center" width="10%">
										姓名
									</td>
									<td align="center" width="15%">
										身份证
									</td>
									<td align="center" width="10%">
										房间编号
									</td>
									<td align="center" width="10%">
										订单状态
									</td>
									<td align="center" width="20%">
										时间
									</td>
									<td align="center" width="10%">
										操作人
									</td>
									<td align="center" width="10%">
									
									</td>
								</tr>
								<c:forEach items="${list }" var="guest">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="15%">
										${guest.ordertime }
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">
										${guest.name }
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="15%">
										${guest.idcard }
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">
										${guest.rid }
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">
										${States[guest.state-1].message }
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="20%">
										${guest.arrivaltime }&nbsp;~&nbsp;${guest.departuretime }
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%">
										${guest.operator }
									</td>
									<td align="center" style="HEIGHT: 22px" width="10%">
										<input type="button" value="订单详情" class="clickedElement" onclick="findOrderInfoByGid('${guest.gid }')"/>
									</td>
					
								</tr>
								
								</c:forEach>
								
								
							</table>
						</td>
					</tr>
					
				</TBODY>
			</table>
		</form>
		
		<!-- 弹出层 HaoHao added -->
        <div id="showDiv" class="blk" style="display:none;">
            <div class="main">
                <h2>订单编号：<span id="shodDivOid" style="font-size: 13px;color: #999"></span></h2>
                <a href="javascript:void(0);" id="closeBtn" class="closeBtn">关闭</a>
				<div style="padding:20px;">
					<table id="showDivTab" style="width:100%">
					</table>
				</div>
            </div>
            
        </div>
		
		
	</body>
</HTML>

