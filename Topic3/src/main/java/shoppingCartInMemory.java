import java.util.ArrayList;

/**
 * The shoppingCartInMemory Class represents a shopping cart that's
 * going to be created in the memory
 * @author CRISTIAN
 */

public class shoppingCartInMemory implements shoppingCart {
    ArrayList cart = new ArrayList();

    /**
     * it shows the purchase operation of the shopping cart
     * @return A string with the operation according the status
     * of the shopping cart
     */

    public String buy() {
        if (this.cart.size() == 0) {
            return "Your shopping cart is empty";
        }
        else{
            return "Purchase successful";
        }

    }

    /**
     * Adds a product to the shopping cart
     * @param product product class to add
     */

    public void addProduct(product product) {
        this.cart.add(product);
    }

    /**
     * Deletes a product to the shopping cart
     * @param product product class to delete
     */

    public void deleteProduct(product product) {
        this.cart.remove(product);
    }

    /**
     * Shows the products of the Shopping Cart
     * @return An ArrayList with the Shopping cart products
     */

    public ArrayList showCart() {
        return this.cart;
    }
}
