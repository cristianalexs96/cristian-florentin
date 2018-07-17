import org.junit.Assert;
import org.junit.Test;

public class productTest {
    @Test
    public void createProductTest() {
        product shoes1 = new productInMemory();
        shoes1.setProduct("Shoes 1");
        shoes1.setPrice("15.20");
        Assert.assertEquals("Product: Shoes 1 Price: $15.20", shoes1.showProduct());
    }

    @Test
    public void createMultipleProducts() {
        product shoes1 = new productInMemory();
        shoes1.setProduct("Shoes 1");
        shoes1.setPrice("15.20");
        product shoes2 = new productInMemory();
        shoes2.setProduct("Shoes 2");
        shoes2.setPrice("10.50");
        Assert.assertNotSame(shoes1,shoes2);
    }
}
