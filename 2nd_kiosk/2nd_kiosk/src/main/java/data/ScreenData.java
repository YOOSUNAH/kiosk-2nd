package data;

import java.util.HashMap;
import java.util.Map;

public class ScreenData {

    private final Map<ScreenStage, String> screedDataMap = new HashMap<>();

    public ScreenData() {
        screenInitializationData();
    }

    public String getScreenData(ScreenStage screenStage) {
        return screedDataMap.get(screenStage);
    }

    private void screenInitializationData() {

        screedDataMap.put(ScreenStage.MAIN_MENU, "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n" +
            "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n" +
            "\n" +
            "[ SHAKESHACK MENU ]\n" +
            "1. Burgers         | 앵거스 비프 통살을 다져만든 버거\n" +
            "2. Frozen Custard  | 매장에서 신선하게 만드는 아이스크림\n" +
            "3. Drinks          | 매장에서 직접 만드는 음료\n" +
            "4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주\n" +
            "\n" +
            "[ ORDER MENU ]\n" +
            "5. Order       | 장바구니를 확인 후 주문합니다.\n" +
            "6. Cancel      | 진행중인 주문을 취소합니다.");

        screedDataMap.put(ScreenStage.BURGERMENU, " \"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n" +
            "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n" +
            "\n" +
            "[ Burgers MENU ]\n" +
            "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
            "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
            "3. Shroom Burger | W 9.4 | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거\n" +
            "4. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
            "5. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");

        screedDataMap.put(ScreenStage.FROZENCUSTARDMENU, " \"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n" +
            "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n" +
            "\n" +
            "[ FrozenCustard MENU ]\n" +
            "1. Shakes            | W 5.9 | 바닐라, 초콜렛, 솔티드 카라멜, 블랙 &화이트, 스트로베리, 피넛버터, 커피\n" +
            "2. Shake of the Week | W 6.5 | 특별한 커스터드 플레이버\n" +
            "3. Red Bean Shake    | W 5.9 | 신비한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크\n" +
            "4. Floats            | W 5.9 | 루트 비어, 퍼플 카우, 크림시클\n" +
            "5. Cups & Cones      | W 4.9 | 바닐라, 초콜렛, Flavor of the Week\n" +
            "6. Concretes         | W 5.9 | 쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합");

        screedDataMap.put(ScreenStage.DRINKSMENU, " \"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n" +
            "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n" +
            "\n" +
            "[ Drinks MENU ]\n" +
            "1. Shack-made Lemonade   | W 3.9 | 매장에서 직접 만드는 상큼한 레몬에이드\n" +
            "2. Fresh Brewed Iced Tea | W 3.4 | 직접 유기농 홍차를 우려낸 아이스티\n" +
            "3. Fifty/Fifty           | W 3.5 | 레몬에이드와 아이스티의 만남\n" +
            "4. Fountain Soda         | W 2.7 | 코카콜라, 코카콜라제로, 스프라이트, 환타 오렌지, 한타 그레이프\n" +
            "5. Abita Root Beer       | W 4.4 | 청량감 있는 독특한 미국식 무알콜 탄산음료\n" +
            "6. Bottled Water         | W 1.0 | 지리산 암반대수층으로 만든 프리미엄 생수");

        screedDataMap.put(ScreenStage.BEERMENU, " \"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n" +
            "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n" +
            "\n" +
            "[ Beer MENU ]\n" +
            "1. ShackMeister Ale | W 9.8 | 쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주\n" +
            "2. Magpie Brewing Co| W 6.8 |\n");

        screedDataMap.put(ScreenStage.BUY,
            "위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                "1. 확인        2. 취소");

        screedDataMap.put(ScreenStage.BUYOPTION,
            "위 메뉴의 어떤 옵셔으로 추가하시겠습니까?\n");

        screedDataMap.put(ScreenStage.ORDER_SECTOR_1, "아래와 같이 주문 하시겠습니까?\n" +
            "\n" +
            "[ Orders ]"
        );
        screedDataMap.put(ScreenStage.ORDER_SECTOR_2, "[ Total ]");

        screedDataMap.put(ScreenStage.ORDER_SECTOR_3, "\n1. 주문      2. 메뉴판");

        screedDataMap.put(ScreenStage.DECIDE_ORDER1, "주문이 완료되었습니다!\n");

        screedDataMap.put(ScreenStage.DECIDE_ORDER2, "(3초후 메뉴판으로 돌아갑니다.)\n");

        screedDataMap.put(ScreenStage.ORDER_CANCEL, "진행하던 주문을 취소하시겠습니까?\n" +
            "1. 확인        2. 취소");

        screedDataMap.put(ScreenStage.CANCEL_COMPLETE, "진행하던 주문이 취소되었습니다.\n" +
            "\n" +
            "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n" +
            "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n" +
            "\n" +
            "[ SHAKESHACK MENU ]\n" +
            "1. Burgers         | 앵거스 비프 통살을 다져만든 버거\n" +
            "2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림\n" +
            "3. Drinks          | 매장에서 직접 만드는 음료\n" +
            "4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주\n" +
            "\n" +
            "[ ORDER MENU ]\n" +
            "5. Order       | 장바구니를 확인 후 주문합니다.\n" +
            "6. Cancel      | 진행중인 주문을 취소합니다.");
        screedDataMap.put(ScreenStage.TOTALSALEAMOUNT1, "[ 총 판매금액 현황 ]\n");
        screedDataMap.put(ScreenStage.TOTALSALEAMOUNT2, "\n1. 돌아가기");
        screedDataMap.put(ScreenStage.TOTALSALELIST, "[ 총 판매상품 목록 현황 ]\n" +
            "현재까지 총 판매된 상품 목록은 아래와 같습니다.\n");
        //SHAKESHACK MENU
//        screedDataMap.put(ScreenStage.BURGESR, "Burgers");
//        screedDataMap.put(ScreenStage.FROZENCUSTARD, "Frozen Custard");
//        screedDataMap.put(ScreenStage.DRINKS, "Drinks");
//        screedDataMap.put(ScreenStage.BEER, "Beer");
//
//
//        screedDataMap.put(ScreenStage.BURGER_1, "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\\n");
//        screedDataMap.put(ScreenStage.BURGER_2, "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\\n");
//        screedDataMap.put(ScreenStage.BURGER_3, "3. Shroom Burger | W 9.4 | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거\\n");
//        screedDataMap.put(ScreenStage.BURGER_4, "4. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\\n");
//        screedDataMap.put(ScreenStage.BURGER_5, "5. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
//        //
//        screedDataMap.put(ScreenStage.FROZENCUSTARD_1, "1. Shakes            | W 5.9 | 바닐라, 초콜렛, 솔티드 카라멜, 블랙 &화이트, 스트로베리, 피넛버터, 커피\\n");
//        screedDataMap.put(ScreenStage.FROZENCUSTARD_2, "2. Shake of the Week | W 6.5 | 특별한 커스터드 플레이버\\n");
//        screedDataMap.put(ScreenStage.FROZENCUSTARD_3, "3. Red Bean Shake    | W 5.9 | 신비한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크\\n");
//        screedDataMap.put(ScreenStage.FROZENCUSTARD_4, "4. Floats            | W 5.9 | 루트 비어, 퍼플 카우, 크림시클\\n");
//        screedDataMap.put(ScreenStage.FROZENCUSTARD_5, "5. Cups & Cones      | W 4.9 | 바닐라, 초콜렛, Flavor of the Week\\n");
//        screedDataMap.put(ScreenStage.FROZENCUSTARD_6, "6. Concretes         | W 5.9 | 쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합");
//        //
//        screedDataMap.put(ScreenStage.DRINKS_1, "1. Shack-made Lemonade   | W 3.9 | 매장에서 직접 만드는 상큼한 레몬에이드\\n");
//        screedDataMap.put(ScreenStage.DRINKS_2, "2. Fresh Brewed Iced Tea | W 3.4 | 직접 유기농 홍차를 우려낸 아이스티\\n");
//        screedDataMap.put(ScreenStage.DRINKS_3, "3. Fifty/Fifty           | W 3.5 | 레몬에이드와 아이스티의 만남\\n");
//        screedDataMap.put(ScreenStage.DRINKS_4, "4. Fountain Soda         | W 2.7 | 코카콜라, 코카콜라제로, 스프라이트, 환타 오렌지, 한타 그레이프\\n");
//        screedDataMap.put(ScreenStage.DRINKS_5, "5. Abita Root Beer       | W 4.4 | 청량감 있는 독특한 미국식 무알콜 탄산음료\\n");
//        screedDataMap.put(ScreenStage.DRINKS_6, "6. Bottled Water         | W 1.0 | 지리산 암반대수층으로 만든 프리미엄 생수");
//        //
//        screedDataMap.put(ScreenStage.BEER_1, "1. ShackMeister Ale | W 9.8 | 쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주\\n");
//        screedDataMap.put(ScreenStage.BEER_2, "2. Magpie Brewing Co| W 6.8 |\\n");
    }

}
