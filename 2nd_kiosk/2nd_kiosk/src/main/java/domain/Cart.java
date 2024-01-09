package domain;

import java.math.BigDecimal;
import java.util.List;

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

    public void addOrder(Order order) {
        orderList.add(order);
        totalList.add(order);
        totalSaleAmount += order.getPrice();
    }



    // 정확한 계산을 위해서 BigDecimal class 사용!
    public BigDecimal calculateTotalprice() {
        BigDecimal totalPrice = BigDecimal.ZERO;  // 변수 생성,초기값 0을 가진 객체 할당
        for (Order order : orderList) {
            BigDecimal orderPrice = BigDecimal.valueOf(order.getPrice());  // BigDecimal 형태로 변환
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
    public void incrementOrderNumber(){
        orderNumber++;
    }
    public double getTotalSaleAmount(){
        return totalSaleAmount;
    }
}
