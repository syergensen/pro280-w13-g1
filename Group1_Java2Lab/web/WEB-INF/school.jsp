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
  </head>
  <body>
      <h1>Please answer the following questions about your school and funding:</h1>
      <form action="lifeStyle" method="get">
          <ol>
              <li>
                  When did you start attending Neumont:<br>
                  <select name="quarter">
                      <c:forEach var="myVar" items="<%=QuarterManager.getStaticQuarters()%>">
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
                      <c:forEach var="myVar" items="<%=DegreeManager.getStaticDegrees()%>">
                          <option value="${myVar}">${myVar}</option>
                      </c:forEach>
                  </select>
              </li>
              <li>
                  How many additional quarters do you expect to attend Neumont:<br>
                  Full-time: <input type="number" name="extra-quarter-full"/>
                  Part-time: <input type="number" name="extra-quarter-part"/>
              </li>
              <li>
                  Please select the amount that is paid by loans:<br>
                  0%<input type="range" name="loan-percent" min="0" max="100" step="5"/>100%
              </li>
              <%
                  String[][] debtTypes = new String[][]{{"credit card"}, {"medical"}, {"loan", "(school, car)"}};
                  for(int i = 0; i < debtTypes.length; i++){
              %>
              <li>
                  How much (if any) outstanding <%=debtTypes[i][0]%> debt <%=debtTypes[i].length>1?debtTypes[i][1] + " ":""%>do you have?
                  <input type="number" name="debt<%=i%>">
              </li>
              <%}%>
          </ol>
          <input type="submit" value="Next Step">
      </form>
  </body>
</html>