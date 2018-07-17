import java.util.ArrayList;

public class shoppingCartInMemory implements shoppingCart {
    Boolean status = Boolean.FALSE;
    ArrayList cart = new ArrayList();

    public String buy() {
        if (this.cart.size() == 0) {
            return "Your shopping cart is empty";
        }
        else{
            return "Purchase successful";
        }

    }

    public void addProduct(product product) {
        this.cart.add(product);
    }

    public void deleteProduct(product product) {
        this.cart.remove(product);
    }

    public ArrayList showCart() {
        return this.cart;
    }
}
