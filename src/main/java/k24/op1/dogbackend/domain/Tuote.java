package k24.op1.dogbackend.domain;

public class Tuote {
    private String name;
    private String description;
    private String type;
    private String color;
    private String size;
    private double price;
    private String manufacturer;

    public Tuote() {}

    public Tuote(String name, String description, String type, String color, String size, double price,
            String manufacturer) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.color = color;
        this.size = size;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    
}
