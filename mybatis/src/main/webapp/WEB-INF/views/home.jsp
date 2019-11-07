<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	
	<%@include file="head.jsp" %>
	
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
					<li class="active"><a href="${path}">Home</a></li>
					<li><a href="${path}/freeboard/index.do">Freeboard</a></li>
					<li><a href="${path}/member/index.do">Member</a></li>
					</ul>
				</div>
			</nav>
		</div>
		<!-- 광고 -->
		<div class="row">
			<div class="jumbotron">
				<h1>포트폴리오</h1>
				<p>신입개발자가 되고 싶습니다.</p>
			</div>
			<p>java jsp spring 순서대로 배웠습니다.</p>
			<p>html css javascript jqeury 는 부족하지만 순서대로 학습중입니다.</p>
		</div>
		<!-- body -->
		<div class="row">
		
		</div>
	</div>
</body>
</html>












