<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
      <h1>Please answer the following questions about your school and funding:</h1>
      <form name="?" action="?" method="?">
          <ol>
              <li>
                  When did you start attending Neumont:<br>
                  <select name="quarter">
                      <%for(String s : new String[]{"Fall", "Winter", "Spring", "Summer"})
                      {%><option value="<%=s%>"><%=s%> Quarter</option><%}%>
                  </select>
                  <select name="year">
                      <%for(int i = 2003; i < (new GregorianCalendar()).get(GregorianCalendar.YEAR); i++)
                      {%><option value="<%=i%>"><%=i%></option><%}%>
                  </select>
              </li>
              <li>
                  Which program are you enrolled in:<br>
                  <select name="degree">
                      <option value="BSCS">BSCS</option>
                      <option value="BSGD">BSGD</option>
                      <option value="BSTM">BSTM (previously BTOM)</option>
                      <option value="BSWD">BSWD</option>
                  </select>
              </li>
              <li>
                  How many additional quarters do you expect to attend Neumont:<br>
                  Full-time: <input type="text" name="extra-quarter-full">
                  Part-time: <input type="text" name="extra-quarter-part">
              </li>
              <li>
                  Please select the amount that is paid by loans:<br>
                  <input type="range" name="loan-percent" min="0" max="100">
              </li>
              <%
                  String[][] debtTypes = new String[][]{{"credit card"}, {"medical"}, {"loan", "(school, car)"}};
                  for(int i = 0; i < debtTypes.length; i++){
              %>
              <li>
                  How much (if any) outstanding <%=debtTypes[i][0]%> debt <%=debtTypes[i].length>1?debtTypes[i][1] + " ":""%>do you have?
                  <input type="text" name="debt<%=i%>">
              </li>
              <%}%>
          </ol>
          <input type="submit" value="Next Step">
      </form>
  </body>
</html>