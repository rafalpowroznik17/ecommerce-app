package pl.rpow.productcatalog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListProductStorageTest {
    @Test
    void isStorageAndLoadProduct() {
        ProductStorage listStorage = new ListProductStorage();
        ProductData productData = thereIsExampleProduct();

        listStorage.save(productData);
        ProductData loaded = listStorage.load(productData.getId());
        assertEquals(productData.getId(), loaded.getId());
        assertEquals(productData.getName(), loaded.getName());
    }

    private ProductData thereIsExampleProduct() {
        return new ProductData("lego-1", "nice set");
    }
}
