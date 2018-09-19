package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LunchBoxListenerTest")
public class LunchBoxListenerTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = big5");
        PrintWriter out = response.getWriter();

        out.println("測試由聆聽器設定的context屬性物件<br>");
        out.println("<br>");

        LunchBox lunchBox = (LunchBox) getServletContext().getAttribute("lunchBox");

        out.println("Name: " + lunchBox.getName());
        out.println("Main dish: " + lunchBox.getMainDish());
        out.println("Side dish: " + lunchBox.getSideDish());
        out.println("Drink: " + lunchBox.getDrink());
    }
}
