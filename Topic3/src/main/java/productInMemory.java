/**
 * The productInMemory Class represents a product thats
 * going to be created in the memory
 * @author CRISTIAN
 */
public class productInMemory implements product {

    String name;
    String price;

    /**
     * sets the default values of "name" and "price".
     *
     */

    public void productInMemory() {
        this.name = "No Name";
        this.price = "00,0";
    }

    /**
     * Sets a String value to "name"
     *
     * @param name the new name of the product.
     */

    public void setProduct(String name) {
        this.name = name;
    }

    /**
     * Sets a String value to "price"
     *
     * @param price the new price of the product.
     */

    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Sets a String value to "name"
     *
     * @return A String with the description of the product.
     */

    public String showProduct() {
        return ("Product: " + this.name + " Price: $" + this.price);
    }
}
