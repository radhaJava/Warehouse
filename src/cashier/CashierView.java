package cashier;

import Data.Product;
import util.PrintHandler;
import util.Table;

import java.util.ArrayList;
import java.util.List;

public class CashierView {
    public CashierView(List<Product> productListFromFile, List<String> menuOptions) {
        PrintHandler.clearScreen();
        PrintHandler.showAppHeader();
        PrintHandler.showEmptyLine();
        showData(productListFromFile,menuOptions);
    }

    public void showPrompt() {
        System.out.print("Choose an option and then press enter: ");
    }
    public void showData(List<Product> productsList,List<String> menuOptions) {

        generateTable(productsList);
        showPrompt(menuOptions);
    }
    private void generateTable(List<Product> productsList) {
        List<Integer> columnWidths = List.of(5, 15, 10, 10);
        List<String> headers = List.of("Id", "Product", "Quantity", "Price");
        List<List<String>> body = parseInventory(productsList);
        Table table = new Table(columnWidths, headers, body);
        table.showData();
    }

    private List<List<String>> parseInventory(List<Product> productsList) {
        List<List<String>> result = new ArrayList<>();

        for (Product item : productsList) {
            String id = String.valueOf(item.getId());
            String name = item.getName();
            String productQuantity = String.valueOf(item.getQuantity());
            String price = String.valueOf(item.getPrice());
            List<String> data = List.of(id, name, productQuantity, price);
            result.add(data);
        }

        return result;
    }
    public void showPrompt(List<String> menuOptions) {
        PrintHandler.showMenuOptions(menuOptions);
        System.out.print("Choose an option and then press enter: ");
    }


}
