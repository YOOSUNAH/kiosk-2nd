package Service;

import data.ScreenData;
import data.ScreenStage;

public class KioskService {
    private final ScreenData screenData = new ScreenData();

    public KioskService() {
        defaultbehavior();
    }


    public void print(String screenData) {
        System.out.println(screenData);
    }

    private void defaultbehavior() {
        print("\n\n==================================\n\n");
    }

    public void mainMenu() {
        print(screenData.getScreenData(ScreenStage.MAIN_MENU));
    }

    public void buy() {
        print(screenData.getScreenData(ScreenStage.BUY));
    }

    public void orderCheck1() {
        print(screenData.getScreenData(ScreenStage.ORDER_SECTOR_1));
    }
    public void orderCheck2() {
        print(screenData.getScreenData(ScreenStage.ORDER_SECTOR_2));
    }
    public void orderCheck3() {
        print(screenData.getScreenData(ScreenStage.ORDER_SECTOR_3));
    }
    public void decideOrder1() {
        print(screenData.getScreenData(ScreenStage.DECIDE_ORDER1));
    }
    public void decideOrder2() {
        print(screenData.getScreenData(ScreenStage.DECIDE_ORDER2));
    }

    public void orderCancel() {
        print(screenData.getScreenData(ScreenStage.ORDER_CANCEL));
    }
    public void cancelComplete() {
        print(screenData.getScreenData(ScreenStage.CANCEL_COMPLETE));
    }
    public void burgerMenu() {
        print(screenData.getScreenData(ScreenStage.BURGERMENU));
    }
    public void frozenCustardMenu() {
        print(screenData.getScreenData(ScreenStage.FROZENCUSTARDMENU));
    }

    public void drinksMenu() {
        print(screenData.getScreenData(ScreenStage.DRINKSMENU));
    }
    public void beerMenu() {
        print(screenData.getScreenData(ScreenStage.BEERMENU));
    }
    public void totalSaleAmount1() {
        print(screenData.getScreenData(ScreenStage.TOTALSALEAMOUNT1));
    }
    public void totalSaleAmount2() {
        print(screenData.getScreenData(ScreenStage.TOTALSALEAMOUNT2));
    }


//    public void burgers() {
//        print(screenData.getScreenData(ScreenStage.BURGESR));
//    }
//    public void frozenCustard() {
//        print(screenData.getScreenData(ScreenStage.FROZENCUSTARD));
//    }
//    public void drinks() {
//        print(screenData.getScreenData(ScreenStage.DRINKS));
//    }
    //    public void burger1() {
//        print(screenData.getScreenData(ScreenStage.BURGER_1));
//    }
//
//    public void burger2() {
//        print(screenData.getScreenData(ScreenStage.BURGER_2));
//    }
//
//    public void burger3() {
//        print(screenData.getScreenData(ScreenStage.BURGER_3));
//    }
//
//    public void burger4() {
//        print(screenData.getScreenData(ScreenStage.BURGER_4));
//    }
//
//    public void burger5() {
//        print(screenData.getScreenData(ScreenStage.BURGER_5));
//    }
    //
//    public void frozenCustard1() {
//        print(screenData.getScreenData(ScreenStage.FROZENCUSTARD_1));
//    }
//
//    public void frozenCustard2() {
//        print(screenData.getScreenData(ScreenStage.FROZENCUSTARD_2));
//    }
//
//    public void frozenCustard3() {
//        print(screenData.getScreenData(ScreenStage.FROZENCUSTARD_3));
//    }
//
//    public void frozenCustard4() {
//        print(screenData.getScreenData(ScreenStage.FROZENCUSTARD_4));
//    }
//
//    public void frozenCustard5() {
//        print(screenData.getScreenData(ScreenStage.FROZENCUSTARD_5));
//    }
//
//    public void frozenCustard6() {
//        print(screenData.getScreenData(ScreenStage.FROZENCUSTARD_6));
//    }


//    public void drinks1() {
//        print(screenData.getScreenData(ScreenStage.DRINKS_1));
//    }
//
//    public void drinks2() {
//        print(screenData.getScreenData(ScreenStage.DRINKS_2));
//    }
//
//    public void drinks3() {
//        print(screenData.getScreenData(ScreenStage.DRINKS_3));
//    }
//
//    public void drinks4() {
//        print(screenData.getScreenData(ScreenStage.DRINKS_4));
//    }
//
//    public void drinks5() {
//        print(screenData.getScreenData(ScreenStage.DRINKS_5));
//    }
//
//    public void drinks6() {
//        print(screenData.getScreenData(ScreenStage.DRINKS_6));
//    }
//    public void beer1() {
//        print(screenData.getScreenData(ScreenStage.BEER_1));
//    }
//
//    public void beer2() {
//        print(screenData.getScreenData(ScreenStage.BEER_2));
//    }
//


}
