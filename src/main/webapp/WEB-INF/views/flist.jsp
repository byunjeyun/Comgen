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
<h2>사업장 관리 </h2>
	<hr>
	
	<table width="100%" color="#aaa" cellpadding="0" cellspacing="0" border="1" style="border-color:#eee"  >
		<tr bgcolor="#333"  align="center" height="30" style="color:#ccc">
			<td width="10%">사업장코드</td>
			<td width="80%">사업장</td>
			<td width="10%">삭제</td>
		</tr>
		<c:forEach var="ndto" items="${nfact_list}" >
			<tr height="30">
				<td align="center">${ndto.factcd}</td>
				<td align="center">${ndto.factnm}</td>
				<td><input type="button" value="삭제" onclick="location.href='fdeleteOk?factcd=${ndto.factcd}'"></td>
			</tr>		
		</c:forEach>
		</table>		

</center>

<center>	
<table width="75%" border="0" cellspacing="0" cellpadding="10" >
														   
	<tr>
		<input class="button03" type="button" value="목록" onclick="location.href='index'"> &nbsp;&nbsp;<input class="button03" type="button" value="사업장 등록" onclick="location.href='finput'">
	</tr>				
		
</table>
</center>
</body>
</html>