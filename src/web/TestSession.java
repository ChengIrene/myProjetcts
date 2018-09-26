package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestSession")
public class TestSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = big5");
        PrintWriter out = response.getWriter();
        out.println("測試session屬性<br>");

        //該如何知道這個Session是早就已經存在的,或是剛才建立好的呢?
        //getSession()是一個沒有參數,由請求物件提供的方法

        HttpSession session = request.getSession();
        //getSession() 無論如何都會回傳一個session...但是可以直接問這個session它是不是新的

        if (session.isNew()) {
            out.println("這是一個新的Session");
            //如果這個session代碼還沒從回應傳回給客戶端過,isNew()就會回傳true
            //第一次連進去會看到這個訊息

        } else {
            out.println("歡迎再度光臨!");
            //一旦建立過一次回應後,就會變成false的狀態了
            //第二次連進去後都是這個
        }
    }
}
