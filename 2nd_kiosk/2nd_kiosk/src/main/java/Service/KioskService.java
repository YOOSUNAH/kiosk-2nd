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

    public void buyOption() {
        print(screenData.getScreenData(ScreenStage.BUYOPTION));
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

    public void totalSaleList() {
        print(screenData.getScreenData(ScreenStage.TOTALSALELIST));
    }
}
