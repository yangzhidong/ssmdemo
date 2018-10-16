<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>17商城</title>
    <link type="text/css" href="/css/css.css" rel="stylesheet" />
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/js.js"></script>
</head>

<body style=" background:#FFF;">
<div class="loginLogo">
    <div class="logoMid">
        <h1 class="logo" style="height:71px;padding-top:10px;"><a href="/index.html"><img src="/images/loginLogo.jpg" width="241" height="71" /></a></h1>
        <div class="loginReg">
            还没有会员账号?&nbsp;<a href="/login/register.html">免费注册</a>
        </div><!--loginReg/-->
    </div><!--logoMid/-->
</div><!--loginLogo/-->
<div class="loginBox">
    <div class="loginLeft">
        <img src="/images/logoinimg.jpg" width="716" height="376" />
    </div><!--loginLeft/-->
    <form action="vip.html" method="get" class="loginRight">
        <h2>会员登录</h2>
        <h3>用户名</h3>
        <input type="text" class="name" />
        <h3>密码</h3>
        <input type="password" class="pwd" />
        <div class="zhuangtai">
            <input type="checkbox" checked="checked" /> 下次自动登录
        </div><!--zhuangtai/-->
        <div class="subs">
            <input type="image" src="/images/sub.jpg" class="submit" />
        </div>
    </form><!--loginRight/-->
    <div class="clears"></div>
</div><!--loginBox/-->
</body>
</html>