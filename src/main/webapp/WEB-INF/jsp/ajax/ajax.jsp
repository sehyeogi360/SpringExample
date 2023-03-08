<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax 테스트</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>

	<h1>Ajax 테스트</h1>

	<div id ="text"></div>
	
	<script>
		$(document).ready(function() {

			$.ajax({
				type:"get"
				, url:"/ajax/request"
				//, data:{}
				, success:function(data){
					//console.log(data.name);
					$("#text").text(data.name + " "  + data.age);//tag사이에 값넣어주기
				
				}
				, error:function(){//error페이지 상황	
					alert("요청에러!!");
				}//이벤트없이 바로진행 되는것
				//response는 단순한 문자열 모든것은 아작스 메소드안에서 구현 
				//자바스크립트객체로 변환시킨다 그래서 객체로 쓸수 있다. 객체나 변수가 전달된게 절대 아님
			});
			
			
		});
	
	</script>
</body>
</html>