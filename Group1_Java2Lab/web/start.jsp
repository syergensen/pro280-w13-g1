<%--
  Created by IntelliJ IDEA.
  User: sgomez
  Date: 2/27/13
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Financial Tool - Start</title>
</head>
<body>
    <h1>Terms of Service</h1>
    <div>
        <textarea rows="20" cols="60" readonly>${termsOfService.terms}</textarea>  <br>
         <form method="post" action="start">
             <input type="checkbox" name="checkbox"> I have read the Terms of Service<br>
             <input type="submit" value="Begin">
         </form>
    </div>
</body>
</html>