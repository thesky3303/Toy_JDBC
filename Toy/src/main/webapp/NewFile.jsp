<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대문자 입력 폼</title>
<script type="text/javascript">
function convertToUpperCase(input) {
    // 입력값을 대문자로 변환
    input.value = input.value.toUpperCase();
}

function validateForm() {
    var input = document.getElementById("uppercaseInput").value;
    // 대문자, 숫자, 공백만 허용하는 정규식
    var pattern = /^[A-Z0-9\s]*$/;
    
    if (!pattern.test(input)) {
        alert("대문자만 입력 가능합니다!");
        return false;
    }
    return true;
}
</script>
</head>
<body>
    <h2>대문자 입력 폼</h2>
    <form onsubmit="return validateForm();">
        <label for="uppercaseInput">대문자 입력:</label>
        <input type="text" 
               id="uppercaseInput" 
               name="uppercaseInput" 
               onkeyup="convertToUpperCase(this)"
               placeholder="대문자를 입력하세요"
               style="width: 200px; padding: 5px;">
        <br><br>
        <input type="submit" value="제출">
    </form>
    
    <%
    // 폼이 제출되었을 때 입력값 처리
    String uppercaseValue = request.getParameter("uppercaseInput");
    if (uppercaseValue != null && !uppercaseValue.isEmpty()) {
    %>
        <p>입력된 값: <%= uppercaseValue %></p>
    <%
    }
    %>
</body>
</html>