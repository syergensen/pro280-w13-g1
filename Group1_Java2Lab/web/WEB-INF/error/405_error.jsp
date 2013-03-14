<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error!</title>
    <link href="./resources/styles/stylesheet.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="./resources/scripts/script.js"></script>
    <style type="text/css">
        #content_wrapper2 {
            background: url(./resources/images/bg-side.jpg) no-repeat transparent center top;
            min-height: 809px;
            max-width: 100%;
        }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/header/header.jsp"/>
    <div id="content_wrapper1">
        <div id="content_wrapper2">
            <div id="content">
                <h2>You must fill out the previous page before you can move on!</h2>
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/footer/footer.jsp"/>
</body>
</html>