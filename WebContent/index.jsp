<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "kr.ktds.kth.model.ArticleModel" %>
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
</script>
<style>

#btnWrite{
	cursor: pointer;
}
</style>
</head>
<body>
<h1> View List</h1>
<table border="1">
	<tr>
		<th> 번호 </th>
		<th> 제목</th>
		<th> 작성자</th>
	</tr>

<c:if test="${empty articleList }">
	<tr align="center">
		<td colspan="3">게시글이 비어있습니다.</td>
	</tr>
</c:if>

<c:forEach var="article" items="${articleList }">
	<tr align="center">
		<td>
			<a href="<c:url value="/detail?id=${article.articleId }"/>">${article.articleId }</a>
		</td>
		<td>
			<c:out value="${article.articleSubject }"/>
		</td>
		<td>
			<c:out value="${article.articleWriter }"/>
		</td>
	</tr>
</c:forEach>

</table>

<!-- 글쓰기 ./articleWrite Servlet 단으로 페이지 이동 -->
<img src="./resources/write.png" id="btnWrite" 
								 width="70px" 
								 height="40px"/><br/>
</body>
</html>