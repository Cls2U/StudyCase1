<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
	<head>
		<!--声明当前页面的编码集charset=gbk中文编码gb2312,charset=utf-8 国际编码-->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!--当前页面的三要素-->
		<title>房间类型</title>
		<meta name="Keywords" content="关键词,关键词">
		<meta name="description" content="描述">	
		<!--css , js-->
<style type="text/css">
*{margin:0px;padding:0px;border:0px;}
/*css样式的语法规则:属性:值; px 像素  */
.PicList{width:300px; height:414px; background:#9966FF; 
position:relative;/*相对定位*/
		float:left; margin:30px 20px;}
.PicList a{display:block; height:414px; }
.PicList .Con{width:300px; height:114px; -webkit-transition: all 0.5s ease;
			 position:absolute;/*绝对定位*/  left:0px; bottom:0px;font-size:12px; color:#FFFFFF;}
.PicList .Con p{display:none;/*隐藏*/line-height:22px;}

.PicList a:hover .Con{height:414px;width:300px;   /*上 左右 下*/ padding:182px 30px 0px;}

.PicList a:hover .Con p{display:block;/*显示*/}

.PicList .bg1{ background:url("images/picbg03.jpg");}
.PicList .bg2{ background:url("images/picbg03.jpg") -300px 0px;}
.PicList .bg3{ background:url("images/picbg03.jpg") -600px 0px;}
.PicList .bg4{ background:url("images/picbg03.jpg") -900px 0px;}


.PicList a:hover .bg1{background:url("images/cor01.jpg"); }
.PicList a:hover .bg2{background:url("images/cor02.jpg"); }
.PicList a:hover .bg3{background:url("images/cor03.jpg"); }
.PicList a:hover .bg4{background:url("images/cor04.jpg"); }
</style>

</head>

<body>
<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>
<!--div盒子模型，高度，宽度，放置内容  class="名字"  给盒子取名字-->
<div class="row" style="width: 100%; margin: 0 auto;text-align: center;">
<div class="col-md-3 col-lg-3">
<div class="PicList">
	<a href="${pageContext.request.contextPath}/roomListByKind?kid=${allRoomKind[0].kid}"><img src="images/norSingle.jpg" height="100%" width="100%"/>
		<div class="Con bg1">
			<p>${allRoomKind[0].kind}</p>
			<p>不用犹豫，独立空间使你放纵自我，舒适的环境让您的旅行更加美好。</p>
			<p>独立卫浴，空调，单人大床让你睡得更加放肆。</p>
            <p>￥${allRoomKind[0].price}/晚</p>
		</div>
	</a>
</div>
</div>
<div class="col-md-3 col-lg-3">
<div class="PicList">
	<a href="${pageContext.request.contextPath}/roomListByKind?kid=${allRoomKind[1].kid}"><img src="images/norDouble.jpg" height="100%" width="100%"/>
		<div class="Con bg2">
			<p>${allRoomKind[1].kind}</p>
			<p>与最合适的人在温馨饱满的空间共度甜蜜的时光，让您的记忆更加珍贵。</p>
			<p>独立卫浴，空调，两张单人床给你足够的空间。</p>
            <p>￥${allRoomKind[1].price}/晚</p>
		</div>
	</a>
</div>
</div>
<div class="col-md-3 col-lg-3">
<div class="PicList">
	<a href="${pageContext.request.contextPath}/roomListByKind?kid=${allRoomKind[2].kid}"><img src="images/graDouble.jpg" height="100%" width="100%"/>
		<div class="Con bg3">
			<p>${allRoomKind[2].kind}</p>
			<p>更加舒适与豪华的配置，独立的空间，让你不再有陌生环境的困扰，享受您奢华的人生！</p>
			<p>独立卫浴，两室一厅，每个独立的空间均有空调电视供您享受闲暇的时光。</p>
            <p>￥${allRoomKind[2].price}/晚</p>
		</div>
	</a>
</div>
</div>
<div class="col-md-3 col-lg-3">
<div class="PicList">
	<a href="${pageContext.request.contextPath}/roomListByKind?kid=${allRoomKind[3].kid}"><img src="images/graMulti.jpg"  height="100%" width="100%"/>
		<div class="Con bg4">
			<p>${allRoomKind[3].kind}</p>
			<p>最适合一家人出行旅游的居住，更大的空间和舒适的环境，让您充足地感受旅行的美好！</p>
			<p>三室一厅两卫，每个独立的空间均有空调电视供您享受闲暇的时光。</p>
            <p>￥${allRoomKind[3].price}/晚</p>
			
		</div>
	</a>
</div>
</div>
</div>
<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>