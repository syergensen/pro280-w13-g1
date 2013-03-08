package manager;

import model.TermsOfService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 3/1/13
 * Time: 5:54 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@LocalBean
public class TermsManager {
    @PersistenceContext
    EntityManager em;

    // get all terms in the ServiceTerms table
    public TermsOfService getTerms(){
        TypedQuery<TermsOfService> termsQuery = em.createNamedQuery(TermsOfService.TERMS_OF_SERVICE_QUERY, TermsOfService.class);
        return termsQuery.getSingleResult();
    }

    // get terms by id
    public TermsOfService getTerms(int id){
        return em.find(TermsOfService.class, id);
    }

    // create a new term in the ServiceTerms table
    public TermsOfService create(TermsOfService terms){
        em.persist(terms);
        return terms;
    }

    // update a term already in the ServiceTerms table
    public TermsOfService update(TermsOfService terms){
        em.merge(terms);
        return terms;
    }

    // delete a term from the ServiceTerms table
    public void delete(int id){
        em.remove(getTerms(id));
    }
}
