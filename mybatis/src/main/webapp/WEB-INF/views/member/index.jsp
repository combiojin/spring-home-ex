<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<meta charset="UTF-8">

<%@include file="../head.jsp"%>
<script type="text/javascript">
	function dodelete() {
		alert("삭제누름")
		$("#delefrm").submit();
	}
</script>
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
						<li><a href="${path}/freeboard/index.do">Freeboard</a></li>
						<li class="active"><a href="${path}/member/index.do">Member</a></li>
					</ul>
				</div>
			</nav>
		</div>
		<!-- 광고 -->
		<div class="row">

			<div class="jumbotron">
				<h1>자유게시판</h1>
				<p>mysql과 mybatis를 이용하여 게시판을 구현했습니다.</p>
			</div>
		</div>
		<!-- body -->
		<div class="row">
			<form id="delefrm" action="${path}/freeboard/delete.do">
				<h2>게시판목록</h2>
				<div class="col-sm-1" style="float: right; margin: 10px;">
					<button class="btn btn-primary" onclick="dodelete();">글삭제</button>
				</div>
				<div class="col-sm-1" style="float: right; margin: 10px;">
					<a class="btn btn-primary" href="${path}/freeboard/insert.do">글쓰기</a>
				</div>
				<table class="table table-hover table-bordered">
					<tr>
						<th></th>
						<th>순번</th>
						<th>제목</th>
						<th>날짜</th>
						<th></th>
					</tr>
					<c:forEach items="${list}" var="fb">
						<tr>
							<td><input type="checkbox" name="idx" value="${fb.idx}"></td>
							<td>${fb.idx}</td>
							<td>${fb.title}</td>
							<td>${fb.rgdate}</td>
							<td><a class="btn btn-primary"
								href="${path}/freeboad/update.do?idx=${fb.idx}">수정</a></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
		<div class="row"></div>
	</div>
</body>
</html>












