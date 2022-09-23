package admin;

import Data.*;

import java.util.List;

public class AdminAction {

    public void viewOrderList(List<Order> orderList) {
        OrderList.showData();

    }

    public void viewTransactionList(List<Transaction> transactionList) {
        TransactionList.showData();

    }

    public void viewProductList(List<Product> productList) {
        ProductsList.showData();

    }
}
