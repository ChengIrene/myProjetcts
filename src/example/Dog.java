package example;

//HttpSessionBindingListener這個聆聽器介面是在javax.servlet.http套件中
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

//Dog屬性物件也身兼聆聽器程式了,他負責監聽自己這個物件被加到一個Session或者從一個Session移除等事件
//繫結用的聆聽器不必在DD檔中註冊,他會自動執行
//但HttpSessionActivationListener必須在DD檔中設定

//屬性類別(聆聽會影響它自己的事件)
//這個聆聽器讓一個屬性物件去追蹤那些對屬性本身而言很重要的事件
//像是它何時被加到一個Session,或從Session中被移除,還有它何時會從一個VM被搬移到另一個VM
public class Dog implements HttpSessionBindingListener, HttpSessionActivationListener, Serializable {
    private String breed;

    //將用Context的初始化參數傳給Dog類別建構式的參數
    public Dog(String breed) {
        this.breed = breed;
    }

    //寫的Servlet會從Context取得Dog物件(這個Dog物件是由聆聽器存到Context的屬性中的)
    //然後呼叫Dog的getBreed()方法,而且會將品種資料輸出到回應物件上,就可以在瀏覽器上看到這個資料
    public String getBreed() {
        return breed;
    }

    //事件用詞的"繫結"和"不繫結"其實就是"新增"和"移除"的意思
    public void valueBound(HttpSessionBindingEvent event) {
        //執行程式時,表示物件本身已經知道自己被加到一個session的屬性
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        //執行程式時,表示物件本身已經知道自己不再屬於某個session的屬性
    }

    //Session繫結聆聽器不需要在DD檔中做設定的
    //如果一個屬性類別(就像這個Dog)實作了HttpSessionBindingListener,那麼當物件加入到或移除自一個Session時
    //容器系統會自動呼叫物件的事件控管,做呼叫返回(Callback)通知(如:valueBound()和valueUnbound())
    //HttpSessionListener.HttpSessionAttributeListener和HttpSessionActivationListener必須在DD檔中註冊
    //因為它們是與Session物件直接相關,而這裡的Session繫結聆聽器(HttpSessionBindingListener)則是相關於屬性物件本身


    //Session activation事件(但是注意這些方法的參數是HttpSessionEvent)
    public void sessionWillPassivate(HttpSessionEvent event) {
        //這裡的程式用來取得那些不可序列化欄位的狀態值
        //以便在移到新的VM後能繼續存在
    }

    public void sessionDidActivate(HttpSessionEvent event) {
        //這裡的程式用來還原欄位值...
        //把在SessionWillPassivate()沒做的事重做一次
    }
}
