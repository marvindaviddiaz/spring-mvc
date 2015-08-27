<%@ include file="/WEB-INF/views/include.jsp"%>
<html>

<head>
<title><fmt:message key="app.label.title" /></title>
</head>

<body>
	<h1>
		<fmt:message key="app.label.products" />
	</h1>
	<p>
		<fmt:message key="app.label.time" />
		<c:out value="${model.now}" />
	</p>
	<p>
		<fmt:message key="app.label.session" />
		<c:out value="${model.sessionID}" />
	</p>
	<ul>
		<c:forEach items="${model.products}" var="prod">
			<li><c:out value="${prod.description} $ ${prod.price}" /></li>
		</c:forEach>
	</ul>
	<br>
	<a href="<c:url value="price_increase.htm"/>"><fmt:message key="app.label.increasePrice" /></a>
	<br>
</body>
</html>