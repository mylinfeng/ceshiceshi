<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Login</title>
    <link rel="shortcut icon" href="/static/love.ico">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row">
        <div class="col-md-4 col-md-offset-4" style="margin-top: 300px">
            <h2 style="margin-left: 120px">Login</h2>
            <form id="loginForm" method="post">
                <div class="form-group">
                    <label>账号</label>
                    <input type="text" class="form-control" id="username" name="username">
                </div>
                <div class="form-group">
                    <label>密码</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <button id="loginBtn" type="submit" class="btn btn-default">登录</button>
            </form>

        </div>
    </div>

</div>



<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/jquery-validate/1.19.0/jquery.validate.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script>
    $(function(){
        $("#loginBtn").click(function(){
            $("#loginForm").submit();
        });
        $("#loginForm").validate({
            errorElement : "span",
            errorClass : "text-danger",
            rules : {
                "username" : {
                    required : true
                },
                "password" : {
                    required : true
                }
            },
            messages : {
                "username" : {
                    required : "账号不能为空"
                },
                "password" : {
                    required : "密码不能为空"
                }
            },
            submitHandler : function(){
                $.ajax({
                    url : "/user/login.do",
                    type : "POST",
                    data : $("#loginForm").serialize(),
                    beforeSend : function(){
                        $("#loginBtn").attr("disabled", "disabled").text("登录中...")
                    },
                    success : function(res){
                        alert(res)
                    },
                    error : function(){
                        alert("系统繁忙,请稍后再试!")
                    },
                    complete : function(){
                        $("#loginBtn").removeAttr("disabled").text("登录")
                    }
                });
            }
        });

    });
</script>
</body>
</html>
