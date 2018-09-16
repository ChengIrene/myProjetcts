<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=big5" language="java" %>
<%@ page pageEncoding="big5" %>

<%-- 上面幾行是 網頁指示(Page directive) --%>

<%--
  Created by IntelliJ IDEA.
  User: YO
  Date: 2018/9/8
  Time: 上午 02:13
  To change this template use File | Settings | File Templates.
--%>

<html>
    <body>
    <h1 align="center">啤酒建議JSP</h1>
    <%--這裡有一些是標準的HTML (在JSP中又被稱為 樣板文字 (Template Text) ) --%>
    <p>

    <%-- 在<%%>標籤中有些Java程式 (這就是所謂的scriplet程式碼) --%>
    <%
        List styles = (List)request.getAttribute("styles");
        //這裡由請求物件中取得一個屬性物件
        Iterator it = styles.iterator();
        while(it.hasNext()) {
            out.print("<br>try it : " + it.next());
        }
    %>

    </body>
</html>
