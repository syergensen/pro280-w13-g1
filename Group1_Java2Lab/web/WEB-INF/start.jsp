<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NUBA - Start</title>
    <link href="./resources/styles/stylesheet.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="./resources/scripts/script.js"></script>
</head>
<body>
    <div id="header">
        <jsp:include page="header/header.jsp"/>
    </div>

    <div id="content">
        <h1>Terms of Service</h1>

        <form method="post" action="start">
            <div class="terms_box">
                <textarea rows="20" cols="60" readonly>${termsOfService.terms}</textarea>  <br>
                <input type="checkbox" name="checkbox"> I have read the Terms of Service<br>
            </div>
            <input id="beginButton" type="submit" value="Begin">
        </form>
    </div>
</body>
</html>