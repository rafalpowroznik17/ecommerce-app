package pl.rpow.productcatalog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SqlProductStorageTest {

    @Test
    void itStoreAndLoadProduct() {
        ProductStorage sqlProductStorage = new SqlProductStorage();
        ProductData sampleProduct = thereIsSampleProductData();

        sqlProductStorage.save(sampleProduct);

        ProductData loaded = sqlProductStorage.load(sampleProduct.getId());

        assertEquals(sampleProduct.getName(), loaded.getName());
    }

    private ProductData thereIsSampleProductData() {
        return new ProductData("lego-1", "nice one");
    }
}
