/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thamess
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication2PU");

    /**
     * This is a sample web service operation
     */
    

     private void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findCovidById")
    public Coviddata findCovidById(@WebParam(name = "id") Integer id) {
        EntityManager em = emf.createEntityManager();
        Coviddata co = em.find(Coviddata.class, id);
        return co;
    }
    
}
