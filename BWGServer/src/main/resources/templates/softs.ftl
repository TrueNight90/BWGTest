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
</head>
<body>

    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <p class="navbar-text"><a class="btn" href="Index">首页</a></p>
            <p class="navbar-text"><a class="btn" href="/Infos">服务器信息</a></p>
            <p class="navbar-text"><a class="btn" href="/softs">软件</a></p>
        </div>
    </nav>
    <div class="jumbotron">
        <div class="container">
            <button class="btn">windows</button>
            <button class="btn">android</button>
            <button class="btn">mac</button>
            <button class="btn">ios</button>
        </div>
    </div>

</body>
<script>
    $('li').click(function () {
        $('li').removeClass('active');
        $(this).addClass("active");
    })
</script>
</html>