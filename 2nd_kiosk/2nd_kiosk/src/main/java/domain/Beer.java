package domain;

public class Beer extends Menu {

    private String name;
    private String description;
    private int price;

    public Beer(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
