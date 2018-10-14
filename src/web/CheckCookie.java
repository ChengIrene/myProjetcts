package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckCookie")
public class CheckCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("big5");

        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();  //從請求中取出Cookie陣列

        //在迴圈中把一個一個來搜尋Cookie陣列裡的Cookie,一直找到Cookie名稱為"username"的
        //如果找到了,就取出它的值並輸出到畫面上

        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("username")) {
                String userName = cookie.getValue();
                out.println("Hello! " + userName);
                break;
            }
        }
    }
}
