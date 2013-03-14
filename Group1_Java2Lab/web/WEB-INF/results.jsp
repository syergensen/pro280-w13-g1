<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NUBA - Results</title>
    <link href="./resources/styles/stylesheet.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="./resources/scripts/script.js"></script>
</head>
<body>
<div id="header">
    <jsp:include page="header/header.jsp"/>
</div>
<div id="content">
    <form action="addquarter" method="post">
        <input type="submit" name="quarter" value="+1 Quarter">
    </form>
    <form action="print" method="get">
        <input type="submit" name="printform" value="Print Results">
    </form>
    <div id="results">
            Salary.....................${salary}<br>
            Student Loan...............${studentloan}<br>
            Income Tax.................${incometax}<br>
            Misc. Expenses.............${miscexpenses}<br>
            Car Expenses...............${carexpenses}<br>
            Mortgage/Rent..............${mortgage}<br>
            Misc. Loans................${miscloans}<br>
            <br>
            <br>
            Discretionary Income: ${discretionary}
        </div>
    </div>
</body>
</html>