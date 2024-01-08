package domain;

public class Drink extends Menu {
    private String name;
    private String description;
    private int price;

    public Drink(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
