package Data;

import util.JsonFileHandler;
import util.PrintHandler;
import util.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class OrderList {
    static String fileName = "OrderFile.json";
    private static ArrayList<Order> orderList = new ArrayList<>();

    public synchronized static ArrayList<Order> getOrderListFromFile() {
        orderList = JsonFileHandler.readOrderList(fileName);
        return orderList;
    }

    public static ArrayList<Order> getOrderList() {
        return orderList;
    }

    public synchronized static void updateOrderList() {
        int requestedId = getOrderNumber();
        Order updateOrder = getProductById(requestedId);
        updateOrder.setApprovalStatus("approved");
        orderList.set(requestedId-1, updateOrder);
        saveOrderList();
    }

    private static int getOrderNumber() {
        System.out.print("To approve the orders enter the index number : ");
        return Integer.parseInt(PrintHandler.scanUserInputString());
    }

    public static Order getProductById(int requestedId) throws NoSuchElementException {
        Order result = null;
        for (Order item : orderList) {
            int id = item.getIndex();
            if (id == requestedId) {
                result = item;
                break;
            }
        }
        // Safeguard
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    public static void saveOrderList() {
        JsonFileHandler.saveOrderList(orderList, fileName);
    }

    public static void createOrderList(Order order) {
        orderList.add(order);
        saveOrderList();
    }

    public static void showData() {
        generateTable(getOrderList());
        PrintHandler.showGoBackToMainMenu();
    }

    private static void generateTable(List<Order> orderList) {
        List<Integer> columnWidths = List.of(5, 5, 15, 15, 15, 15);
        List<String> headers = List.of("Index", "OrderNo", "Product Name ", "Quantity", "Company Name", "Order Status");
        List<List<String>> body = parseInventory(orderList);
        Table table = new Table(columnWidths, headers, body);
        table.showData();
    }

    private static List<List<String>> parseInventory(List<Order> orderList) {
        List<List<String>> result = new ArrayList<>();

        for (Order item : orderList) {
            String index = String.valueOf(item.getIndex());
            String orderNo = String.valueOf(item.getOrderNo());
            String name = item.getProductName();
            String productQuantity = String.valueOf(item.getProductQuantity());
            String companyName = item.getCompanyName();
            String orderStatus = item.getApprovalStatus();
            List<String> data = List.of(index, orderNo, name, productQuantity, companyName, orderStatus);
            result.add(data);
        }

        return result;
    }

}

