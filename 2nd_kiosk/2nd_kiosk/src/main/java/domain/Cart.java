package domain;

import Service.KioskService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Cart {
    List<Order> orderList;
    List<Order> totalList;
    private int orderNumber;
    private double totalSaleAmount; // 총판매된 누적 주문 금액

    public Cart(List<Order> orderList, List<Order> totalList, int initialOrderNumber, double totalSaleAmount) {
        this.orderList = orderList;
        this.totalList = totalList;
        this.orderNumber = initialOrderNumber;
        this.totalSaleAmount = totalSaleAmount;  // 초기화
    }

    public void addOrder(Order order, int itemCount) {
        boolean found = false;
        for (Order existingOrder : orderList) {
            if (existingOrder.getName().equals(order.getName())) {
                existingOrder.setQuantity(existingOrder.getQuantity() + itemCount);
                totalSaleAmount += order.getPrice() * itemCount;  // 이미 있는 제품의 Amount
                found = true;
                break;
            }
        }
        if (!found) {
            orderList.add(order);
            totalList.add(order);
            totalSaleAmount += order.getPrice() * itemCount;   // 새로운 제품의 Amount
            order.setQuantity(itemCount);
        }
    }

    public void addToCart(Order selectedOrder, Cart cart, Scanner sc, KioskService kioskService) {
        cart.addOrder(selectedOrder, selectedOrder.getQuantity());
        kioskService.mainMenu();
    }

    public BigDecimal calculateTotalprice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Order order : orderList) {
            BigDecimal orderPrice = BigDecimal.valueOf(order.getPrice());
            totalPrice = totalPrice.add(orderPrice);
        }
        return totalPrice.setScale(1, BigDecimal.ROUND_HALF_UP);
    }

    public void cancelOrder() {
        orderList.clear();
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public List<Order> getTotalList() {
        return totalList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void incrementOrderNumber() {
        orderNumber++;
    }

    public double getTotalSaleAmount() {
        return totalSaleAmount;
    }
}
