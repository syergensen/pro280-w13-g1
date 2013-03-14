<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>NUBA - Results</title>
        <link href="./resources/styles/stylesheet.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="./resources/scripts/script.js"></script>
        <link rel="shortcut icon" href="./resources/images/favicon.ico"  />

        <style type="text/css">
            #content_wrapper2 {
                background: url(./resources/images/bg-side.jpg) no-repeat transparent center top;
                min-height: 809px;
                max-width: 100%;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header/header.jsp"/>

        <div id="content_wrapper1">
            <div id="content_wrapper2">
                <div id="content">
                    <h2>Your results:</h2>
                    <form action="addquarter" method="post">
                        <input id="quarterButton" type="submit" name="quarter" value="+1 Quarter">
                    </form>
                    <div id="results">
                        <h3>Salary.....................${salary}/month</h3>
                        <h3>Student Loan...............${studentloan}/month</h3>
                        <h3>Income Tax.................${incometax}/month</h3>
                        <h3>Misc. Expenses.............${miscexpenses}/month</h3>
                        <h3>Car Expenses...............${carexpenses}/month</h3>
                        <h3>Mortgage/Rent..............${mortgage}/month</h3>
                        <h3>Misc. Loans................${miscloans}/month</h3>
                        <br>
                        <h3>Discretionary Income: ${discretionary}/month</h3>
                        <%--<form action="print" method="get">--%>
                            <%--<input id="printButton" type="submit" name="printform" value="Print Results">--%>
                        <%--</form>--%>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="footer/footer.jsp"/>
    </body>
</html>