/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.main;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sac
 */
@Stateless
public class UserInfoFacade extends AbstractFacade<UserInfo> {

    @PersistenceContext(unitName = "userManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserInfoFacade() {
        super(UserInfo.class);
    }
    public List<UserInfo>findAllUser(){
        return em.createNamedQuery("UserInfo.findAll").getResultList();
    }
    public List<UserInfo> findByID(String ID){
        try{
            return em.createNativeQuery("SELECT * FROM \"public\".user_info").getResultList();
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
