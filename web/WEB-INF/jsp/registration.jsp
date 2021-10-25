<%--
  Created by IntelliJ IDEA.
  User: maksimplaksa
  Date: 19.10.21
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/images/users/cat.jpg" alt="User image">

<form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
    <label for="name">Name:
        <input type="text" name="name" id="name">
    </label><br>
    <label for="birthday">Birthday:
        <input type="date" name="birthday" id="birthday" required>
    </label><br>
    <label for="email">Email:
        <input type="text" name="email" id="email">
    </label><br>
    <label for="imageId">Image:
        <input type="file" name="image" id="imageId" required>
    </label><br>
    <label for="passwordId">Password:
        <input type="password" name="password" id="passwordId">
    </label><br>
    <%--        ?role=USER--%>
    <label for="role">Role:
        <select name="role" id="role">
            <c:forEach var="role" items="${requestScope.roles}">
                <option value="${role}">${role}</option>
            </c:forEach>
        </select><br>
        <c:forEach var="gender" items="${requestScope.genders}">
        <input type="radio" name="gender" value="${gender}"> ${gender}
        <br>
        </c:forEach>
        <button type="submit">Send</button>
        <c:if test="${not empty requestScope.errors}">
        <div style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span>
            </c:forEach>
        </div>
        </c:if>
</form>
</body>
</html>
