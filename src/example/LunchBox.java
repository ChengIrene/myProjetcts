package example;

public class LunchBox {
    private String name;
    private String mainDish;
    private String sideDish;
    private String drink;

    public LunchBox(String name, String mainDish, String sideDish, String drink) {
        this.name = name;
        this.mainDish = mainDish;
        this.sideDish = sideDish;
        this.drink = drink;
    }

    public String getName() {
        return name;
    }

    public String getMainDish() {
        return mainDish;
    }

    public String getSideDish() {
        return sideDish;
    }

    public String getDrink() {
        return drink;
    }
}
