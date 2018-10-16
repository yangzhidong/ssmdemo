<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <script type="text/javascript" src="/js/jquery.js" ></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#AuthImg').on('click', function() {
                var timestamp = new Date().getTime();
                $(this).attr("src", $("#AuthImg").attr('src') + '?' + timestamp);
            });
        })
    </script>
</head>
<body>
测试页
<form action="/first/testPost" method="POST">
    用户名：<input type="text" name="userName"><br>
    <button>提交</button>
</form>
<a href="/first/testGet">测试GET</a><br>

<form action="/first/upload" method="post"  enctype="multipart/form-data">
    用户名：<input type="text" name="username"><br>
    上传文件：<input type="file" name="fileName" ><br>
    <button>提交</button>
</form>

<form action="/first/mostUpload" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="name"><br>
    上传文件：<input type="file" name="fileName" ><br>
    用户名：<input type="text" name="name"><br>
    上传文件：<input type="file" name="fileName" ><br>
    <button>提交</button>
</form>

<img src="getVerificationCodeImage" id="AuthImg">

</body>
</html>