package domain;

public class Order {
    private String name;
    private String description;
    private double price;
    private int quantity;


    public Order(String name, double price, String description, int quantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int setQuantity(int quantity) {
        return quantity;
    }

 }

