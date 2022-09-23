package Data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getId() {
        Product product = new Product(1,"rose",34.2,34);
        assertEquals("rose",product.getName());
    }


}