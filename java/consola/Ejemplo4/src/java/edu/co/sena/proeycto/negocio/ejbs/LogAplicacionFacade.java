/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.proeycto.negocio.ejbs;

import edu.co.sena.proeycto.integracion.entities.LogAplicacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hernando
 */
@Stateless
public class LogAplicacionFacade extends AbstractFacade<LogAplicacion> implements LogAplicacionFacadeLocal {

    @PersistenceContext(unitName = "Ejemplo4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LogAplicacionFacade() {
        super(LogAplicacion.class);
    }
    
}
