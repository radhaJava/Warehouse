package Data;

public class Transaction {


    private final String productName;
    private final double productPrice;
    private final int productQuantity;
    private final String customerName;
    private final String modeOfPayment;
    private int index;
    private int transactionId;


    public Transaction(int index, int transactionId, String name, int quantity,
                       double price, String customerName, String modeOfPayment) {
        this.index = index;
        this.transactionId = transactionId;
        this.productName = name;
        this.productQuantity = quantity;
        this.productPrice = price;
        this.customerName = customerName;
        this.modeOfPayment = modeOfPayment;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
