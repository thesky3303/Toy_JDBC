/* 제목이 작성되지 않은 경우 form 제출 막기*/
console.log("testetstst");

const addForm = document.querySelector("#addForm");
const stdName = document.querySelector("[name=stdName]");

// addForm 이 제출 될 때 
addForm.addEventListener("submit", e => {

  // e : 이벤트 객체

  // 제목 입력된 값 가져와서 양쪽 공백 제거
  const input = stdName.value.trim();
  // 

// 제목이 입력되지 않았을 때
if(input.length == 0) {
   // form 제출 이벤트 막기
  e.preventDefault();

  alert("이름을 입력 해주세요");
  stdName.focus(SEQ_STD_NO.NEXTVAL);
}

});

