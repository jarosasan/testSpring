package lt.bit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "plants")
@Entity
public class Plant implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "amount")
    private Integer amount = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "plant_type")
    private Integer plantType = 0;

    @Column(name = "price")
    private Float price = 0F;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "plant")
    private Description description;

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }



    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlantType() {
        return plantType;
    }

    public void setPlantType(Integer plantType) {
        this.plantType = plantType;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String toString() {
      return "Plants{amount=" + amount + 
        ", id=" + id + 
        ", name=" + name + 
        ", plantType=" + plantType + 
        ", price=" + price + 
        "}";
    }
}