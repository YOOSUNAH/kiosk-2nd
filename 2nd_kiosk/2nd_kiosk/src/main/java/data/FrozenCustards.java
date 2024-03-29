package data;

public enum FrozenCustards {
    // enum은 정적인 데이터
    FrozenCustard_1("1", "Shakes",5.9,"바닐라, 초콜렛, 솔티드 카라멜, 블랙 &화이트, 스트로베리, 피넛버터, 커피"),
    FrozenCustard_2("2", "Shake of the Week", 6.5, "특별한 커스터드 플레이버"),
    FrozenCustard_3("3","Red Bean Shake", 5.9,"신비한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크"),
    FrozenCustard_4("4", "Floats", 5.9,"루트 비어, 퍼플 카우, 크림시클"),

    FrozenCustard_5("5", "Cups_Cones", 4.9, "바닐라, 초콜렛, Flavor of the Week"),
    FrozenCustard_6("6", "Concretes", 1.0, "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의조합"),
    //
    Cups_Cones_Single("5", "Cups_Cones", 4.9, "Single"),
    Cups_Cones_Double("5", "Cups_Cones", 5.9, "Double"),
    Concretes_Single("6", "Concretes", 5.9, "Single"),
    Concretes_Double("6", "Concretes", 8.9, "Double");

    //enum 생성자가 필수다
    public final String no;
    public final String name;
    public final double price;
    public final String description;


     FrozenCustards(String no, String name, double price, String description){
        this.no = no;
        this.name = name;
        this.price = price;
        this.description = description;

    };
}
