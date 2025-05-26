package ed.lab.ed1labo04.model;

public class UpdateProductRequest {
    Double price;
    int quantity;

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
