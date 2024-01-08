package domain;

public class Burger extends Menu {
    private String name;
    private String description;
    private double price;

    public Burger(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
