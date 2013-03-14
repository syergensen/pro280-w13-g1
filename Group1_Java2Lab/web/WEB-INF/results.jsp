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
        <div id="results">
            <h3>Salary.....................${salary}</h3><br>
            <h3>Student Loan...............${studentloan}</h3><br>
            <h3>Income Tax.................${incometax}</h3><br>
            <h3>Misc. Expenses.............${miscexpenses}</h3><br>
            <h3>Car Expenses...............${carexpenses}</h3><br>
            <h3>Mortgage/Rent..............${mortgage}</h3><br>
            <h3>Misc. Loans................${miscloans}</h3><br>
            <br>
            <br>
            <h3>Discretionary Income: ${discretionary} </h3>
        </div>
    </div>
</body>
</html>