<!DOCTYPE html>
<html>
<head lang="en">
    <title>Spring Boot Demo - FreeMarker</title>
    <script crossorigin="anonymous" integrity="sha384-fJU6sGmyn07b+uD1nMk7/iSb4yvaowcueiQhfVgQuD98rfva8mcr1eSvjchfpMrH" src="https://lib.baomitu.com/jquery/3.3.1/jquery.js"></script>
    <script crossorigin="anonymous" integrity="sha384-rkSGcquOAzh5YMplX4tcXMuXXwmdF/9eRLkw/gNZG+1zYutPej7fxyVLiOgfoDgi" src="https://lib.baomitu.com/twitter-bootstrap/4.3.1/js/bootstrap.js"></script>
</head>
<body>
<h2>搬瓦工SS信息<h2>

        <form id="info">
            <table>
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
            }
        })
    })
</script>
</html>