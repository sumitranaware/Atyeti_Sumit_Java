package model;

public class Sales {
    private String date;
    private String product;
    private String category;
    private int quantity;
    private double unitPrice;
    private String region;

    public Sales() {
    }

    public Sales(String date, String product, String category, int quantity, double unitPrice, String region) {
        this.date = date;
        this.product = product;
        this.category = category;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "date='" + date + '\'' +
                ", product='" + product + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", region='" + region + '\'' +
                '}';
    }
}
