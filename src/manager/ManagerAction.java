package manager;

import Data.Order;
import Data.OrderList;

import java.util.List;

public class ManagerAction {
    public void viewOderList(List<Order> orderList) {
        OrderList.showData();
    }

    public void approveOrderList(List<Order> orderList) {
        OrderList.updateOrderList();
    }
}
