package model;

import javax.persistence.*;

@Table(name = "Car")
@Entity

public class Car
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private Integer id;

    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @Column(name = "quality", nullable = false)
    private String quality;

    @Column(name = "mpg", nullable = false)
    private String mpg;

    @Column(name = "price", nullable = false)
    private Double price;

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String condition) {
        this.status = condition;
    }

    public String getMpg() {
        return mpg;
    }

    public void setMpg(String mpg) {
        this.mpg = mpg;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
