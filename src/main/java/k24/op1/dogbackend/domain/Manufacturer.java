package k24.op1.dogbackend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity

/* */
public class Manufacturer {
    /*
     * Tämä @GeneratedValue(strategy = GenerationType.IDENTITY)
     * Korvaa; @SequenceGenerator(name = "manufacturer_seq", sequenceName =
     * "manufacturer_seq", allocationSize = 1)
     * Huom. Muutettiin GenerationType.Auto = GenerationType.IDENTITY
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
    @JsonIgnoreProperties("manufacturer")
    private List<Product> products;

    public Manufacturer(String name) {
        this.name = name;
    }

    public Manufacturer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
