package cashier;

import Data.*;
import loginPage.LoginPage;

import java.util.List;

public class CashierModel {
    private static final List<String> menuOptions = List.of( "Add products",
            "View Inventory",
            "Update Inventory for selling product",
            "Update Inventory for return product",
            "View Order",
            "View Transaction",
            "Logout");
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

    public List<Product> getProductListFromFile() {
        return productList;
    }

    public void handleOption(int selectedOption) {
        CashierAction cashierAction = new CashierAction();
        switch (selectedOption) {
            case 1 -> cashierAction.addProduct(getProductList());
            case 2 -> ProductsList.showData();
            case 3 -> cashierAction.updateSoldProduct(getProductList(), getTransactionList(), getOrderList());
            case 4 -> cashierAction.updateReturnProduct(getProductList(), getTransactionList());
            case 5 -> OrderList.showData();
            case 6 -> TransactionList.showData();
            case 7 -> logout();
        }
        new Cashier();
    }


    private void logout() {
        new LoginPage();
    }
}
