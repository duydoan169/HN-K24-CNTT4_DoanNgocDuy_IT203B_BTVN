package service;

import model.Food;
import org.junit.jupiter.api.Test;
import service.MenuService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuServiceTest {

    @Test
    void testAddItem() {

        MenuService menuService = new MenuService();

        Food burger = new Food("F01","Burger",30000);

        menuService.addItem(burger);

        // kiểm tra menu có 1 phần tử
        assertEquals(1, menuService.getMenu().size());

    }

}