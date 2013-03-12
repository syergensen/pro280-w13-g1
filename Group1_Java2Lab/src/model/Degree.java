package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Degree")
@Entity

public class Degree
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String condition;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @OneToMany(mappedBy = "degree")
    private List<DegreeRegionSalary> degreeRegionSalaries;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String toString(){
        return condition;
    }
}
