<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
      <link href="./resources/styles/stylesheet.css" rel="stylesheet" type="text/css" />
      <script type="text/javascript" src="./resources/scripts/script.js"></script>
  </head>
  <body>

  <div id="header">
      <jsp:include page="header/header.jsp"/>
  </div>
  <div id="content">
      <h1>In order to provide more accurate results we would like to know more about your aspirations, things that you desire to have after graduation:</h1>
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
                              <c:forEach var="myVar" items="New, Used">
                                  <input type="radio" name="car_status" value="${myVar}" checked>${myVar} car</option> <br>
                              </c:forEach>
                          </td>
                          <td>
                              <c:forEach var="myVar" items="High end, Average, Below average">
                                  <input type="radio" name="fuel_economy" value="${myVar}" checked>${myVar} fuel economy</option>     <br>
                              </c:forEach>
                          </td>
                          <td>
                              <c:forEach var="myVar" items="Above average, Average, Below average">
                                  <input type="radio" name="car_quality" value="${myVar}" checked>${myVar} car</option>    <br>
                              </c:forEach>
                          </td>
                          <td>
                              Interest rate:<input type="number" name="carinterest" required = "required">
                          </td>
                      </tr>
                  </table>
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
  </body>
</html>