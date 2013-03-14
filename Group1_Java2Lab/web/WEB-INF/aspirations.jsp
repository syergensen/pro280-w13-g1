<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>NUBA - Post-Graduation</title>
        <link href="./resources/styles/stylesheet.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="./resources/scripts/script.js"></script>
        <link rel="shortcut icon" href="/resources/images/favicon.ico"  />

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
                    <h2>In order to provide more accurate results we would like to know more about your aspirations, things that you
                    desire to have after graduation:</h2>

                    <form action="results" method="post">
                        <ol>
                            <li>
                                After graduating Neumont what is your preferred region to live in the United States:
                                <table>
                                    <tr>
                                        <td>
                                            <select name="region">
                                                <c:forEach var="myVar" items="${all_regions}">
                                                    <option value="${myVar.name}">${myVar.name}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                </table>
                            </li>
                            <li>
                                Please describe your preferred car:
                                <table>
                                    <tr>
                                        <td>
                                            <select name="car_status">
                                                <c:forEach var="myVar" items="New,Used">
                                                    <option value="${myVar}">${myVar} car</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <select name="fuel_economy">
                                                <c:forEach var="myVar" items="High end,Average,Below average">
                                                    <option value="${myVar}">${myVar} fuel economy</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <select name="car_quality">
                                                <c:forEach var="myVar" items="Above average,Average,Below average">
                                                    <option value="${myVar} car">${myVar} car</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                </table>
                                <br>
                                Interest rate:<input type="text" name="carinterest" required="required"> %
                            </li>
                            <li>
                                Please describe your preferred house:
                                <c:forEach var="myVar" items="Own, Rent, Live with parents">
                                    <input type="radio" name="housing" value="${myVar}" checked>${myVar}</option>
                                </c:forEach>
                            </li>
                        </ol>

                        <input type="submit" value="Next Step"/>
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="footer/footer.jsp"/>
    </body>
</html>