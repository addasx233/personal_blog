<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <meta charset="utf-8">
    <!--字体图标-->
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
    <style>
        .bg-wrap, body, html {
            height: 100%;
        }

        input {
            line-height: normal;
            -webkit-appearance: textfield;
            background-color: white;
            -webkit-rtl-ordering: logical;
            cursor: text;
            padding: 1px;
            border-width: 2px;
            border-style: inset;
            border-color: initial;
            border-image: initial;
        }

        input[type="text"], input[type="password"] {
            border: 0;
            outline: 0;
        }

        input, button {
            text-rendering: auto;
            color: initial;
            letter-spacing: normal;
            word-spacing: normal;
            text-transform: none;
            text-indent: 0px;
            text-shadow: none;
            display: inline-block;
            text-align: start;
            margin: 0em;
            font: 400 13.3333px Arial;
        }

        input[type=button] {
            -webkit-appearance: button;
            cursor: pointer;
        }

        .bg-wrap {
            position: relative;
            background: url(http://img.javaex.cn/FipOsQoe90u_7i3dOVpaeX5QD7c6) top left no-repeat;
            background-size: cover;
            overflow: hidden;
        }

        .main-cont-wrap {
            z-index: 1;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-left: -190px;
            margin-top: -255px;
            box-sizing: border-box;
            width: 380px;
            padding: 30px 30px 40px;
            background: #fff;
            box-shadow: 0 20px 30px 0 rgba(63, 63, 65, .06);
            border-radius: 10px;
        }

        .form-title {
            margin-bottom: 40px;
        }

        .form-title > span {
            font-size: 20px;
            color: #2589ff;
        }

        .form-item {
            margin-bottom: 30px;
            position: relative;
            height: 40px;
            line-height: 40px;
            border-bottom: 1px solid #e3e3e3;
            box-sizing: border-box;
        }

        .form-txt {
            display: inline-block;
            width: 70px;
            color: #595961;
            font-size: 14px;
            margin-right: 10px;
        }

        .form-input {
            border: 0;
            outline: 0;
            font-size: 14px;
            color: #595961;
            width: 155px;
        }

        .form-btn {
            margin-top: 40px;
        }

        .ui-button {
            display: block;
            width: 320px;
            height: 50px;
            text-align: center;
            color: #fff;
            background: #2589ff;
            border-radius: 6px;
            font-size: 16px;
            border: 0;
            outline: 0;
        }
    </style>
</head>
<body>
<div class="bg-wrap">
    <div class="main-cont-wrap login-model">
        <form id="register">
            <div class="form-title">
                <span>用户注册</span>
            </div>
            <div class="form-item">
                <span class="form-txt">账号：</span>
                <input type="text" class="form-input original" data-type="必填" id="loginName" name="registerName" placeholder="请输入账号"/>
            </div>
            <div class="form-item">
                <span class="form-txt">密码：</span>
                <input type="password" class="form-input original" data-type="必填" name="password" id="pwd1" placeholder="请输入密码"/>
            </div>

            <div class="form-item">
                <span class="form-txt">密码：</span>
                <input type="password" class="form-input original" data-type="必填" name="password2" id="pwd2" placeholder="请再次输入密码" onkeyup="validate()"><span id="tishi"></span></input>
            </div>
            <div class="form-btn">
                <input type="button" class="ui-button" id="submit" value="注册"/>
            </div>
        </form>
    </div>
</div>
</body>
<script>

    function validate() {
        var pwd1 = document.getElementById("pwd1").value;
        var pwd2 = document.getElementById("pwd2").value;

        <!-- 对比两次输入的密码 -->
        if(pwd1 == pwd2)
        {
            document.getElementById("tishi").innerHTML="<font color='green'>密码相同</font>";
            document.getElementById("button").disabled = false;
        }
        else {
            document.getElementById("tishi").innerHTML="<font color='red'>密码不相同</font>";
            document.getElementById("button").disabled = true;
        }
    }

    $("#submit").click(function () {
        if (javaexVerify()) {
            $.ajax({
                url: "register.json",
                type: "POST",
                dataType: "json",
                traditional: "true",
                data: $("#register").serialize(),
                success: function (rtn) {
                    if (rtn.code==="000000"){
                        //跳转到后台
                        javaex.optTip({
                            content: rtn.message
                        })

                        //延迟加载
                        setTimeout(function () {
                            //刷新页面

                            window.location.href="${pageContext.request.contextPath}/portal/login.action"
                        },1000)

                    }else{
                        addErrorMsg("loginName",rtn.message);
                    }
                }
            })
        }
    });

</script>
</html>
