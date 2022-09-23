package util;

import Data.Order;
import Data.Product;
import Data.Transaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonFileHandler {


    public static void saveProductList(ArrayList<Product> productList, String filename) {

        JSONObject jproduct = new JSONObject();
        JSONArray jsonArray1 = new JSONArray();

        for (Product item : productList) {
            jproduct.put("productId", item.getId());
            jproduct.put("productName", item.getName());
            jproduct.put("productQuantity", item.getQuantity());
            jproduct.put("productPrice", item.getPrice());

        }
        jsonArray1.add(jproduct);
        JSONParser jsonparser = new JSONParser();
        try (FileReader reader = new FileReader(filename)) {

            JSONArray jsonArray2 = (JSONArray) jsonparser.parse(reader);
            jsonArray2.add(jproduct);
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(jsonArray2.toJSONString());
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Product> readInventoryList(String filename) {
        ArrayList<Product> result = new ArrayList<>();
        JSONParser jsonparser = new JSONParser();
        try (FileReader reader = new FileReader(filename)) {

            JSONArray jsonArray = (JSONArray) jsonparser.parse(reader);
            for (Object object : jsonArray) {
                JSONObject product = (JSONObject) object;
                int id = Integer.parseInt(String.valueOf(product.get("productId")));
                String name = String.valueOf(product.get("productName"));
                int productQuantity = Integer.parseInt(String.valueOf(product.get("productQuantity")));
                double price = Double.parseDouble(String.valueOf(product.get("productPrice")));
                Product data = new Product(id, name, price, productQuantity);
                result.add(data);
            }

            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveTransactionList(ArrayList<Transaction> transactionList, String filename) {

        JSONObject jTransaction = new JSONObject();
        JSONArray jsonArray1 = new JSONArray();
        for (Transaction item : transactionList) {
            jTransaction.put("Index", item.getIndex());
            jTransaction.put("TransactionId", item.getTransactionId());
            jTransaction.put("productName", item.getProductName());
            jTransaction.put("productQuantity", item.getProductQuantity());
            jTransaction.put("productPrice", item.getProductPrice());
            jTransaction.put("customerName", item.getCustomerName());
            jTransaction.put("modeOfPayment", item.getModeOfPayment());

        }
        jsonArray1.add(jTransaction);
        JSONParser jsonparser = new JSONParser();
        try (FileReader reader = new FileReader(filename)) {

            JSONArray jsonArray2 = (JSONArray) jsonparser.parse(reader);
            jsonArray2.add(jTransaction);
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(jsonArray2.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveOrderList(ArrayList<Order> orderList, String filename) {
        JSONObject jorder = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Order item : orderList) {
            jorder.put("index", item.getIndex());
            jorder.put("orderNo", item.getOrderNo());
            jorder.put("productName", item.getProductName());
            jorder.put("productQuantity", item.getProductQuantity());
            jorder.put("companyName", item.getCompanyName());
            jorder.put("approvalStatus", item.getApprovalStatus());

        }
        jsonArray.add(jorder);
        JSONParser jsonparser = new JSONParser();
        try (FileReader reader = new FileReader(filename)) {
            JSONArray jsonArray2 = (JSONArray) jsonparser.parse(reader);
            jsonArray2.add(jorder);
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(jsonArray2.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Order> readOrderList(String filename) {
        ArrayList<Order> result = new ArrayList<>();
        JSONParser jsonparser = new JSONParser();
        try (FileReader reader = new FileReader(filename)) {

            JSONArray jsonArray = (JSONArray) jsonparser.parse(reader);
            for (Object object : jsonArray) {
                JSONObject order = (JSONObject) object;
                int index = Integer.parseInt(String.valueOf(order.get("index")));
                int orderNo = Integer.parseInt(String.valueOf(order.get("orderNo")));
                String name = String.valueOf(order.get("productName"));
                int productQuantity = Integer.parseInt(String.valueOf(order.get("productQuantity")));
                String companyName = String.valueOf(order.get("companyName"));
                String approvalStatus = String.valueOf(order.get("approvalStatus"));
                Order data = new Order(index, orderNo, name, productQuantity, companyName, approvalStatus);
                result.add(data);
            }

            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Transaction> readTransactionList(String filename) {
        ArrayList<Transaction> result = new ArrayList<>();
        JSONParser jsonparser = new JSONParser();
        try (FileReader reader = new FileReader(filename)) {

            JSONArray jsonArray = (JSONArray) jsonparser.parse(reader);
            for (Object object : jsonArray) {
                JSONObject transaction = (JSONObject) object;
                int index = Integer.parseInt(String.valueOf(transaction.get("Index")));
                int transactionId = Integer.parseInt(String.valueOf(transaction.get("TransactionId")));
                String name = String.valueOf(transaction.get("productName"));
                int productQuantity = Integer.parseInt(String.valueOf(transaction.get("productQuantity")));
                double price = Double.parseDouble(String.valueOf(transaction.get("productPrice")));
                String customerName = String.valueOf(transaction.get("customerName"));
                String payement = String.valueOf(transaction.get("modeOfPayment"));
                Transaction data = new Transaction(index, transactionId, name, productQuantity, price, customerName, payement);
                result.add(data);
            }

            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
