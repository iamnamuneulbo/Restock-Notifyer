<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.jsoup.Jsoup"%>
<%@ page import="org.jsoup.nodes.Document"%>
<%@ page import="org.jsoup.nodes.Element"%>
<%@ page import="org.jsoup.select.Elements"%>
<%@ page import="checker.Checker"%>
<%@ page import="checker.CheckerDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onload="load()">
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="main-js.js"></script>
	<%
		//로긴한사람이라면	userID라는 변수에 해당 아이디가 담기고 그렇지 않으면 null값
		String userID = "lsk";
		/*	
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");

		}*/
	%>
	<%
		CheckerDAO ckDao = new CheckerDAO();
		Checker ck = new Checker(ckDao.getList(userID));

		Thread t = new Thread(ck);
		t.start();
	
	%>

	<div id="notificationBlock" class="form-group">
		<label class="control-label">알림 메시지</label>
		<div class="input-group">
			<span class="input-group-addon">메시지</span> <input
				id="notificationMessage" type="text" class="form-control" disabled />
			<span class="input-group-btn">
				<button id="notificationButton" class="btn btn-info" type="button"
					disabled>알림</button>
			</span>
		</div>
	</div>

</body>
</html>