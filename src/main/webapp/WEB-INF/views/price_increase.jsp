<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="app.label.title" /></title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>

	<h1>
		<fmt:message key="app.label.increasePrice" />
	</h1>

	<form:form method="post" commandName="priceIncreaseBean">
		<form:input path="percentage" />
		<form:errors path="percentage" cssClass="error" />
		<br>
		<input type="submit" value="Execute">
	</form:form>

	<a href="<c:url value="inventory.htm"/>">Inventory</a>
</body>
</html>
