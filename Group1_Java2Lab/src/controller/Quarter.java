package controller;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: acottrill
 * Date: 3/1/13
 * Time: 11:52 AM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "Quarter")
@Entity
@NamedQuery(name = "controller.Quarter.getAll", query = "SELECT p FROM Quarter p")
public class Quarter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    public String getName(){
        return name;
    }
}
