package domain;

import java.util.List;

public class Cart {

    List<Order> orderList;
    private int orderNumber;
    private double totalSaleAmount; // 총판매된 누적 주문 금액


    public Cart(List<Order> orderList, int initialOrderNumber, double totalSaleAmount) {
        this.orderList = orderList;
        this.orderNumber = initialOrderNumber;
        this.totalSaleAmount = totalSaleAmount;  // 초기화
    }

    public void addOrder(Order order) {
        orderList.add(order);
        totalSaleAmount += order.getPrice();
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    public void incrementOrderNumber(){
        orderNumber++;
    }
    public double getTotalSaleAmount(){
        return totalSaleAmount;
    }

    public void cancelOrder() {
        orderList.clear();
    }

    public double calculateTotalprice() {
        double totalPrice = 0;
        for (Order order : orderList) {
            totalPrice += order.getPrice();
        }
        return Double.parseDouble(String.format("%.1f", totalPrice));
    }


}
