import java.util.ArrayList;
/**
 * The shoppingCart Interface represents an abstract Shopping Cart
 * @author CRISTIAN
 */

public interface shoppingCart {
    String buy ();
    void addProduct(product product);
    void deleteProduct (product product);
    ArrayList showCart();
}
