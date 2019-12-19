package app;

public class Product {
    private int id;
    private String serialNumber;
    private String name;
    private String description;
    private float price;
    private int stock;
    private int weight;
    private String picture;
    private int brand;

    public Product (int id, String serialNumber, String name, String description, float price, int stock, int weight, String picture, int brand) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.weight = weight;
        this.picture = picture;
        this.brand = brand;
    }

    
}