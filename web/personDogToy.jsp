<%--
  Created by IntelliJ IDEA.
  User: YO
  Date: 2018/12/3
  Time: 上午 01:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>

        ${person.name}'s dog ${person.dog.name}'s toys are: ${person.dog.toys[0].name},
        ${person.dog.toys[1].name}, and a ${person.dog.toys[2].name}

    </body>
</html>
