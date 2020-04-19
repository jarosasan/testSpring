package lt.bit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "descr")
public class Description implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "descript", nullable = false)
    private String descripto;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plant_id", referencedColumnName = "id")
    private Plant plant;


    public Description() {
    }

    public String getDescripto() {
        return descripto;
    }

    public void setDescripto(String descripto) {
        this.descripto = descripto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public String toString() {
        return "Description{descript=" + descripto +
                ", id=" + id +
                ", plantId=" + plant +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Description)) return false;
        Description that = (Description) o;
        return Objects.equals(getDescripto(), that.getDescripto()) &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPlant(), that.getPlant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescripto(), getId(), getPlant());
    }


}