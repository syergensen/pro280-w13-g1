package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Degree_Region_Salary")
@Entity
public class DegreeRegionSalary
{
    @Id
    @ManyToOne
    @JoinColumn(name = "degree_id")
    private Degree degree;

    @Id
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(name = "salary")
    private Double salary;

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
