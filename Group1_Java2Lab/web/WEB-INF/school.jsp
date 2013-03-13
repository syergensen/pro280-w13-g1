<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="model.Quarter" %>
<%@ page import="manager.QuarterManager" %>
<%@ page import="manager.DegreeManager" %>
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
                          <c:forEach var="myVar" begin="2003" end="<%=(new GregorianCalendar()).get(GregorianCalendar.YEAR)%>">
                              <option value="${myVar}">${myVar}</option>
                          </c:forEach>
                      </select>
                  </li>
                  <li>
                      Which program are you enrolled in:<br>
                      <select name="degree">
                          <%--<c:forEach var="myVar" items="${all_degrees}">--%>
                              <%--<option value="${myVar}">${myVar}</option>--%>
                          <%--</c:forEach>--%>
                              <option value="BSCS">BSCS</option>
                              <option value="BSGD">BSGD</option>
                              <option value="BSTM">BSTM</option>
                              <option value="BSWD">BSWD</option>
                      </select>
                  </li>
                  <li>
                      How many additional quarters do you expect to attend Neumont:<br>
                      Full-time: <input type="text" name="extra-quarter-full"/>
                      Part-time: <input type="text" name="extra-quarter-part"/>
                  </li>
                  <li>
                      Please select the amount that is paid by loans:<br>
                      0%<input type="range" name="loan-percent" min="0" max="100" step="5" onchange="getRangeValues(this.value)"/>100%
                      <br>
                      Loan information:<br>
                      Total amount of grants/scholarships: $<input type="text" name="scholarships">
                      Interest rate percent: <input type="number" name="interestrate"> %
                  </li>
                  <c:forEach var="myVar" items="${all_debtTypes}">
                      <li>
                          How much (if any) outstanding ${myVar.type} do you have?
                          $<input type="text" name="debt${myVar.id}">
                      </li>
                  </c:forEach>
              </ol>
              <input type="submit" value="Next Step">
          </form>
        </div>
  </body>
</html>