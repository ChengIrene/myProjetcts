package model;

import java.util.ArrayList;
import java.util.List;

public class HobbyList {
    public List getName(String hobby) {
        List name = new ArrayList();
        if (hobby.equals("horse skiing")) {
            name.add("Kiyomitsu");
            name.add("Yasusada");
        } else if (hobby.equals("extreme knitting")) {
            name.add("Fred");
            name.add("Pradeep");
            name.add("Philippe");
        } else if (hobby.equals("alpine scuba")) {
            name.add("Ruru");
        } else {
            name.add("Carl");
            name.add("Paul");
        }

        return (name);
    }
}
