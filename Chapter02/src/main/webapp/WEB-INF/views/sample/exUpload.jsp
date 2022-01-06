<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul li { list-style:none; }
</style>
</head>
<body>
<form action="/sample/exUploadPost" method="post" enctype="multipart/form-data"><!-- 인코딩타입 설정 -->
	<ul>
		<!-- name 값이 모두 같으므로 배열로 처리필 -->
		<li><input type="file" name="files"></li>
		<li><input type="file" name="files"></li>
		<li><input type="file" name="files"></li>
		<li><input type="file" name="files"></li>
		<li><input type="file" name="files"></li>
		<li><input type="submit" value="submit"></li>
	</ul>
</form>
</body>
</html>