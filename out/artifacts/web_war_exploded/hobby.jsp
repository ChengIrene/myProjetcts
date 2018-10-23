<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<%--
  Created by IntelliJ IDEA.
  User: YO
  Date: 2018/10/22
  Time: 上午 03:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>

        The friend who share your hobby of
    <%= request.getParameter("hobby")%>
    are: <br>
    <% ArrayList al = (ArrayList) request.getAttribute("names"); %>

    <% Iterator it = al.iterator();
    while (it.hasNext()) { %>
        <%= it.next() %>
    <br>
    <% } %>

    </body>
</html>
