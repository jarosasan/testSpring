package lt.bit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "plants")
public class Plant implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "amount")
    private Integer amount = 0;

    @OneToOne(mappedBy = "plant", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Description description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "plant_type", nullable = false)
    private Boolean plantType;

    @Column(name = "price")
    private Float price = 0F;

    public Plant() {
    }


    public Plant(Description description){
        this.description = description;
    }

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

    public Boolean getPlantType() {
        return plantType;
    }

    public void setPlantType(Boolean plantType) {
        this.plantType = plantType;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plant)) return false;
        Plant plant = (Plant) o;
        return Objects.equals(getAmount(), plant.getAmount()) &&
                Objects.equals(getDescription(), plant.getDescription()) &&
                Objects.equals(getId(), plant.getId()) &&
                Objects.equals(getName(), plant.getName()) &&
                Objects.equals(getPlantType(), plant.getPlantType()) &&
                Objects.equals(getPrice(), plant.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), getDescription(), getId(), getName(), getPlantType(), getPrice());
    }

    @Override
    public String toString() {
        return "Plant{" +
                "amount=" + amount +
                ", description="  +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", plantType=" + plantType +
                ", price=" + price +
                '}';
    }
}