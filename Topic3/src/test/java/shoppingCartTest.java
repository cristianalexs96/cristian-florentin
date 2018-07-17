import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class shoppingCartTest {

    @Test
    void createShoppingCartTest() {
        shoppingCart cart = new shoppingCartInMemory();
        Assert.assertEquals(new ArrayList(), cart.showCart());
    }

    @Test
    void addProductToSCTest() {
        shoppingCart cart = new shoppingCartInMemory();
        product shoes1 = new productInMemory();
        shoes1.setProduct("Shoes");
        shoes1.setPrice("20.0");
        cart.addProduct(shoes1);
        Assert.assertTrue(cart.showCart().size() != 0);
    }

    @Test
    void removeProductToSCTest() {
        shoppingCart cart = new shoppingCartInMemory();
        product shoes1 = new productInMemory();
        shoes1.setProduct("Shoes");
        shoes1.setPrice("20.0");
        cart.addProduct(shoes1);
        Assert.assertTrue(cart.showCart().size() != 0);
        cart.deleteProduct(shoes1);
        Assert.assertTrue(cart.showCart().size() == 0);
    }

    @Test
    void buyEmptyCartTest() {
        shoppingCart cart = new shoppingCartInMemory();
        Assert.assertEquals("Your shopping cart is empty", cart.buy());
    }

    @Test
    void buyCartTest() {
        shoppingCart cart = new shoppingCartInMemory();
        product shoes1 = new productInMemory();
        shoes1.setProduct("Shoes");
        shoes1.setPrice("20.0");
        cart.addProduct(shoes1);
        Assert.assertEquals("Purchase successful", cart.buy());
    }
}
