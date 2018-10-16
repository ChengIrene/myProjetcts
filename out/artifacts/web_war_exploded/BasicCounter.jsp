<%@ page import="foo.Counter" %>

<%--
  Created by IntelliJ IDEA.
  User: YO
  Date: 2018/10/14
  Time: 下午 09:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
The page count is now :

<%=
    Counter.getCount()
%>
<%-- out.println(Counter.getCount()); --%>
<%--
    上面的"out"物件是一個JSP的隱含變數
    在 <% 和 %> 中間的就是scriptlet,其實就是一些簡單傳統的Java程式
--%>
</body>
</html>