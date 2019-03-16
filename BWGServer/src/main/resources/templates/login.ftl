<!DOCTYPE html>
<html>
<head lang="en">
    <title>首页</title>
    <script crossorigin="anonymous" integrity="sha384-fJU6sGmyn07b+uD1nMk7/iSb4yvaowcueiQhfVgQuD98rfva8mcr1eSvjchfpMrH" src="https://lib.baomitu.com/jquery/3.3.1/jquery.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <style>
        .container{
            min-width: 60rem;
            width: 80%;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
        }
        .show{
            padding-top: 3rem;
            padding-bottom: 5rem;
            padding-left: 2rem;
            padding-right: 2rem;
            background: hsla(0,0%,100%,.25) border-box;
            border-radius: .3rem;
            box-shadow: 0 0 0 1px hsla(0,0%,100%,.3) inset,
            0 .5em 1em rgba(0, 0, 0, 0.6);
            text-shadow: 0 1px 1px hsla(0,0%,100%,.3);
        }
        show::before{
            content: '';
            position: absolute;
            top: 0; right: 0; bottom: 0; left: 0;
            margin: -30px;
            z-index: -1;
            -webkit-filter: blur(20px);
            filter: blur(20px);
        }
        input{
            outline:0px; -webkit-appearance:none;
            height: 8rem !important;
            font-size: 5rem !important;
            text-align: center;
        }
        .input-group{
            margin-bottom: 4rem;
        }
        h2{
            font-size: 7rem !important;
            text-align: center;
        }
        body{
            background-color: gainsboro;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="show">
            <form class="form-signin" role="form" name="f" action="/forLogin" method="POST">
                <h2 class="form-signin-heading" >欢迎登录</h2>
                <br>
                <div class="input-group">
                    <span class="glyphicon glyphicon-user input-group-addon"></span>
                    <input type="text" class="form-control" name="username" placeholder="username">
                </div>
                <br>
                <div class="input-group">
                    <span class="glyphicon glyphicon-lock input-group-addon"></span>
                    <input class="form-control" type="password" name="password" placeholder="password">
                </div>
                <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
                <br>
                <input class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Login">
            </form>
        </div>
    </div>


</body>
<script>
</script>
</html>