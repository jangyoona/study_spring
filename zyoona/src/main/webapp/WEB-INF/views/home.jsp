<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset='utf-8' />
	<title>Home</title>
	<!-- <link rel='Stylesheet' href='/yoona-web/resources/styles/default.css' /> -->
	<style>
		button {
			width: 50%; height: 100px; 
			align-items: center;
		}
	</style>
</head>
<body>

	<div id='pageContainer'>
	
		<div id='content'>
			<br /><br /><br />
			<h2>Welcome to yoona WebSite !!!</h2>
		</div>
	</div>
	
	<button id="write-btn">글 작성하러 가기</button>
	<button id="login-btn">로그인</button>
	<button id="register-btn">회원가입</button>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('#write-btn').on('click', (e) => {
			location.href="/spring-demoweb/board/write";
			
		});
		
		$('#login-btn').on('click', (e) => {
			location.href='/spring-demoweb/account/login';
			
		});
		
		$('#register-btn').on('click', (e) => {
			location.href='/spring-demoweb/account/register';
		});
	});
</script>
</body>
</html>


    