<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台登录界面</title>

<link rel="stylesheet" type="text/css" href="css/adminloginstyle.css" />
<link rel="stylesheet" type="text/css" href="css/animate.css" />

<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>	  
	  
</head>
 
<body>
	
<canvas id="christmasCanvas" style="top: 0px; left: 0px; z-index: 5000; position: fixed; pointer-events: none;" width="1285" height="100%"></canvas>

<script type="text/javascript">
	 var snow = function() {
    if(1==1) {
      $("body").append('<canvas id="christmasCanvas" style="top: 0px; left: 0px; z-index: 5000; position: fixed; pointer-events: none;"></canvas>');
      var b = document.getElementById("christmasCanvas"), a = b.getContext("2d"), d = window.innerWidth, c = window.innerHeight;
      b.width = d;
      b.height = c;
      for(var e = [], b = 0;b < 70;b++) {
        e.push({x:Math.random() * d, y:Math.random() * c, r:Math.random() * 4 + 1, d:Math.random() * 70})
      }
      var h = 0;
      window.intervral4Christmas = setInterval(function() {
        a.clearRect(0, 0, d, c);
        a.fillStyle = "rgba(255, 255, 255, 0.6)";
        a.shadowBlur = 5;
        a.shadowColor = "rgba(255, 255, 255, 0.9)";
        a.beginPath();
        for(var b = 0;b < 70;b++) {
          var f = e[b];
          a.moveTo(f.x, f.y);
          a.arc(f.x, f.y, f.r, 0, Math.PI * 2, !0)
        }
        a.fill();
        h += 0.01;
        for(b = 0;b < 70;b++) {
          if(f = e[b], f.y += Math.cos(h + f.d) + 1 + f.r / 2, f.x += Math.sin(h) * 2, f.x > d + 5 || f.x < -5 || f.y > c) {
            e[b] = b % 3 > 0 ? {x:Math.random() * d, y:-10, r:f.r, d:f.d} : Math.sin(h) > 0 ? {x:-5, y:Math.random() * c, r:f.r, d:f.d} : {x:d + 5, y:Math.random() * c, r:f.r, d:f.d}
          }
        }
      }, 70);
}
    }
	$(function() {
		snow();
		if("${requestScope.msg}"!="")
			alert("${requestScope.msg}");
	});
</script>

<h2 align="center">酒店管理系统管理中心</h2>

<div class="login_frame"></div>

<div class="LoginWindow">
	<div>
		<div class="login">
			<form method="post" action="${pageContext.request.contextPath }/adminLogin">
			<p><input type="text" name="uid" id="uid" placeholder="用户名" value=""></p>
			<p><input type="password" name="upd" id="upd" placeholder="密码" value=""></p>
			<p class="login-submit"><button type="submit" class="login-button" id ="submit">登录</button></p>
			</form>
		</div>
	</div>
</div>

<div id="timeArea"><script type="text/javascript">LoadBlogParts();</script></div>

<script type="text/javascript">
$(function(){
	$(".btn").click(function(){
	var left = ($(window).width()*(1-0.35)) /2;//box弹出框距离左边的额距离
	var height =  ($(window).height()*(1-0.5)) /2;
	
  
   $(".opacity_bg").css("opacity","0.3").show();
   });
});
</script>
<div style="text-align:center;">
</div>
</body>
</html>