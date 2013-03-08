package model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 3/1/13
 * Time: 5:58 PM
 * To change this template use File | Settings | File Templates.
 */
@Table(name="ServiceTerms")
@Entity
@NamedQuery(name = TermsOfService.TERMS_OF_SERVICE_QUERY, query = "SELECT st FROM TermsOfService st")
public class TermsOfService {
    // the query used to retrieve the terms of service from the ServiceTerms table in the database
    public static final String TERMS_OF_SERVICE_QUERY = "model.TermsOfService.termsOfService";

    // the primary key in the ServiceTerms table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int terms_id;

    // the name of the column in the ServiceTerms table
    @Column(name="Terms")
    private String terms;

    // get the terms id from the ServiceTerms table
    public int getTerms_id(){
        return  terms_id;
    }

    // set the terms id in the ServiceTerms table
    public void setTerms_id(int terms_id){
        this.terms_id = terms_id;
    }

    // get the terms from the ServiceTerms table
    public String getTerms(){
        return terms;
    }

    // set the terms in the ServiceTerms table
    public void setTerms(String terms){
        this.terms = terms;
    }
}

