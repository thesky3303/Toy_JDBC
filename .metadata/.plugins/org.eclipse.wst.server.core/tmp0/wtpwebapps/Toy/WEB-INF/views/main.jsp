<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>학생 목록</title>
  <link href="/resources/css/main.css" rel="stylesheet">
 
	
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
  <h1>학생 목록</h1>
  <hr>

  <h4>학생 추가</h4>
  <form action="/std/add" method="post" id="addForm" onsubmit="return validateForm();">
    <div>
      학생명 : <input type="text" name="stdName" size=17> <br>
      나이 : <input type="text" name="stdAge" > <br>
      성별 : 
            <input type="text" 
               name="stdGender" 
               placeholder="M / F만 입력하세요">  남자 <input type=radio name="stdGender2" value="M"> 여자 <input type=radio name="stdGender2" value="F">   ← 다른방식 연습용 <br>
      점수   : 
            <input type="text" 
               name="stdScore" 
               placeholder="A ~ F만 입력하세요"> <br>
      
    </div>

    <button>추가</button>
  </form>

  <hr>
  
    <h2>학생 정보 목록</h2>
    
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>이름</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="std" items="${stdList}">
                <tr>
                    <td>${std.stdNo} </td>
                    <td>
                    <a href="/std/detail?stdNo=${std.stdNo}">${std.stdName}</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    	<%-- JS 연결 --%>
  <script src="/resources/js/main.js"></script>

  <%-- session 범위에 message가 있을 경우 --%>
  <c:if test="${not empty sessionScope.message}">
  	<script>
  		alert("${message}");
  	</script>
  	
  	<%-- message를 한 번만 출력하고 제거 --%>
  	<c:remove var="message" scope="session"/> 
  </c:if>

  
</body>
</html>