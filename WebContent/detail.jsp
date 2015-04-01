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
<title><c:out value="${initParam.TITLE }"/></title>

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

<c:forEach var="i" begin="1" end="5">
	<c:out value="${i}"/><br/>
</c:forEach>

<c:forEach var="i" begin="1" end="50" step="3">
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
	제목   : <c:out value="${viewDetail.articleSubject}"/><br/>
	작성자 : <c:out value="${viewDetail.articleWriter}"/><br/>
	내용   : <c:out value="${viewDetail.articleContent}"/><br/>
	
<a href="./delete?id=<%=articleModel.getArticleId() %>">삭제</a>
<%-- <c:if test="${id not eq article.articeId && id eq 'admin'}">
</c:if> --%>

<a href="<c:url value="/delete?id=${article.articleId }"/>"></a>
<!-- 실무에서는 ./ 이런거 안씀 절대 경로를 씀. -->
<a href="<c:url value="/list"/>">목록보기</a>
<%-- <div>
	<c:import url="http://www.google.com"> 
		<c:param name="" value=""></c:param>
	</c:import>
</div> --%>
<br/>
<c:out value="${region }"/>

<select>
	<option value="1"></option>
	<c:forEach var="city" items="${ cities }">
		<c:choose>
		
			<c:when test="${city eq region }">
				<option value="<c:out value="${city }"/>" selected="selected">
					<c:out value="${city}"/>
				</option>
			</c:when>
			
			<c:otherwise>
				<option value="<c:out value="${city }"/>">
					<c:out value="${city}"/>
				</option>
			</c:otherwise>
			
		</c:choose>
	</c:forEach>
</select>

checkBoxes <br/>
<c:set var="index" value="0"/>

<c:set var="checkedFlag" value=""/>

checkedList<br/>
<c:forEach var="checkbox" items="${checkBoxes }">
	<!-- checkedList에서 가져온 각 아이템이 checkBox와 같은지 확인 -->
	<c:forEach var="checkedItem" items="${checkedList }">
		<c:if test="${checkbox eq checkedItem }">
			<c:set var="checkedFlag" value="checked='checked'"/>
		</c:if>		   
	</c:forEach>
	<!--체크 설정  -->	   
		<input type="checkbox"
			   name="item"
			   value="<c:out value="${checkbox }"/>"
			   <c:out value="${checkedFlag }"/> />
	<!--체크 박스 이름  -->
    <c:out value="${checkbox }"/>
    <c:set var="index" value="${index+1}"/>
    <c:if test="${index % 5 == 0 }">
    	<br/>
    </c:if>
    <!--체크 박스 확인을 위해 value 초기화  -->
    <c:set var="checkedFlag" value=""/>
</c:forEach>

한글 제목 : <c:out value="${sessionScope._MEMBER_.articleSubject }"/>

</body>
</html>