<%--
  Created by IntelliJ IDEA.
  User: sgomez
  Date: 3/11/13
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="resources/styles/stylesheet.css" rel="stylesheet" type="text/css"/>
    <title>Error</title>
</head>
<body>
    <div id="content">
      <h1>Oops! There seems to be an error!</h1>
        <p>Please try logging in again!</p>
      <a href="<c:url value="/" />">Go back to login</a>
    </div>
</body>
</html>