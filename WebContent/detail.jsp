<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="kr.ktds.kth.model.ArticleModel
				,java.util.List
				,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>세부 내용</title>

</head>
<body>

<c:set var="name" value="JMC" />
<c:set var="index" value="0"/>
<c:out value="${index }"/>
${name} <br/>

<c:set var="index" value="${index+1}"/>
<c:out value="${index }"/>


<c:out value="${name  }"/> <br/>

<c:if test="${index == 0 && name eq 'JMC' }">
0이고 JMC 입니다 <br/>
</c:if>
<c:if test="${index eq 0 }">
인덱스는 0 입니다.<br/>
</c:if>
<c:if test="${index eq 1 }">
인덱스는 1 입니다.<br/><br/>
</c:if>

<c:if test="${name eq 'JMC' }">
JMC입니다.<br/>
	<c:if test="${index eq 1 }">
	인덱스는 1 입니다.<br/>
	</c:if>
</c:if>

<c:choose>
	<c:when test="${index eq 0 }">
		인덱스가 0입니다.!!
	</c:when>
	
	<c:when test="${index eq 1 }">
		인덱스가 1입니다.!!
	</c:when>
	
	<c:otherwise>
		인덱스가 0혹은 1이 아닙니다.
	</c:otherwise>
</c:choose>

<br/><br/><br/><br/>
<%
	List<String> list = new ArrayList<String>();
	list.add("ABC1");	
	list.add("ABC2");	
	list.add("ABC3");	

%>
<c:forEach var="i" begin="1" end="5">
	<c:out value="${i}"/><br/>
</c:forEach>

<c:forEach var="i" begin="1" end="50" step="3">
	<c:out value="${i}"/><br/>
</c:forEach>

<c:forEach items="">
	<c:out value="${i}"/><br/>
</c:forEach>

<h2>세부정보</h2>
<%
	ArticleModel articleModel = (ArticleModel)request.getAttribute("viewDetail");
	if(articleModel==null)
		out.println("아무것도 없어여.");
	else
		;
%>
	제목   : <c:out value="${viewDetail.articleId}"/>
	작성자 : <c:out value="${viewDetail.articleWriter}"/>
	내용   : <c:out value="${viewDetail.articleContent}"/>
	
<a href="./delete?id=<%=articleModel.getArticleId() %>">삭제</a>
<br/>
<!-- 실무에서는 ./ 이런거 안씀 절대 경로를 씀. -->
<a href="<c:url value="/list"/>">목록보기</a>
<%-- <div>
	<c:import url="http://www.google.com"> 
		<c:param name="" value=""></c:param>
	</c:import>
</div> --%>
</body>
</html>