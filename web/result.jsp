<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=big5" language="java" %>
<%@ page pageEncoding="big5" %>

<%-- �W���X��O ��������(Page directive) --%>

<%--
  Created by IntelliJ IDEA.
  User: YO
  Date: 2018/9/8
  Time: �W�� 02:13
  To change this template use File | Settings | File Templates.
--%>

<html>
    <body>
    <h1 align="center">��s��ĳJSP</h1>
    <%--�o�̦��@�ǬO�зǪ�HTML (�bJSP���S�Q�٬� �˪O��r (Template Text) ) --%>
    <p>

    <%-- �b<%%>���Ҥ�����Java�{�� (�o�N�O�ҿת�scriplet�{���X) --%>
    <%
        List styles = (List)request.getAttribute("styles");
        //�o�̥ѽШD���󤤨��o�@���ݩʪ���
        Iterator it = styles.iterator();
        while(it.hasNext()) {
            out.print("<br>try it : " + it.next());
        }
    %>

    </body>
</html>
