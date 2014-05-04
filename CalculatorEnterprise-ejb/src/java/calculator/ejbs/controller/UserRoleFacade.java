/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator.ejbs.controller;

import calculator.ejbs.interfaces.UserRoleFacadeLocal;
import calculator.ejbs.entity.UserRole;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alessandro
 */
@Stateless
public class UserRoleFacade extends AbstractFacade<UserRole> implements UserRoleFacadeLocal {
    @PersistenceContext(unitName = "CalculatorEnterprise-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserRoleFacade() {
        super(UserRole.class);
    }
    
}
