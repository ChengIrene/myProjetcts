package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "TestInitParams")
public class TestInitParams extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html5; charset = big5");
        PrintWriter out = response.getWriter();
        out.println("Test initialization parameter <br>");

        Enumeration e = getServletConfig().getInitParameterNames();
        while(e.hasMoreElements()) {
            out.println("<br> Parameter name = " + e.nextElement() + " <br> ");
        }

        //每一個Servlet都有繼承到一個getServletContext()方法(而且JSP也可以存取到Context物件)
        //這個getServletContext()方法就會回傳一個ServletContext物件
        //而這個物件就會有一個方法是getInitParameter()
        out.println("主要的email是" + getServletContext().getInitParameter("mainEmail"));

        /*
        也可以寫成:
        ServletContext context = getServletContext();
        out.println(context.getInitParameter("adminEmail"));

        將程式分為兩個步驟,先得到ServletContext的參照,然後呼叫它的getInitParameter()方法
         */

        out.println(" <br> ");
        out.println("管理員email是" + getServletContext().getInitParameter("adminEmail"));

    }
}
