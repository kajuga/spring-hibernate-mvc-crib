<%--
  Created by IntelliJ IDEA.
  User: kajuga
  Date: 24.04.20
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Confirmation Page</title>
</head>
<body>

The Student is confirmed: ${student.firstName} ${student.lastName}

<br><br>

Country: ${student.country}

<br><br>

Favorite Language: ${student.favoriteLanguage}

<br><br>

<%--Operating Systems: ${student.operationSystem}--%>
<%--    LOOPING ARRAY--%>
    Operating Systems:
    <ul>
        <c:forEach var="temp" items="${student.operationSystems}">
            <li>${temp}</li>
        </c:forEach>
    </ul>

</body>
</html>
