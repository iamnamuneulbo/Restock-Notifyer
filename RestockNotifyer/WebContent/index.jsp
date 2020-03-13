<%@ page import="com.restocknotifyer.checker.Checker"%>
<%@ page
	import="com.restocknotifyer.store.jdbc.RestockNotifyerJdbcStore"%>
<%@ page import="com.restocknotifyer.product.Product"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="refresh" content="10" /> -->
<title>Sample</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="./main.css" type="text/css">

<script src="./main.js"></script>
</head>
<body onload="load()">
	<h2 class="text-center mb-3">재입고 알림 서비스</h2>
	<hr />
	<div class="input-group mb-4" id="url-input-box">
		<div class="input-group-prepend">
			<span class="input-group-text" id="basic-addon1">URL</span>
		</div>
		<input type="text" class="form-control" placeholder="상품 URL 입력"
			aria-label="Username" aria-describedby="basic-addon1" id="url-input">
		<div class="input-group-append">
			<button class="btn btn-outline-secondary" type="button"
				id="button-addon1">추가</button>
		</div>
	</div>

	<table class="table" id="list-table">
		<%
			RestockNotifyerJdbcStore store = new RestockNotifyerJdbcStore();
			ArrayList<Product> prdList = store.select("lsk");
			Checker checker;
		%>

		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">상품 이미지</th>
				<th scope="col">상품명</th>
				<th scope="col">삭제</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Product prd : prdList) {
					checker = new Checker(prd);
					checker.check();
			%>
			<tr>
				<th scope="row"><%=prd.getPrdId()%></th>
				<td><img src="<%=prd.getPrdImg()%>" width="100px"></td>
				<td><a href="<%=prd.getPrdUrl()%>" target="_blank"><%=prd.getPrdName()%></a></td>
				<td><a href="#" class="btn btn-danger btn-circle"
					data-toggle="modal" data-target="#modalDelete">삭제 </a></td>
				<%
					if (prd.isStock()) {
				%>
				<script>
				notificationOpen('<%=prd.getPrdName()%>', '<%=prd.getPrdUrl()%>', '<%=prd.getPrdImg()%>');
				</script>
				<%
					}
				%>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

	<div class="modal fade" tabindex="-1" role="dialog" id="modalDelete">
		<div class="modal-dialog modal-dialog-centered modal-sm"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">삭제</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="d-none" id="deletePrdId"></div>
					<div>삭제하시겠습니까?</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-danger" id="deleteBtn"
						type="submit" form="deleteForm">삭제</button>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		$('[data-target="#modalDelete"]').on("click", function() {
			var prdId = $(this).closest('tr').find('th')[0].innerText;
			console.log($(".modal-body #deletePrdId"));
			$(".modal-body #deletePrdId").text(prdId);
		});
	</script>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>
