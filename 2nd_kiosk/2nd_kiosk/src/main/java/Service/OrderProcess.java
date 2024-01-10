package Service;

import domain.Cart;
import domain.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class OrderProcess {


    public void orderProcess(Scanner sc, KioskService kioskService, Cart cart) {
        SelectMenu selectMenu = new SelectMenu();

        boolean isRunning = true;
        while (isRunning) {
            // 상품 메뉴 선택 시
            String customerMenu = sc.nextLine().strip();
            String orderBeer;
            String orderDrinks;
            String orderFrozenCustard;
            String orderBurger;

            switch (customerMenu) {
                case "Burgers":
                    kioskService.burgerMenu();
                    // 상품 메뉴 - 카데고리 메뉴판
                    orderBurger = sc.nextLine().strip();
                    selectMenu.selectBurger(kioskService, orderBurger, sc, cart);
                    break;
                case "Frozen Custard":
                    kioskService.frozenCustardMenu();
                    orderFrozenCustard = sc.nextLine().strip();
                    selectMenu.selectFrozenCustard(kioskService, orderFrozenCustard, sc, cart);
                    break;
                case "Drinks":
                    kioskService.drinksMenu();
                    orderDrinks = sc.nextLine().strip();
                    selectMenu.selectDrinks(kioskService, orderDrinks, sc, cart);
                    break;
                case "Beer":
                    kioskService.beerMenu();
                    orderBeer = sc.nextLine().strip();
                    selectMenu.selectBeer(kioskService, orderBeer, sc, cart);
                    break;
                case "Order":
                    orderFeatures(sc,kioskService, cart);
                    break;
                case "Cancel":
                    kioskService.orderCancel();   // "진행하던 주문을 취소하시겠습니까?\n" +
                    String cancelprogress = sc.nextLine().strip();
                    if (cancelprogress.equals("1. 확인")) {
                        kioskService.cancelComplete();
                        cart.cancelOrder();
                        kioskService.mainMenu();
                    } else if (cancelprogress.equals("2. 취소")) {
                        kioskService.mainMenu();
                    }
                    break;
                case "0":
                    hiddenFeatures(sc,kioskService, cart);
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                    kioskService.mainMenu();
                    break;
            }
        }
    }


    public void hiddenFeatures(Scanner sc, KioskService kioskService, Cart cart) {
        // 총 판매 금액 조회
        double totalSaleAmount = cart.getTotalSaleAmount();
        kioskService.totalSaleAmount1();
        System.out.println(String.format("현재까지 총 판매된 금액은 [ W %.1f ] 입니다.", totalSaleAmount));
        kioskService.totalSaleAmount2();
        String combackToMainMenu = sc.nextLine().strip();
        if (combackToMainMenu.equals("1. 돌아가기")) {
            kioskService.mainMenu();
            orderProcess(sc, kioskService, cart);
        } else if (combackToMainMenu.equals("0")) {
            kioskService.totalSaleList();
            List<Order> totalList = cart.getTotalList();
            for (Order order : totalList) {
                System.out.println(
                    String.format("- %s | W %.1f",
                        order.getName(),
                        order.getPrice()
                    )
                );
            }
            kioskService.totalSaleAmount2();
        }
    }

    public void orderFeatures(Scanner sc, KioskService kioskService, Cart cart) {
        kioskService.orderCheck1();
        // 장바구니 보여주기
        //  Cart에 추가된 Order 리스트 가져와보기
        List<Order> orderList = cart.getOrderList();
        for (Order order : orderList) {
            System.out.println(
                String.format("%s | W %.1f | %d 개 | %s \n",
                    order.getName(),
                    order.getPrice(),
                    order.getQuantity(),
                    order.getDescription()
                )
            );
        }
        kioskService.orderCheck2();  // [Total]
        BigDecimal totalPrice = cart.calculateTotalprice();
        System.out.println(" W " + totalPrice);
        kioskService.orderCheck3();   // "1.주문, 2.메뉴판"
        String completeOrder = sc.nextLine().strip();
        if (completeOrder.equals("1. 주문")) {
            kioskService.decideOrder1();
            System.out.println("대기번호는 [ " + cart.getOrderNumber() + " ] 번 입니다.");
            cart.incrementOrderNumber();
            kioskService.decideOrder2();
            kioskService.mainMenu();
            cart.cancelOrder(); // 주문 완료 후 장바구니 초기화 해야함.
        } else if (completeOrder.equals("2. 메뉴판")) {  // 장바구니 초기화 하면 안됨.
            kioskService.mainMenu();
        }
    }

}
