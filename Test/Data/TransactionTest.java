package Data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {


    Transaction transaction = new Transaction(1,46,"orange",5,32,"Ravi","card");
   @Test
   @DisplayName("change transaction number set and get")
    void setUp() {
        transaction.setTransactionId(23);
        assertEquals(23,transaction.getTransactionId());
    }

    @Test
    @DisplayName("check transaction  id  in not equal and quantity ")
    void getProductQuantity() {
       assertEquals(5,transaction.getProductQuantity());
       assertNotEquals(7,transaction.getTransactionId());
    }


}