package data;

public enum Drinks {
    // enum은 정적인 데이터
    DRINLK_1("1", "Shack-made Le", 3.9,"매장에서 직접 만드는 상큼한 레몬에이드"),
    DRINLK_2("2", "Fresh Brewed ",  3.4, "직접 유기농 홍차를 우려낸 아이스티"),
    DRINLK_3("3","Fifty/Fifty",  3.5, "레몬에이드와 아이스티의 만남"),
    DRINLK_4("4", "Fountain Soda",  2.7,"코카콜라, 코카콜라제로, 스프라이트, 환타 오렌지"),
    DRINLK_5("5","Abita Root Be" ,4.4,"청량감 있는 독특한 미국식 무알콜 탄산음료"),
    DRINLK_6("6","Bottled Water" ,1.0,"지리산 암반대수층으로 만든 프리미엄 생수"),
    DRINLK_1_REGULAR("1", "Shack-made Le Regular", 3.9, "Regular"),
    DRINLK_1_LARGE("2", "Shack-made Le Large", 4.5, "Large"),
    DRINLK_2_REGULAR("1", "Fresh Brewed Regular", 3.4, "Regular"),
    DRINLK_2_LARGE("2", "Fresh Brewed Large", 3.9, "Large"),
    DRINLK_3_REGULAR("1", "Fifty/Fifty Regular", 3.5, "Regular"),
    DRINLK_3_LARGE("2", "Fifty/Fifty Large", 4.4, "Large"),
    DRINLK_4_REGULAR("1", "Fountain Soda Regular", 2.7, "Regular"),
    DRINLK_4_LARGE("2", "Fountain Soda Large", 3.3, "Large");
    //enum 생성자가 필수다
    public final String no;
    public final String name;
    public final double price;
    public final String description;


     Drinks(String no, String name, double price, String description){
        this.no = no;
        this.name = name;
        this.price = price;
        this.description = description;

    };
}
