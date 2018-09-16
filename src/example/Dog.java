package example;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//Dog屬性物件也身兼聆聽器程式了,他負責監聽自己這個物件被加到一個Session或者從一個Session移除等事件
//繫結用的聆聽器不必在DD檔中註冊,他會自動執行
public class Dog implements HttpSessionBindingListener {
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
}
