<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="model.Quarter" %>
<%@ page import="manager.QuarterManager" %>
<%@ page import="manager.DegreeManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>NUBA - School</title>
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


        <script type="text/javascript">
            function getRangeValues(val){
                document.getElementById('rangeInput').value = val;
            }
        </script>
    </head>
    <body>
        <jsp:include page="header/header.jsp"/>

        <div id="content_wrapper1">
            <div id="content_wrapper2">
                <div id="content">
                    <h1>Please answer the following questions about your school and funding:</h1>

                    <form action="lifeStyle" method="post">
                        <ol>
                            <li>
                                When did you start attending Neumont:<br>
                                <select name="quarter">
                                    <c:forEach var="myVar" items="${all_quarters}">
                                        <option value="${myVar}">${myVar}Quarter</option>
                                    </c:forEach>
                                </select>
                                <select name="year">
                                    <c:forEach var="myVar" begin="2009"
                                               end="<%=(new GregorianCalendar()).get(GregorianCalendar.YEAR)%>">
                                        <option value="${myVar}">${myVar}</option>
                                    </c:forEach>
                                </select>
                            </li>
                            <li>
                                Which program are you enrolled in:<br>
                                <select name="degree">
                                    <option value="BSCS">BSCS</option>
                                    <option value="BSGD">BSGD</option>
                                    <option value="BSTM">BSTM</option>
                                    <option value="BSWD">BSWD</option>
                                </select>
                            </li>
                            <li>
                                How many additional quarters do you expect to attend Neumont:<br>
                                Full-time: <input type="text" name="extra-quarter-full" required="required"/>
                                Part-time: <input type="text" name="extra-quarter-part" required="required"/>
                            </li>
                            <h3><b>Loan Information:</b></h3>
                            <li>
                                Please select the amount that is paid by loans:<br>
                                0%<input type="range" name="loan-percent" min="0" max="100" step="5"
                                         onchange="getRangeValues(this.value)"/>100%
                                <input type="text" id="rangeInput" readonly size="5">
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                Interest rate percent: <input type="number" name="interestrate" required="required"> % <br>
                                Total amount of grants/scholarships: $<input type="text" name="scholarships" required="required">
                            </li>
                            <c:forEach var="myVar" items="${all_debtTypes}">
                                <li>
                                    How much (if any) outstanding ${myVar.type} debt do you have?
                                    $<input type="text" name="debt${myVar.id}" required="required">
                                </li>
                            </c:forEach>
                        </ol>
                        <input type="submit" value="Next Step">
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="footer/footer.jsp"/>
    </body>
</html>