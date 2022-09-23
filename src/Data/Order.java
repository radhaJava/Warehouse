package Data;

public class Order {
    private final int index;
    private final int orderNo;
    private final String productName;
    private final int productQuantity;
    private final String companyName;
    private String approvalStatus;

    public Order(int index, int orderNo, String productName, int productQuantity, String companyName, String approvalStatus) {
        this.index = index;
        this.orderNo = orderNo;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.companyName = companyName;
        this.approvalStatus = approvalStatus;
    }

    public int getIndex() {
        return index;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }


}

