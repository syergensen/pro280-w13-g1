<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>NUBA - Lifestyle</title>
      <link href="./resources/styles/stylesheet.css" rel="stylesheet" type="text/css" />
      <script type="text/javascript" src="./resources/scripts/script.js"></script>
  </head>
  <body>
  <div id="header">
      <jsp:include page="header/header.jsp"/>
  </div>
  <div id="content">
      <h2>These questions will focus on the housing and lifestyle choices while still in school.</h2>
      <form action="aspirations" method="post">
          <ol>
              <li>
                  What is your housing situation?<br>
                  <c:forEach var="myVar" items="${all_housing}">
                      <input type="radio" name="housing_situation" value="${myVar.name}" checked>${myVar.name}<br>
                  </c:forEach>
                  <input type="radio" name="housing_situation" value="Apartment">Renting an apartment or similar<br>
                  <table>
                      <tr>
                          <td>a. How much do you spend monthly for rent?</td>
                          <td>$<input type="text" name="input_rent" required = "required"></td>
                      </tr>
                      <tr>
                          <td>b. On average, how much per month is spent on utilities/bills?</td>
                          <td>$<input type="text" name="input_bills" required = "required"></td>
                      </tr>
                  </table>
              </li>
              <li>
                  On average, how many days out of the week do you eat out for lunch?<br>
                  0<input type="range" name="go_out_to_lunch" min="0" max="7" step="1"/>7
              </li>
              <li>
                  On average, how many days out of the week do you eat out for dinner?<br>
                  0<input type="range" name="go_out_to_dinner" min="0" max="7" step="1"/>7
              </li>
              <li>
                  On average, how much do you spend on entertainment per month?<br>
                  0<input type="range" name="spend_on_entertainment" min="0" max="200" step="10"/>200
              </li>
          </ol>
          <input type="submit" value="Next Step">
      </form>
      </div>
  </body>
</html>