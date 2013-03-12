package model;

import javax.persistence.*;

@Table(name = "Misc")
@Entity

public class Misc
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private Integer id;

    @Column(name = "misc", nullable = false, length = 45)
    private String misc;

    @Column(name = "cost", nullable = false)
    private Double cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String name) {
        this.misc = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
