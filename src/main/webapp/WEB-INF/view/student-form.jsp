<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kajuga
  Date: 24.04.20
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student registration form</title>
</head>
<body>


<form:form action="processForm" modelAttribute="student">

    First name: <form:input path="firstName"/>
    <br><br>

    Last name: <form:input path="lastName"/>
    <br><br>

<%--    Drop down list:--%>
    Country:
    <form:select path="country">
       <form:options items="${student.countryOptions}" />
    </form:select>

<%--    list hardcoded:--%>
<%--    Country:--%>
<%--    <form:select path="country">--%>
<%--        <form:option value="Brazil" label="Brazil" />--%>
<%--        <form:option value="France" label="France" />--%>
<%--        <form:option value="Germany" label="Germany" />--%>
<%--        <form:option value="India" label="India" />--%>
<%--    </form:select>--%>

<br><br>
    Favorite Language:

    Java <form:radiobutton path="favoriteLanguage" value="Java"/>
    C# <form:radiobutton path="favoriteLanguage" value="C#"/>
    PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
    Ruby <form:radiobutton path="favoriteLanguage" value="RUBY"/>

    <br><br>

    Operaing Systems:

    Linux <form:checkbox path="operationSystems" value="Linux"/>
    Mac OS <form:checkbox path="operationSystems" value="Mac OS"/>
    MS Windows <form:checkbox path="operationSystems" value="Windows"/>


    <br><br>



    <input type="submit" value="Submit"/>


</form:form>

</body>
</html>


































