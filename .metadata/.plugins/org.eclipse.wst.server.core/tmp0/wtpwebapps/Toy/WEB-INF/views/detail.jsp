<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>학생 상세 목록</title>
	<style>
	table {
		width: 100%;
		border-collapse: collapse;
		margin-top: 20px;
	}
	
	th, td {
		border: 1px solid #ddd;
		padding: 8px;
		text-align: left;
	}
	
	th {
		background-color: #f2f2f2;
	}
	
	tr:nth-child(even) {
		background-color: #f9f9f9;
	}
	
	tr:hover {
		background-color: #f5f5f5;
	}
	</style>
</head>


<body>

	<h2>학생 상세 정보 목록</h2>

	<div class="btn-container">
		<div>
			<button id="goToList" >목록으로</button>
			<button id="updateBtn">수정</button>
			<button id="deleteBtn">삭제</button>
		</div>
	</div>

	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
				<th>성적</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${std.stdNo}</td>
				<td>${std.stdName}</td>
				<td>${std.stdAge}</td>
				<td>${std.stdGender}</td>
				<td>${std.stdScore}</td>
			</tr>
		</tbody>
	</table>
	
	<%-- JS 연결 --%>
	<script src="/resources/js/detail.js"></script>

	


	<%-- session 범위에 message가 있을 경우 --%>
	<c:if test="${not empty sessionScope.message}">
		<script>
			alert("${message}");
			// JSP 해석 우선순위
			// 1 순위 : Java(EL/JSTL)
			// 2 순위 : Front(HTML, CSS, JS)
		</script>

		<%-- message를 한 번만 출력하고 제거 --%>
		<c:remove var="message" scope="session" />
	</c:if>
</body>
</html>