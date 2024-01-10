package Service;

import data.Beers;
import data.Burgers;
import data.Drinks;
import data.FrozenCustards;
import domain.Cart;
import domain.Order;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectMenu {


    Cart cart = new Cart(new ArrayList<>(), new ArrayList<>(), 1, 0);



    public void selectBurger(KioskService kioskService, String orderBurger, Scanner sc, Cart cart) {
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
            cart.addToCart(orderInfo, cart, sc, kioskService);
            return;  // 출력문이 안나오고 입력가능한 화면이 나왔다가 return 으로 메서드 종료 시켜 출력문이 나오게 되었다.
        } else if (askOrderToCart.equals("2. 취소")) {
            kioskService.mainMenu();
        }
    }


    public void selectFrozenCustard(KioskService kioskService, String orderFrozenCustard, Scanner sc, Cart cart) {
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
            cart.addToCart(orderInfo, cart, sc, kioskService);
            return;
        } else if (askOrderToCart.equals("2. 취소")) {
            kioskService.mainMenu();
        }
    }

    public void selectDrinks(KioskService kioskService, String orderDrinks, Scanner sc, Cart cart) {
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
            selectedDrinks = drink;
        }
        // 추가 기능 구현 중
        // Abita_Root_Be , Bottled_Water 아닌 경우
        if (!selectedDrinks.name.equals("Abita_Root_Be") && !selectedDrinks.name.equals("Bottled_Water")) {
            System.out.println(
                "위 메뉴의 어떤 옵션으로 추가하시겠습니까?\n"
                    + "1. Regular(W " + selectedDrinks.price
                    + ") 2. Large(W " + Drinks.valueOf(selectedDrinks.name + "_Large").price
                    + ")"
            );
            // 사용자의 선택에 따라 옵션 처리
            String selectedOption = sc.nextLine().strip();
            if (selectedOption.equals("1")) {
                String regular = Drinks.valueOf(selectedDrinks.name + "_Regular").description;
                System.out.print(
                    String.format("%s(%s) | W %.1f | %s \n",
                        selectedDrinks.name,
                        regular,
                        selectedDrinks.price,
                        selectedDrinks.description
                    )
                );
            } else if (selectedOption.equals("2")) {
                String large = Drinks.valueOf(selectedDrinks.name + "_Large").description;
                System.out.print(
                    String.format("%s(%s) | W %.1f | %s \n",
                        selectedDrinks.name,
                        large,
                        Drinks.valueOf(selectedDrinks.name + "_Large").price,
                        selectedDrinks.description
                    )
                );
            }
        }
        kioskService.buy();
        String askOrderToCart = sc.nextLine().strip();
        if (askOrderToCart.equals("1. 확인") && selectedDrinks != null) {
            System.out.println(selectedDrinks.name + "가 장바구니에 추가되었습니다.\n");
            Order orderInfo = new Order(selectedDrinks.name, selectedDrinks.price, selectedDrinks.description, 1);
            cart.addToCart(orderInfo, cart, sc, kioskService);
            return;
        } else if (askOrderToCart.equals("2. 취소")) {
            kioskService.mainMenu();
        }
    }

    public void selectBeer(KioskService kioskService, String orderBeer, Scanner sc, Cart cart) {
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
            cart.addToCart(orderInfo, cart, sc, kioskService);
            return;
        } else if (askOrderToCart.equals("2. 취소")) {
            kioskService.mainMenu();
        }
    }



}
