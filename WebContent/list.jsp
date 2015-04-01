<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List
 				, java.util.ArrayList
 				, kr.ktds.kth.model.ArticleModel" %>
 				
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 리스트</title>
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		console.log("ready to jQuery");
		
		
		$("#btnWrite").click(function(){
			console.log("click btn");
			location.href("./write");
			
		});
		
		
	});
	
	function goWrite(){
		
		
	}
	
</script>
<style>

#btnWrite{
	cursor: pointer;
}

</style>
</head>
<body>
<h1> View List</h1>
<%
	List<ArticleModel> articleList = 
			(List<ArticleModel>) request.getAttribute("articleList");
	
	if(articleList==null){
		articleList = new ArrayList<ArticleModel>();
	}
%>
<table border="1">
	<tr>
		<th> 번호 </th>
		<th> 제목</th>
		<th> 작성자</th>
		<th> 내용 </th>
	</tr>
	
	<%
		int size = articleList.size();
		if (size == 0) {
	%>
	<tr>
		<td colspan=4>글이 없습니다.</td>
	</tr>
	<%
		} else {
			ArticleModel article= null;
			for (int i = 0; i < size; i++) {
				article = articleList.get(i);
	%>
			<tr align="center">
				<td><a href="./detail?id=<%= article.getArticleId() %>"><%= article.getArticleId() %></a></td>
				<td><%=article.getArticleSubject() %></td>
				<td><%=article.getArticleWriter() %></td>
				<td><%=article.getArticleContent() %></td>
			</tr>
			<%
			}
		}
	%>
</table>
<!-- 글쓰기 ./articleWrite Servlet 단으로 페이지 이동 -->
<img src="./resources/write.png" id="btnWrite" 
								 width="70px" 
								 height="40px"/>
</body>
</html>