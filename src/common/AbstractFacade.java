/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author cgomez
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();
    
    public List<T> manyResult(String sql, Map<String, Object> parametros) {
        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS

        Query q = getEntityManager().createNamedQuery(sql);
        if (parametros != null) {
            Iterator i = parametros.entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry valores = (Map.Entry) i.next();
                q.setParameter(valores.getKey().toString(), valores.getValue());
            }
        }
        return ((List<T>) q.getResultList());
    }
    
}
