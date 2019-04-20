package web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "testEl")
public class TestEL extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List favoriteItem = new ArrayList();
        favoriteItem.add("Item 1");
        favoriteItem.add("Item 2");
        favoriteItem.add("Item 3");

        request.setAttribute("favoriteItem", favoriteItem);

        RequestDispatcher view = request.getRequestDispatcher("testel.jsp");
        view.forward(request, response);
    }

}
