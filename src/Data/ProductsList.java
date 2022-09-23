package Data;

import util.JsonFileHandler;
import util.PrintHandler;
import util.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductsList {

    static String fileName = "inventoryFile.json";
    private static ArrayList<Product> productsList = new ArrayList<>();

    public synchronized static ArrayList<Product> getProductListFromFile() {
        productsList = JsonFileHandler.readInventoryList(fileName);
        return productsList;
    }

    public synchronized static ArrayList<Product> getProductsList() {
        return productsList;
    }

    public synchronized static void setProductList(Product product) {
        productsList.add(product);
        saveProductList();

    }

    public synchronized static void saveProductList() {
        JsonFileHandler.saveProductList(productsList, fileName);
    }

    public synchronized static void updateProductList(int index,int productId, int productQuantity) {
        Product updateProduct = getProductById(productId);
        updateProduct.setQuantity(productQuantity);
        productsList.set(index-1, updateProduct);
        JsonFileHandler.saveProductList(productsList, fileName);
    }

    public static Product getProductById(int requestedId) throws NoSuchElementException {
        Product result = null;
        for (Product item : productsList) {
            int id = item.getId();
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

    public static void showData() {
        generateTable(getProductsList());
        PrintHandler.showGoBackToMainMenu();
    }

    private static void generateTable(List<Product> productsList) {
        List<Integer> columnWidths = List.of(5, 15, 10, 10);
        List<String> headers = List.of("Id", "Product", "Quantity", "Price");
        List<List<String>> body = parseInventory(productsList);
        Table table = new Table(columnWidths, headers, body);
        table.showData();
    }

    private static List<List<String>> parseInventory(List<Product> productsList) {
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


}

