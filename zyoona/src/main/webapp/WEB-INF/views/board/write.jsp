<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>게시판글쓰기</title>
	<link rel="Stylesheet" href="/spring-demoweb/resources/styles/default.css" />
	<link rel="Stylesheet" href="/spring-demoweb/resources/styles/input2.css" />
<style>
	table, td {
		align-items: center;
		text-align: center;
		border: 1px solid gray;
		width: 200px;
	}

</style>
</head>
<body>

	<div id="pageContainer">
	
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">게시글 정보</div>
		        <form id="yoonaform" action="write" method="post" enctype="multipart/form-data">
		        <table>
		            <tr>
		                <th>제목</th>
		                <td>
		                    <input type="text" name="title" style="width:580px" />
		                </td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td>
		             <%--    <input type="hidden" name="writer" value="${ loginuser.memberId }"/>
		                ${ sessionScope.loginuser.memberId }
		                </td> --%>
		                   <input type="hidden" id="writer" name="writer" value="user1"/>
		                user1
		                </td>
		            </tr>
		            <tr>
		                <th>첨부파일</th>
		                <td>
		                    <input type="file" name="attach" style="width:580px;height:20px" />
		                </td>
		            </tr>
		            <tr>
		                <th>글내용</th>
		                <td>
		                	<textarea name="content" style="width:580px" rows="15"></textarea>
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	<input type="submit" id="submit-btn" value="글쓰기" style="height:25px" />
		        	<input type="button" id="cancel-btn" value="취소" style="height:25px"  />
		        </div>
		        </form>
		    </div>
		</div>   	
	
	</div>
	</div>
	
<script src="http://code.jquery.com/jquery-3.7.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('#cancel-btn').on("click", function(event) {
			/* location.href = "/spring-demoweb/board/list"; */
			event.preventDefault();
			event.stopPropagation();
			location.href = "list";
			// history.back(); // 이전으로 이동하기 이것도 괜춘
		});
		
		
		$('#submit-btn').on('click', (e) => {
			const data = $('#yoonaform').serialize();
			const writer = $('#writer').val();
			event.preventDefault();
			
			$.ajax({
				'url' : '/write',
				'method' : 'POST',
				'data' : data,
				'success' : function(data, status, xhr) {
					alert('글 등록 완료!');
					location.href='/spring-demoweb/home';
				}
				'error' : function(xhr,status,err) {
					alert(err);
				}				
			});
		});
		
	});
	</script>
</body>
</html>