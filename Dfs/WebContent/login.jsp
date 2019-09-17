<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 뷰포트 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 스타일시트 참조  -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>로그인 페이지</title>
</head>
<body>
	<!-- 네비게이션  -->
	<nav class="navbar navbar-expand-md bg-light navbar-light">
		<a class="navbar-brand" href="main.jsp">JSP 게시판</a>
		<button type="button"
			class="navbar-toggler navbar-toggler-right collapsed"
			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
			aria-controls="navbarSupportedContent" aria-expaned="true"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="main.jsp">메인</a></li>
				<li class="nav-item"><a class="nav-link" href="bbs.jsp">게시판</a></li>
			</ul>
			<ul class="nav navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="join.jsp"><span
						class="fas fa-user"></span> Sign Up</a></li>
				<li class="nav-item"><a class="nav-link" href="login.jsp"><span
						class="fas fa-sign-in-alt"></span> Login</a></li>
			</ul>
		</div>
	</nav>
	<!-- 로긴폼 -->
	<div class="container col-lg-4"  style="padding-top: 20px;">
		<div class="col-lg-4"></div>
		<!-- 점보트론 -->
		<div class="jumbotron" style="padding-top: 20px;">
			<!-- 로그인 정보를 숨기면서 전송post -->
			<form method="post" action="loginAction.jsp">
				<h3 style="text-align: center;">로그인화면</h3>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디"
						name="userID" maxlength="20">
				</div>

				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호"
						name="userPassword" maxlength="20">
				</div>
				<input type="submit" class="btn btn-primary form-control"
					value="로그인">
			</form>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>