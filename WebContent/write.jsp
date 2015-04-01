<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	tr th{
		width:120px;
		background: lime;
	}
	
	.writeInput{
		width:360px;
	}

</style>
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
<script>

	$(document).ready(function(){
		console.log("ready to jQuery");
		
		$("#btnWrite").click(function(){
			console.log("#btnWrite");
			$("#articleWrite")
				.attr("action", "./doWrite").submit();
		});
		
	});
	
	


</script>
<style>

#btnWrite{
	cursor: pointer;
}

</style>
<body>
<h1>Write</h1>
<form id="articleWrite" name = "articleWrite" method="post" action="/BBS_ServletEx/doWrite">
<table width ="450">
	<tr>
		<th>제목</th>
		<td>
			<input class="writeInput"
				   type = "text" 
				   name="subject" 
				   id="subject" />
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>
			<input class="writeInput"
				   type = "text" 
				   name="writer" 
				   id="writer" />
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
			<textarea rows="30" cols="43" name="content"></textarea>
		</td>
	</tr>	
</table>
<img src="./resources/write.png" id="btnWrite" 
								 width="70px" 
								 height="40px"/>
</form>
</body>
</html>