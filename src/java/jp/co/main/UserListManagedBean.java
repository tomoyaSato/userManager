/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.main;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import javax.inject.Named;


/**
 *
 * @author sac
 */
@Named(value = "userListManagedBean")
@ManagedBean
@RequestScoped
public class UserListManagedBean {
       /**
     * Creates a new instance of UserListManagedBean
     */
    private List<userListTableBean> userDataList = null;
    public List<userListTableBean> getUserDataList() {
        return userDataList;
    }
    public void setUserDataList(List<userListTableBean> userDataList) {
        this.userDataList = userDataList;
    }
    
    public UserListManagedBean() {
        userDataList = new ArrayList<>();

        userDataList.add(new userListTableBean(false,"00001", "えんぴつ"));
        userDataList.add(new userListTableBean(false,"00002", "けしごむ"));
        userDataList.add(new userListTableBean(false,"00003", "ノート"));
    }
}
