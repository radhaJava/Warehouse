package Data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class OrderTest {



    @Test
    @DisplayName("check order no")
    void testOrder() {
        Order order = new Order(2,23,"orange",2,"orangeFarm","created");

        assertEquals(23,order.getOrderNo());
        assertNotEquals(2,order.getOrderNo());
        assertEquals("orange",order.getProductName());
        assertEquals("created",order.getApprovalStatus());
        order.setApprovalStatus("approved");
        assertEquals("approved",order.getApprovalStatus());
    }


}