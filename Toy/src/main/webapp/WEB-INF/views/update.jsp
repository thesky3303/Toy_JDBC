<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${std.stdName} 수정 페이지</title>
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
  
  <h4>학생 정보 수정</h4>

  <form action="/std/update" method="post" id="updateForm">
    <div>
      학생명 : <input type="text" name="stdName" size=17> <br>
      나이 : <input type="text" name="stdAge" > <br>
      성별 : 
            <input type="text" 
               name="stdGender" 
               placeholder="M / F만 입력하세요"> <br>
      점수   : 
            <input type="text" 
               name="stdScore" 
               placeholder="A ~ F만 입력하세요"> <br>
      
    </div>

    <input type="hidden" name="stdNo" value="${param.stdNo}">
    
    <button>수정</button>
    
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
    
  </form>

	<%-- session 스코프에 message 있으면 alert 출력하기 --%>
	  <c:if test="${not empty sessionScope.message}">
	  	<script>
	  		alrert("${message}");
	  	</script>
	  	
	  	<c:remove var="message" scope="session" />
	  </c:if>



</body>
</html>