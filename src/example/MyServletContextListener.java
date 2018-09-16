package example;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {  //實作javax.servlet.ServletContextListener

    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
        //由事件的參數取得ServletContext

        String dogBreed = sc.getInitParameter("breed");
        //使用context物件來取得初始化參數

        Dog d = new Dog(dogBreed);
        //建立一個Dog物件

        sc.setAttribute("dog", d);
        //透過context物件來將Dog物件設定成屬性(一對名稱/物件)
        //這樣應用系統的其他部分就能取得屬性的值(剛才建立起來的Dog物件)
    }

    public void contextDestroyed(ServletContextEvent event) {
        //這裡面什麼都不用寫
        //不必去清除這個Dog物件,當context要結束時,即表示這個應用系統也即將結束,包括Dog物件也是這樣
    }
}
