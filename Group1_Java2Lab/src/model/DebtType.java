package model;

import javax.persistence.*;

@Table
@Entity

public class DebtType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private Integer id;


}
