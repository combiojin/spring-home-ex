  <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	
	<%@include file="../head.jsp" %>
	
</head>
<body>
	<div class="container">
		<!-- menu -->
		<div class="row">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">신입개발자</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="${path}">Home</a></li>
					<li class="active"><a href="${path}/freeboard/index.do">Freeboard</a></li>
					<li><a href="${path}/member/index.do">Member</a></li>
					</ul>
				</div>
			</nav>
		</div>
		<!-- 광고 -->
		<div class="row">
			<div class="jumbotron">
				<h1>글쓰기</h1>
				<p>제목과 글내용을 작성하실 수 있습니다.</p>
			</div>
		</div>
		<!-- body -->
		<div class="row">
			<form action="${path}/freeboard/insertProc.do">
				글제목
				<input class="form-control" type="text" name="title"/>
				글내용
				<textarea class="form-control" rows="10" cols="50" name="content"></textarea>
				<input class="btn btn-primary m-3" type="submit" value="글작성"/>
			</form>
		</div>
	</div>
</body>
</html>












