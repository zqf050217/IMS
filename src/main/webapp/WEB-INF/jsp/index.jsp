<%-- 
    Document   : index
    Created on : 2017-8-20, 17:48:18
    Author     : L.X <gugia@qq.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Spring-Data-JPA Demo</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <h2>如果是第一次运行请点击[创建一批新用户]</h2>
        <a href="#" onclick="runonce();">创建一批新用户</a><br>
        <div style="padding: 0 2em;">
            <h2>点击以下链接返回json结果</h2>
            <a href="users?page=0&size=15">列出所有用户 每页15人/第1页</a><a href="users?page=1&size=15">列出所有用户 每页15人/第2页</a>
            <br>
            <a href="departments/1/users">列出所有部门为1的用户（默认参数：每页15人/第1页）</a>
        </div>
        <script type="text/javascript">
            function runonce() {
                $.ajax({
                    type: 'POST',
                    url: 'user',
                    data: {size: 20},
                    dataType: 'json',
                    success: function (result) {
                        if (result === 'success') {
                            alert('创建新用户成功');
                        } else {
                            alert('创建时出现错误');
                        }
                    }
                });
            }
        </script>
        <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
