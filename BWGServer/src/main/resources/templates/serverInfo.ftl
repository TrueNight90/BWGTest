<!DOCTYPE html>
<html>
<head lang="en">
    <title>搬瓦工SS信息</title>
    <script crossorigin="anonymous" integrity="sha384-fJU6sGmyn07b+uD1nMk7/iSb4yvaowcueiQhfVgQuD98rfva8mcr1eSvjchfpMrH" src="https://lib.baomitu.com/jquery/3.3.1/jquery.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="/js/qrcode.js"></script>
    <style>
        .table{
            max-width: 1440px;
            text-align: center;
            margin: auto;
        }
        .table td{
            width:50%;
        }
        td img{
            margin: auto;
        }
        h2{
            text-align: center;
        }
    </style>
</head>
<body>


        <form id="info">
            <h2>搬瓦工SS信息<h2>
            <table class="table">
                <tr>
                    <td>ip:</td>
                    <td><input name = "ip"></td>
                </tr>
                <tr>
                    <td>port:</td>
                    <td><input name = "port"></td>
                </tr>
                <tr>
                    <td>password:</td>
                    <td><input name = "password"></td>
                </tr>
                <tr>
                    <td>pwdType:</td>
                    <td><input name = "pwdType"></td>
                </tr>
                <tr>
                    <td>ss:</td>
                    <td><input name = "ssUrl"></td>
                </tr>
                <tr>
                    <td colspan="2" id="qrcode">

                    </td>
                </tr>
            </table>
        </form>

        <#--<button class="btn"> click me</button>-->
</body>
<script>
    $(function(){
        $.ajax({
            type:'get',
            url:'/Info',
            success:function(data){
                for(var i in data){
                    $('input[name="'+i+'"]').val(data[i]);
                }
                new QRCode($('#qrcode')[0], $('input[name="ssUrl"]').val());
            }
        })
    })
</script>
</html>