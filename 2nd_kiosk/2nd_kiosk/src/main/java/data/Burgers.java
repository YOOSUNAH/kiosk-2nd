package data;

import java.util.HashMap;

public enum Burgers {
    // enum은 정적인 데이터
    BURGER_1("1", "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
    BURGER_2("2", "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
    BURGER_3("3", "Shroom_Burger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"),
    BURGER_4("4", "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
    BURGER_5("5", "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"),

    ShackBurger_Single("1", "ShackBurger", 6.9, "Single"),
    ShackBurger_Double("1", "ShackBurger", 10.9, "Double"),
    SmokeShack_Single("2", "SmokeShack", 8.9, "Single"),
    SmokeShack_Burger_Double("2", "SmokeShack_Burger", 12.9, "Double"),
    Cheeseburger_Single("4", "Cheeseburger", 6.9, "Single"),
    Cheeseburger_Double("4", "Cheeseburger", 10.9, "Double"),
    Hamburger_Single("5", "Hamburger", 5.4, "Single"),
    Hamburger_Double("5", "Hamburger", 9.0, "Double");


    //enum 생성자가 필수다
    public final String no;
    public final String name;
    public final double price;
    public final String description;

    // 개인 공부용 주석
    // private final String name 이면 아래처럼 getter를 만들어야 한다.
    // public String getName(){
    // return name;
    // }

    Burgers(String no, String name, double price, String description) {
        this.no = no;
        this.name = name;
        this.price = price;
        this.description = description;

    }
}
