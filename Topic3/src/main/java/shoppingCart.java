import java.util.ArrayList;

public interface shoppingCart {
    String buy ();
    void addProduct(product product);
    void deleteProduct (product product);
    ArrayList showCart();
}
