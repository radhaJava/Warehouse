package cashier;
/*

Cashier action do update when they sell product and update transaction,
or create order if there is less numb of product then selling product
he can also add product if he gets new products


 */

import Data.*;
import util.PrintHandler;

import java.util.List;
import java.util.Random;

public class CashierAction {

    public synchronized void updateSoldProduct(List<Product> productList, List<Transaction> transactionList, List<Order> orderList) {

        Random random = new Random();

        int productId = getProductId();
        int sellingQuantity = getSellingQuantity();
        int index = productId - 1;
        Product selectedProduct = productList.get(index);
        int productListQuantity = selectedProduct.getQuantity();
        if (productListQuantity - sellingQuantity > 1) {
            sellProduct(transactionList, random, productId, sellingQuantity, selectedProduct, productListQuantity);
        } else {
            createOrder(orderList, random, sellingQuantity, selectedProduct, productListQuantity);
        }

    }

    private void sellProduct(List<Transaction> transactionList, Random random, int productId, int sellingQuantity, Product selectedProduct, int productListQuantity) {
        String name = getCustomerName();
        String payment = getPaymentType();
        ProductsList.updateProductList(productId,productId, productListQuantity - sellingQuantity);
        int id = transactionList.size();
        int transactionId = random.nextInt(900) + 100;
        Transaction transaction = new Transaction(id, transactionId, selectedProduct.getName(), sellingQuantity, selectedProduct.getPrice(), name, payment);
        TransactionList.createTransactionList(transaction);

    }

    private void createOrder(List<Order> orderList, Random random, int sellingQuantity, Product selectedProduct, int productListQuantity) {
        System.out.println("Inform customer .....soon we update the products");
        String companyName = "MarketPlace";
        int quantity = productListQuantity + sellingQuantity;
        String status = "created";
        int id = orderList.size();
        int orderNo = random.nextInt(900) + 100;
        Order order = new Order(id, orderNo, selectedProduct.getName(), quantity, companyName, status);
        OrderList.createOrderList(order);

    }

    private String getPaymentType() {
        System.out.print("Enter tha mode of payment :");
        return PrintHandler.scanUserInputString();
    }

    private String getCustomerName() {
        System.out.print("Enter /ask customer Name for Billing : ");
        return PrintHandler.scanUserInputString();
    }

    private int getSellingQuantity() {
        System.out.print("Enter the quantity of the product which the customer choose to purchase: ");
        return Integer.parseInt(PrintHandler.scanUserInputString());
    }

    private int getProductId() {
        System.out.print("Enter the product the index which the customer choose to purchase :");
        return Integer.parseInt(PrintHandler.scanUserInputString());
    }

    public synchronized void updateReturnProduct(List<Product> productList, List<Transaction> transactionList) {

        int index = getIndex();
        int enteredTNumber = getTransactionNumber();
        int returnedQuantity = TransactionList.getTransactionById(enteredTNumber).getProductQuantity();
        int currentQuantity = ProductsList.getProductById(index).getQuantity();
        String productName = ProductsList.getProductById(index).getName();
        int setQuantity = returnedQuantity + currentQuantity;
        int productId = ProductsList.getProductById(index).getId();
        int transactionId = TransactionList.getTransactionById(enteredTNumber).getTransactionId();
        if (TransactionList.getTransactionById(enteredTNumber).getProductName().equals(productName)) {
            ProductsList.updateProductList(index ,productId, setQuantity);
            TransactionList.updateTransactionList(transactionId);
        } else {
            System.out.println(" The transaction number entered is not a valid one");
        }


    }

    private int getTransactionNumber() {
        System.out.print("Ask receipt/transaction id number of the purchase");
        return Integer.parseInt(PrintHandler.scanUserInputString());
    }

    private int getIndex() {
        System.out.print("Enter the  product id which the customer want to return:");
        return Integer.parseInt(PrintHandler.scanUserInputString());
    }


    public void addProduct(List<Product> productList) {
        boolean loop;
        System.out.println("Enter new product details");
        do {
            String productName = getProductName();
            double productPrice = getProductPrice();
            int quantity = getProductQuantity();
            int index = productList.size();
            Product product = new Product(index + 1, productName, productPrice, quantity);
            ProductsList.setProductList(product);
            System.out.print("Do you wish to add more products :");
            loop = PrintHandler.scanUserInputBoolean();
        } while (loop);

    }

    private int getProductQuantity() {
        System.out.print("Enter product quantity :");
        return Integer.parseInt(PrintHandler.scanUserInputString());
    }

    private double getProductPrice() {
        System.out.print("Enter product price :");
        return Double.parseDouble(PrintHandler.scanUserInputString());
    }

    private String getProductName() {
        System.out.print("Enter the product name :");
        return PrintHandler.scanUserInputString();
    }

}
