package lt.bit.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "descr")
public class Description implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "descript", nullable = false)
    private String descript;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @JoinColumn(name = "plant_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Plant plant;

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
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
      return "Description{descript=" + descript + 
        ", id=" + id + 
        ", plantId=" + plant +
        "}";
    }
}