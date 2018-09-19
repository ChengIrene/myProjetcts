package example;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LunchBoxListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {

        ServletContext sc = event.getServletContext();
        String lunchBoxName = sc.getInitParameter("name");
        String lunchBoxMainDish = sc.getInitParameter("mainDish");
        String lunchBoxSideDish = sc.getInitParameter("sideDish");
        String lunchBoxDrink = sc.getInitParameter("blackTea");

        LunchBox box = new LunchBox(lunchBoxName, lunchBoxMainDish, lunchBoxSideDish, lunchBoxDrink);
        sc.setAttribute("lunchBox", box);
    }

    public void contextDestroyed(ServletContextEvent event) {

    }
}
