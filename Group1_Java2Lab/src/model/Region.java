package model;

import javax.persistence.*;
import java.util.List;

@Table(name = "Region")
@Entity

public class Region
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private Integer id;

    @Column(name = "region", nullable = false, length = 45)
    private String name;

    @Column(name = "rent",  nullable = false)
    private Double rent;

    @Column(name = "housing", nullable = false)
    private Double housing;

    @OneToMany(mappedBy = "region")
    private List<DegreeRegionSalary> degreeRegionSalaries;

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

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public Double getHousing() {
        return housing;
    }

    public void setHousing(Double housing) {
        this.housing = housing;
    }
}
