package lt.bit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "desc")
public class Description implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "description")
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

 
    @JoinColumn(name = "plant_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Plant plant;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setPlan(Plant plant) {
        this.plant = plant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Description)) return false;
        Description that = (Description) o;
        return Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPlant(), that.getPlant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getId(), getPlant());
    }

    @Override
    public String toString() {
        return "Description{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", plant=" + plant +
                '}';
    }
}