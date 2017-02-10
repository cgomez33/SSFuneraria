/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author cgomez
 */
public abstract class AbstractController {
     protected EntityManagerFactory emf;

    protected EntityManager getEntityManager(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("SI_FunerariaPU");
        }
        return emf.createEntityManager();
    }
}
