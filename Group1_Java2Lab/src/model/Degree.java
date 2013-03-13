package model;

import javax.persistence.*;
import java.util.List;

@Table(name = "Degree")
@Entity

public class Degree
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private Integer id;

    @Column(name = "degree", nullable = false, length = 45)
    private String degree;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "salary", nullable = false)
    private Double salary;

//    @OneToMany(mappedBy = "degree")
//    private List<DegreeRegionSalary> degreeRegionSalaries;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String condition) {
        this.degree = condition;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String toString(){
        return degree;
    }
}
