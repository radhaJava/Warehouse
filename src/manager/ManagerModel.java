package manager;

import Data.*;
import loginPage.LoginPage;

import java.util.List;

public class ManagerModel {
    private static final List<String> menuOptions = List.of("View OrderList", "Approve OrderList", "Logout");

    private final List<Order> orderList = OrderList.getOrderListFromFile();

    public List<Order> getOrderList() {
        return orderList;
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) {
        ManagerAction manager = new ManagerAction();
        switch (selectedOption) {
            case 1 -> manager.viewOderList(getOrderList());
            case 2 -> manager.approveOrderList(getOrderList());
            case 3 -> logout();
        }
        new Manager();
    }

    private void logout() {
        new LoginPage();
    }
}

