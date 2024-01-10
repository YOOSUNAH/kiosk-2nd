package main;

import Service.KioskService;
import Service.OrderProcess;
import Service.SelectMenu;
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
        OrderProcess order = new OrderProcess();
        kioskService.mainMenu();
        order.orderProcess(sc, kioskService, cart);
    }
}







