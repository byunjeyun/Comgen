<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review Board</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/input.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/header.css">
</head>
<body>
<%@ include file="include/header.jsp" %>

<center>
<h2>유지보수 내역 </h2>
	<hr>
	
	<table width="100%" color="#aaa" cellpadding="0" cellspacing="0" border="1" style="border-color:#eee"  >
		<tr bgcolor="#333"  align="center" height="30" style="color:#ccc">
			<td width="10%">담당자코드</td>
			<td width="80%">담당자</td>
			<td width="10%">삭제</td>
		</tr>
		<c:forEach var="mdto" items="${manager_list}" >
			<tr height="30">
				<td align="center">${mdto.managercd}</td>
				<td align="center">${mdto.managernm}</td>
				<td><input type="button" value="삭제" onclick="location.href='mdeleteOk?managercd=${mdto.managercd}'"></td>
			</tr>		
		</c:forEach>
		</table>		
<c:if test="${not empty message}">
    <div>${message}</div>
</c:if>
</center>

<center>	
<table width="75%" border="0" cellspacing="0" cellpadding="10" >
														   
	<tr>
		<input class="button03" type="button" value="목록" onclick="location.href='index'"> &nbsp;&nbsp;<input class="button03" type="button" value="매니저 등록" onclick="location.href='minput'">
	</tr>				
		
</table>
</center>
</body>
</html>