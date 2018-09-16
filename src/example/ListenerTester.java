package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ListenerTester")
public class ListenerTester extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = big5");
        PrintWriter out = response.getWriter();

        out.println("測試由聆聽器設定的context屬性物件<br>");
        out.println("<br>");

        //從ServletContext中取得Dog
        //如果聆聽器有正常運作,這個Dog物件應該會在第一次呼叫service方法之前就存在了
        // get attribute from context
        Dog dog = (Dog) getServletContext().getAttribute("dog");
        //這裡要記得轉型(Cast)
        //getAttribute()回傳的資料型態是Object,所以必須先將回傳結果轉型
        //但getInitParameter()回傳的是String
        //所以可以將getInitParameter()方法回傳的結果指派給字串型態的變數

        String initBreed = getServletContext().getInitParameter("breed");
        out.println("*** Dog breed: " + initBreed);

        //如果有任何不照常運作的情形,在這裡我們就會發現
        //在沒找到該有的Dog物件時,若我們還是呼叫了getBreed()方法的話
        //就會得到一個大的NullPointerException
        out.println("狗的品種是: " + dog.getBreed());
    }
}
