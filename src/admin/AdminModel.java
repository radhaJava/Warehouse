package admin;

import Data.*;
import loginPage.LoginPage;
import loginPage.UserValidation;

import java.util.List;

public class AdminModel {
    private static final List<String> menuOptions = List.of("View User details", "View orderList",
            "View TransactionList","View Inventory","Logout");
    private final List<Product> productList = ProductsList.getProductListFromFile();
    private final List<Transaction> transactionList = TransactionList.getTransactionListFromFile();
    private final List<Order> orderList = OrderList.getOrderListFromFile();

    public List<Order> getOrderList() {
        return orderList;
    }
    public List<Transaction> getTransactionList() {
        return transactionList;
    }
    public List<Product> getProductList() {
        return productList;
    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) {
        AdminAction admin = new AdminAction();
        switch (selectedOption) {
            case 1 -> UserValidation.showData();
            case 2 -> admin.viewOrderList(getOrderList());
            case 3 -> admin.viewTransactionList(getTransactionList());
            case 4 -> admin.viewProductList(getProductList());
            case 5 ->logout();
        }
        new Admin();
    }

    private void logout() {
        new LoginPage();
    }

}
