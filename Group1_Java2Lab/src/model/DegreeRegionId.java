package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DegreeRegionId implements Serializable
{
    @Column(name = "degree_id")
    private Integer degreeId;

    @Column(name = "region_id")
    private Integer regionId;
}
