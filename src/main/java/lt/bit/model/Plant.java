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
    private Boolean plantType;

    @Column(name = "price")
    private Float price = 0F;


    //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plant")
//    @JoinColumn(name = "plant_id", referencedColumnName = "id")
//    @Transient
    @OneToOne(mappedBy = "plant", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Description descript;

    public Description getDescript() {
        return descript;
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
    public String toString() {
        return "Plant{" +
                "amount=" + amount +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", plantType=" + plantType +
                ", price=" + price +
                ", description=" + descript +
                '}';
    }


}