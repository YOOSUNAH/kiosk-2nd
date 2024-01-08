package data;

public enum Beers {
    // enum은 정적인 데이터
    BEERR_1("1", "ShackMeister Ale", 9.8, "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주"),
    BEERR_2("2", "Magpie Brewing Co", 6.8, " ");
    //enum 생성자가 필수다
    public final String no;
    public final String name;
    public final double price;
    public final String description;

    Beers(String no, String name, double price, String description) {
        this.no = no;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
