package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestSession2")
public class TestSession2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = big5");
        PrintWriter out = response.getWriter();
        out.println("session 測試<br>");

        //如果只要一個已經存在的Session
        //可以呼叫重載(Overload)的getSession(boolean)方法就能滿足這個需求
        //如果不希望建立一個新的Session,那就呼叫getSession(false),它會回傳null,或者一個已經存在的HttpSession

        HttpSession session = request.getSession(false);
        //若這裡傳"false"表示希望這個方法回傳一個已存在的Session,若找不到一個與現在客戶相關的Session,則回傳null值
        //而getSession(true)跟getSession()是一模一樣的意思了

        if (session == null) {
            out.println("找不到已經存在的session");
            out.println("做一個新的...");
            session = request.getSession();  //這裡是在建立一個新的session
        } else {
            out.println("找到已經存在的session!");
        }
    }
}
