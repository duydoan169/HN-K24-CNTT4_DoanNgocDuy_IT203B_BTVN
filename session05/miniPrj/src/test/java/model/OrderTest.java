package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    @Test
    void testCalculateTotal() {

        // tạo món ăn
        Food burger = new Food("F01","Burger",30000);

        // tạo đơn hàng
        Order order = new Order("O01");

        // thêm 2 burger
        order.addItem(burger,2);

        // áp dụng giảm giá 10%
        order.applyDiscount(10);

        // tổng tiền mong đợi
        double expected = 54000;

        // kiểm tra kết quả
        assertEquals(expected, order.calculateTotal());

    }

}