package web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("big5");

        request.setCharacterEncoding("big5");
        String name = request.getParameter("username");  //取出客戶在畫面輸入的姓名

        Cookie cookie = new Cookie("username", name);  //建立一個有使用者姓名的Cookie

        cookie.setMaxAge(30 * 60);  //將它的有效期限設定為30分鐘

        response.addCookie(cookie);  //把這個Cookie加到回應物件的"Set-Cookie"檔頭

        //用JSP來產生回應網頁
        RequestDispatcher view = request.getRequestDispatcher("cookieresult.jsp");
        view.forward(request, response);

        //從Servlet轉交的JSP所顯示的畫面
        // <html><body>
        //  <a href="checkcookie.do">click here</a>
        // </body></html>

        //這程式中不直接用servlet來產生這些HTML
        //而會用"轉交(forward)"這個方式,不想改變到回應中已經設定好的Cookie,而且這個回應物件可以一起都轉交給JSP

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
