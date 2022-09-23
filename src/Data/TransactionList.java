package Data;

import util.JsonFileHandler;
import util.PrintHandler;
import util.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TransactionList {
    static String filename ="transactionFile.json";
    private static ArrayList<Transaction> transactionList = new ArrayList<>();
    public synchronized static ArrayList<Transaction> getTransactionListFromFile() {
        String fileName ="transactionFile.json";
        transactionList= JsonFileHandler.readTransactionList(fileName);
        return transactionList;


    }
    public static ArrayList<Transaction> getTransactionList(){
        return transactionList;
    }
    public synchronized static void saveTransactionList(){
         JsonFileHandler.saveTransactionList(transactionList,filename);
    }

    public synchronized static void updateTransactionList(int transactionId) {
        Transaction updateTransaction =getTransactionById(transactionId);
        transactionList.remove(transactionId-1);
        saveTransactionList();

    }
    public static Transaction getTransactionById(int requestedId) throws NoSuchElementException {
        Transaction result = null;

        for (Transaction item : transactionList) {
            int id = item.getTransactionId();
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



    public static void createTransactionList(Transaction transaction) {
        transactionList.add(transaction);
        saveTransactionList();
    }

    public synchronized static void showData() {
        generateTable(getTransactionList());
        PrintHandler.showGoBackToMainMenu();
    }

    private static void generateTable(List<Transaction> transactionList) {
        List<Integer> columnWidths = List.of(5,15,15, 15, 15,15,15);
        List<String> headers = List.of("Index","Transaction Id","Product", "Quantity", "Price","CustomerName","Payment Type");
        List<List<String>> body = parseInventory(transactionList);
        Table table = new Table(columnWidths, headers, body);
        table.showData();
    }

    private static List<List<String>> parseInventory(List<Transaction> transactionList) {
        List<List<String>>result = new ArrayList<>();

        for (Transaction item : transactionList) {
            String index = String.valueOf(item.getIndex());
            String transactionId = String.valueOf(item.getTransactionId());
            String name = item.getProductName();
            String productQuantity = String.valueOf(item.getProductQuantity());
            String price = String.valueOf(item.getProductPrice());
            String customerName= item.getCustomerName();
            String payment = item.getModeOfPayment();
            List<String> data = List.of(index,transactionId,name, productQuantity, price,customerName,payment);
            result.add(data);
        }

        return result;
    }


}
