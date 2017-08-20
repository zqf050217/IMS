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
        <style type="text/css">
            .pad{padding: 1em 2em;}
        </style>
    </head>
    <body>
        <div class="pad">
            <h2>说明</h2>
            <p>本工程是一个Spring-Data-JPA和SpringMVC快速搭建项目框架的示例。</p>
            <p>特点：大多数情况下可以省略Dao的实现类，只定义一个接口，实现交给Spring-Data-JPA框架完成，使得开发过程既快速又一致。</p>
            <b>参考任务：</b>
            <ol class="pad">
                <li>参考已有代码，实现ImsUser所有增删查改方法，通过前端页面可交互；</li>
                <li>编写ImsUserService的单元测试，要求覆盖所有方法；</li>
                <li>增加department表和对应实体类，实现ims_user和department关联查询，在JSON中输出用户的部门名称而不是部门id；</li>
                <li>增加“团队”表和“团队-用户”映射表，用户与团队是多对多的关系，在JSON中输出多个特定团队的所有用户；</li>
                <li>遵循《成都研发中心软件项目开发流程与编码规范》。</li>
            </ol>
            <b>参考资料：</b><a href="http://blog.csdn.net/tian_yan71/article/details/73467899" target="_blank">戳这里</a>
            <h2>如果是第一次运行请点击 <span style="font-size: 70%;"><a href="#" onclick="runonce();">创建一批新用户</a></span></h2>
            <br>
            <h2>点击以下链接返回 JSON 结果</h2>
            <a href="users?page=0&size=15" target="_blank">列出所有用户 每页15人/第1页</a>
            <a style="margin-left: 2em;" href="users?page=1&size=15" target="_blank">列出所有用户 每页15人/第2页</a>
            <br><br>
            <a href="departments/1/users" target="_blank">列出所有部门为1的用户（默认参数：每页15人/第1页）</a>
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
