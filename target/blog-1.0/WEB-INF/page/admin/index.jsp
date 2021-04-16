<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>无标题文档</title>
    <!--字体图标$ {pageContext.request.contextPath}表示根目录-->
    <link href="${pageContext.request.contextPath}/static/javaex/pc/css/icomoon.css" rel="stylesheet" />
    <!--动画-->
    <link href="${pageContext.request.contextPath}/static/javaex/pc/css/animate.css" rel="stylesheet" />
    <!--骨架样式-->
    <link href="${pageContext.request.contextPath}/static/javaex/pc/css/common.css" rel="stylesheet" />
    <!--皮肤（缇娜）-->
    <link href="${pageContext.request.contextPath}/static/javaex/pc/css/skin/tina.css" rel="stylesheet" />
    <!--jquery，不可修改版本-->
    <script src="${pageContext.request.contextPath}/static/javaex/pc/lib/jquery-1.7.2.min.js"></script>
    <!--全局动态修改-->
    <script src="${pageContext.request.contextPath}/static/javaex/pc/js/common.js"></script>
    <!--核心组件-->
    <script src="${pageContext.request.contextPath}/static/javaex/pc/js/javaex.min.js"></script>
    <!--表单验证-->
    <script src="${pageContext.request.contextPath}/static/javaex/pc/js/javaex-formVerify.js"></script>
</head>

<body>

<!--导航-->
<c:import url="head.jsp"/>
<!--主题内容-->
<div class="admin-mian">
    <!--菜单-->
    <c:import url="menu.jsp"/>
</div>
</body>
</html>

</html>