public class productInMemory implements product {

    String name;
    String price;

    public void producInMemory() {
        this.name = "No Name";
        this.price = "00,0";
    }

    public void setProduct(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String showProduct() {
        return ("Product: " + this.name + " Price: $" + this.price);
    }
}
