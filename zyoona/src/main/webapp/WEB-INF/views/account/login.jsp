<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form id="login-form" method="POST">
		<table>
			<tr>
				<td>아이디 <input type="text" name="memberId" /></td>
			</tr>
			<tr>
				<td>비밀번호 <input type="text" name="passwd" /></td>
			</tr>
			<tr>
				<td><button id="login-btn">로그인</button>
				<button id="cansel-btn">취소</button></td>
			</tr>
		</table>
	</form>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('#login-btn').on('click', (e) => {
			
			const member = $('#login-form').serialize();
			$.ajax({
				'url' : '/login',
				'data' : 'member',
				'method' : 'POST',
				'success' : function(data, status, xhr) {
					
				};
				'error' : function(xhr, status, err) {
					alert('로그인 실패');
				}
				
			});
			
		});
		
		$('#cansel-btn').on('clikc', (e) => {
			location.href='/spring-demoweb/home';
		});
	});

</script>
</body>
</html>