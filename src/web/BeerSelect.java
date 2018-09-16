package web;

import model.BeerExpert;  //要import這個套件,因為BeerExpert在這裡

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "BeerSelect")
public class BeerSelect extends HttpServlet {  //HttpServlet繼承自實作Servlet介面的GenericServlet
    protected void doPost //用doPost來處理HTTP請求,因為這個HTML畫面是用: method = POST
            (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.setContentType("text/html;charset = big5"); v3註解掉 //這個方法是來自ServletResponse介面
        //PrintWriter out = response.getWriter();  //remove the old test output
        //out.println("osusume biiru no risuto <br>");

        String c = request.getParameter("color");
        //這個方法是來自ServletRequest介面. 這裡的參數字串必須符合我們在HTML中<select>標籤中的name屬性

        //out.println("<br> nyuryokusuruirowa：" + c); v2註解掉  //這裡還沒有傳回建議清單,只有顯示測試訊息

        //第二版修改 上面那行註解掉
        BeerExpert be = new BeerExpert();
        List result = be.getBrands(c);

        // Iterator it = result.iterator();  v3註解掉
        // while(it.hasNext()) {
        //     out.print("<br>try it : " + it.next());
        // }
        //將建議(來自Model所回傳的ArrayList中的啤酒品牌清單)輸出到畫面
        //在最後一個版本中(第三版),這些建議將會輸出至一個JSP而不是Servlet

        request.setAttribute("styles", result);
        //在請求物件中加一個屬性給JSP用,注意屬行名稱是"styles"

        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        //找到這個JSP的請求派遣物件(request dispatcher)

        view.forward(request, response);
        //利用這個請求派遣物件,讓容器系統轉交這個JSP,並將請求及回應物件一併傳過去

        //在第三版的步驟中,修改Servlet去"呼叫"一個JSP,這個JSP將產生輸出(畫面)
        //我們的容器系統提供了一個機制,稱為"請求委派"(Request Dispatching) 它允許容器中被管理的物件去呼叫另一個物件

    }
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
