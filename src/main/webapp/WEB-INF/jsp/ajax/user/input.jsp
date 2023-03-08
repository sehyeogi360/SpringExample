<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 추가</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>													<!-- 폼을 객체화 -->			
<!--  	<form method = "get" action="/ajax/user/add" id="addForm">  -->
		<label>이름</label> <input type="text" name="name" id="nameInput"> <br>
		<label>생년월일</label> <input type="text" name="birthday" id="birthdayInput"> <br>
		<label>이메일</label> <input type="text" name="email" id="emailInput"> <br>
		<label>자기소개</label> <input type="text" name="introduce" id="introduceInput"> <br>
		<button type="submit" id="addBtn">추가</button>
<!--	</form>-->
	
	<script>
		$(document).ready(function(){//클릭과 폼메서드는 아무상관없는것. 빈칸있다고 떠도 add로 이동
			$("#addBtn").on("click", function(){//이번엔 폼안쓰기.
			//	$("#addForm").on("submit", function() { //오류가 있음 뭐하나 빈칸있는데도 넘어가짐
					let name = $("#nameInput").val();
					let birthday = $("#birthdayInput").val();
					let email = $("#emailInput").val();
					let introduce = $("#introduceInput").val();
					//alert해보니 정상적으로 됐다.
				if(name == ""){
					alert("이름을 입력하세요");
					return ; //서밋중단시킬수있다. 이래야
				}
				if(birthday == " "){
					alert("생년월일을 입력하세요");
					return ;
				}
				
				if(email == ""){
					alert("이메일을 입력하세요");
					return ;
				}
				
				if(introduce == ""){
					alert("자기소개를 입력하세요");
					return ;
				}
				
				$.ajax({//ajax활용해보기
					type:"get"		
					, url:"/ajax/user/add"//api 형태로 변형시켜야함
					, data:{"name" : name, "birthday" : birthday, "email":email, "introduce":introduce}//변수값을 이렇게 넣어준다. 나머지것들도 컨트롤러값들 불러오기
					, success:function(data){//여기도 successs라 해서 에러가 떴음.
						// 성공 : {"result": "success" }
						// 실패 : {"result": "fail"}
						//alert("");
						if(data.result == "success") {//succes 라 해서 실행이안됬었나봄 
							// 리스트 페이지로 이동
							location.href = "/ajax/user/list";
						} else {
							alert("추가 실패");
						}//이렇게하면 바로 얻어쓸수 있다.
						
					}

					, error:function(){
						alert("추가 에러");
					}
				});
				
	
				
				
				
			});//event 동작 on
			
	
	});
	</script>
</body>
</html>