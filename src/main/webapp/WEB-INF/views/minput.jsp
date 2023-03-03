<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/input.js"></script>

<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/header.css?after">

</head>
<body>

	<%@ include file="include/header.jsp" %>

	<center>	
	
	<form action="minputOk" method="get" name="mreg_frm">
	<table width="100%" color="#999" cellpadding="0" cellspacing="0" border="1" style="border-color:#eee"  >
	<tr bgcolor="#555"  align="center" height="30" style="color:#ccc">
		<td>매니저명</td>
	</tr>

	<tr height="30">
		<td align="center"> <input type="text" name="managernm"></td>
	</tr>
	</table>	
	
	<table>
		<tr>
			<td> <input class="button01" type="button" value="목록" onclick="location.href='index'"> </td>
			<td><input class="button03" type="button" value="매니저조회" onclick="location.href='mlist'"> </td>
			<td> <input class="button01" type="button" value="완료" onclick="minputCheck()"> </td>
			<td> <input class="button01" type="reset" value="취소"> </td>
		</tr>	
		
	</table>
	</form>
</center>


</body>
</html>