/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.main;

import java.util.Date;
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
//            return em.createNativeQuery("SELECT * FROM \"public\".user_info").getResultList();
            return em.createNamedQuery("UserInfo.findById").setParameter("id", ID).getResultList();
        }
        catch(Exception ex){
            throw ex;
        }
    }
    public List<UserInfo> findByDeleteFlg(boolean deleteFlg){
        try{
            return em.createNamedQuery("UserInfo.findByDeleteFlg").setParameter("deleteFlg", deleteFlg).getResultList();
        }catch(Exception ex){
            throw ex;
        }
    }
    //新規追加
    public void insert(UserInfo userInfoParam) {
//        em.getTransaction().begin();
        em.persist(userInfoParam);
//        em.getTransaction().commit();
    }
    
    // 更新
    public void update(UserInfo userInfoParam){
//        em.getTransaction().begin();
        em.merge(userInfoParam);
//        em.getTransaction().commit();
    }
    public String getNewId(){
        Object id = em.createNamedQuery("UserInfo.getMaxId").getSingleResult();            
        int idInt = Integer.valueOf(id.toString()) + 1;
        String idStr = String.format("%1$5d", idInt);
        return idStr;
    }
}
