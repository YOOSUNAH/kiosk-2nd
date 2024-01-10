package main;

import Service.KioskService;
import data.Beers;
import data.Burgers;
import data.Drinks;
import data.FrozenCustards;
import domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        KioskService kioskService = new KioskService();
        Cart cart = new Cart(new ArrayList<>(), new ArrayList<>(), 1, 0);
        Scanner sc = new Scanner(System.in);

        // 메인 메뉴판 화면
        kioskService.mainMenu();
        orderProcess(sc, kioskService, cart);
    }

    public static void orderProcess(Scanner sc, KioskService kioskService, Cart cart) {

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
                    selectBurger(kioskService, orderBurger, sc, cart);
                    break;
                case "Frozen Custard":
                    kioskService.frozenCustardMenu();
                    orderFrozenCustard = sc.nextLine().strip();
                    selectFrozenCustard(kioskService, orderFrozenCustard, sc, cart);
                    break;
                case "Drinks":
                    kioskService.drinksMenu();
                    orderDrinks = sc.nextLine().strip();
                    selectDrinks(kioskService, orderDrinks, sc, cart);
                    break;
                case "Beer":
                    kioskService.beerMenu();
                    orderBeer = sc.nextLine().strip();
                    selectBeer(kioskService, orderBeer, sc, cart);
                    break;
                case "Order":
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
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                    kioskService.mainMenu();
                    break;
            }
        }
    }

    private static void selectBurger(KioskService kioskService, String orderBurger, Scanner sc, Cart cart) {
        Burgers selectedBurger = null;
        for (Burgers burger : Burgers.values()) {
            if (orderBurger.equals(burger.name)) {
                System.out.print(
                    String.format("%s | W %.1f | %s \n",
                        burger.name,
                        burger.price,
                        burger.description
                    )
                );
                // 추가 기능 구현 중
                System.out.println(
                    "위 메뉴의 어떤 옵션으로 추가하시겠습니까?\n"
                        + "1. Single(W " + burger.price
                        + ") 2. Double(W " + Burgers.valueOf(burger.name + "_Double").price
                        + ")"
                );
                break;  // 출력하고 for문 break;
            }
            selectedBurger = burger;
        }
        // 사용자의 선택에 따라 옵션 처리
        String selectedOption = sc.nextLine().strip();
        for (Burgers burgerOption : Burgers.values()) {
            if (selectedOption.equals("1")) {
                String single = Burgers.valueOf(burgerOption.name + "_Single").description;
                System.out.print(
                    String.format("%s(%s) | W %.1f | %s \n",
                        burgerOption.name,
                        single,
                        burgerOption.price,
                        burgerOption.description
                    )
                );
            } else if (selectedOption.equals("2")) {
                String Doulbe = Burgers.valueOf(burgerOption.name + "_Double").description;
                System.out.print(
                    String.format("%s(%s) | W %.1f | %s \n",
                        burgerOption.name,
                        Doulbe,
                        Burgers.valueOf(burgerOption.name + "_Double").price,
                        burgerOption.description
                    )
                );
            }
            break;
        }
        kioskService.buy();  // 위 메뉴를 장바구니에 추가하시겠습니까?
        String askOrderToCart = sc.nextLine().strip();
        if (askOrderToCart.equals("1. 확인") && selectedBurger != null) {
            System.out.println(selectedBurger.name + "가 장바구니에 추가되었습니다.\n");
            Order orderInfo = new Order(selectedBurger.name, selectedBurger.price, selectedBurger.description, 1);
            addToCart(orderInfo, cart, sc, kioskService);
            return;  // 출력문이 안나오고 입력가능한 화면이 나왔다가 return 으로 메서드 종료 시켜 출력문이 나오게 되었다.
        } else if (askOrderToCart.equals("2. 취소")) {
            kioskService.mainMenu();
        }
    }


    private static void selectFrozenCustard(KioskService kioskService, String orderFrozenCustard, Scanner sc, Cart cart) {
        FrozenCustards selectedFrozenCustards = null;
        for (FrozenCustards frozenCustards : FrozenCustards.values()) {
            if (orderFrozenCustard.equals(frozenCustards.name)) {
                System.out.println(
                    String.format("%s | W %.1f | %s \n",
                        frozenCustards.name,
                        frozenCustards.price,
                        frozenCustards.description)
                );
                break;
            }
            selectedFrozenCustards = frozenCustards;
        }
        // 추가 기능 구현 중
                if (selectedFrozenCustards.name.equals("Cups_Cones") || selectedFrozenCustards.name.equals("Concretes")) {
                    System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?\n"
                        + "1. Single(W " + selectedFrozenCustards.price
                        + ") 2. Double(W " + FrozenCustards.valueOf(selectedFrozenCustards.name + "_Double").price
                        + ")"
                    );
                    // 사용자의 선택에 따라 옵션 처리
                    String selectedOption = sc.nextLine().strip();

                        if (selectedOption.equals("1")) {
                            String single = FrozenCustards.valueOf(selectedFrozenCustards.name + "_Single").description;
                            System.out.print(
                                String.format("%s(%s) | W %.1f | %s \n",
                                    selectedFrozenCustards.name,
                                    single,
                                    selectedFrozenCustards.price,
                                    selectedFrozenCustards.description
                                )
                            );

                        } else if (selectedOption.equals("2")) {
                            String Doulbe = FrozenCustards.valueOf(selectedFrozenCustards.name + "_Double").description;
                            System.out.print(
                                String.format("%s(%s) | W %.1f | %s \n",
                                    selectedFrozenCustards.name,
                                    Doulbe,
                                    FrozenCustards.valueOf(selectedFrozenCustards.name + "_Double").price,
                                    selectedFrozenCustards.description
                                )
                            );
                        }
                }

        kioskService.buy();  //   "위 메뉴를 장바구니에 추가하시겠습니까?\n"
        String askOrderToCart = sc.nextLine().strip();
        if (askOrderToCart.equals("1. 확인") && selectedFrozenCustards != null) {
            System.out.println(selectedFrozenCustards.name + "가 장바구니에 추가되었습니다.\n");
            Order orderInfo = new Order(selectedFrozenCustards.name, selectedFrozenCustards.price, selectedFrozenCustards.description, 1);
            addToCart(orderInfo, cart, sc, kioskService);
            return;
        } else if (askOrderToCart.equals("2. 취소")) {
            kioskService.mainMenu();
        }
    }

    private static void selectDrinks(KioskService kioskService, String orderDrinks, Scanner sc, Cart cart) {
        Drinks selectedDrinks = null;
        for (Drinks drink : Drinks.values()) {
            if (orderDrinks.equals(drink.name)) {
                System.out.println(
                    String.format("%s | W %.1f | %s \n",
                        drink.name,
                        drink.price,
                        drink.description)
                );
                break;
            }
        }
        for (Drinks drink : Drinks.values()) {
            // Abita_Root_Be , Bottled_Water 아닌 경우
            if (!orderDrinks.equals("Abita_Root_Be") && !orderDrinks.equals("Bottled_Water")) {
                // 추가 기능 구현 중
                System.out.println(
                    "위 메뉴의 어떤 옵션으로 추가하시겠습니까?\n"
                        + "1. Regular(W " + drink.price
                        + ") 2. Large(W " + Burgers.valueOf(drink.name + "_Large").price
                        + ")"
                );
                // 사용자의 선택에 따라 옵션 처리
                String selectedOption = sc.nextLine().strip();
                for (Drinks drinksOption : Drinks.values()) {
                    if (selectedOption.equals("1")) {
                        String regular = Drinks.valueOf(drinksOption.name + "_Regular").description;
                        System.out.print(
                            String.format("%s(%s) | W %.1f | %s \n",
                                drinksOption.name,
                                regular,
                                drinksOption.price,
                                drinksOption.description
                            )
                        );
                    } else if (selectedOption.equals("2")) {
                        String large = Drinks.valueOf(drinksOption.name + "_Large").description;
                        System.out.print(
                            String.format("%s(%s) | W %.1f | %s \n",
                                drinksOption.name,
                                large,
                                Drinks.valueOf(drinksOption.name + "_Double").price,
                                drinksOption.description
                            )
                        );
                    }
                    break;
                }
                break;
            }
            selectedDrinks = drink;
        }
        kioskService.buy();
        String askOrderToCart = sc.nextLine().strip();
        if (askOrderToCart.equals("1. 확인") && selectedDrinks != null) {
            System.out.println(selectedDrinks.name + "가 장바구니에 추가되었습니다.\n");
            Order orderInfo = new Order(selectedDrinks.name, selectedDrinks.price, selectedDrinks.description, 1);
            addToCart(orderInfo, cart, sc, kioskService);
            return;
        } else if (askOrderToCart.equals("2. 취소")) {
            kioskService.mainMenu();
            orderProcess(sc, kioskService, cart);
        }
    }

    private static void selectBeer(KioskService kioskService, String orderBeer, Scanner sc, Cart cart) {
        Beers selectedBeer = null;
        for (Beers beer : Beers.values()) {
            if (orderBeer.equals(beer.name)) {
                System.out.println(
                    String.format("%s. %s | W %.1f | %s \n",
                        beer.no,
                        beer.name,
                        beer.price,
                        beer.description)
                );
                selectedBeer = beer;
            }
        }
        kioskService.buy();
        String askOrderToCart = sc.nextLine().strip();
        if (askOrderToCart.equals("1. 확인") && selectedBeer != null) {
            System.out.println(selectedBeer.name + "가 장바구니에 추가되었습니다.\n");
            Order orderInfo = new Order(selectedBeer.name, selectedBeer.price, selectedBeer.description, 1);
            addToCart(orderInfo, cart, sc, kioskService);
            return;
        } else if (askOrderToCart.equals("2. 취소")) {
            kioskService.mainMenu();
        }
    }

    private static void addToCart(Order selectedOrder, Cart cart, Scanner sc, KioskService kioskService) {
        cart.addOrder(selectedOrder, selectedOrder.getQuantity());
        kioskService.mainMenu();
    }
}






