package k24.op1.dogbackend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;
    private String businessid;

    public Manufacturer() {

    }

    public Manufacturer(String name, String country, String businessid) {

        this.name = name;
        this.country = country;
        this.businessid = businessid;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBusinessid() {
        return businessid;
    }

    public void setBusinessid(String businessid) {
        this.businessid = businessid;
    }

    @Override
    public String toString() {
        return "Manufacturer [id=" + id + ", name=" + name + ", country=" + country + ", businessid=" + businessid
                + "]";
    }

}
