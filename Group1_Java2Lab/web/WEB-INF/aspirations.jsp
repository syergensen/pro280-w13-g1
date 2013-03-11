<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <h1>In order to provide more accurate results we would like to know more about your aspirations, things that you desire to have after graduation:</h1>
  <form action="result/calculate" method="get">
      <ol>
          <li>
              <table>
                  <tr>
                      <td>After graduating Neumont what is your preferred region to live in the United States:</td>
                      <td>
                          <select name="region">
                              <c:forEach var="myVar" items="${all_regions}">
                                  <option value="${myVar}">${myVar}</option>
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
                              <input type="radio" name="car_status" value="${myVar}">${myVar} car</option>
                          </c:forEach>
                      </td>
                      <td>
                          <c:forEach var="myVar" items="High end, Average, Below average">
                              <input type="radio" name="fuel_economy" value="${myVar}">${myVar} fuel economy</option>
                          </c:forEach>
                      </td>
                      <td>
                          <c:forEach var="myVar" items="Above average, Average, Below average">
                              <input type="radio" name="car_quality" value="${myVar}">${myVar} car</option>
                          </c:forEach>
                      </td>
                  </tr>
              </table>
          </li>
          <li>
              Please describe your preferred house:
              <c:forEach var="myVar" items="Own, Rent, Live with parents">
                  <input type="radio" name="housing" value="${myVar}">${myVar}</option>
              </c:forEach>
          </li>
      </ol>
  </form>
  </body>
</html>