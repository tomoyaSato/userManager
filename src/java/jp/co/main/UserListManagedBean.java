/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import javax.inject.Named;
import org.apache.jasper.tagplugins.jstl.ForEach;


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
   
    @Inject 
    UserInfoFacade userInfoFacade;
    
    public UserListManagedBean() {
        setUserInfoList();
    }
    private void setUserInfoList(){
        userDataList = new ArrayList<>();
        List<UserInfo> userInfoList;
        try{
            userInfoList = userInfoFacade.findByDeleteFlg(false);
        }
        catch(Exception ex){
            throw ex;
        }
        userInfoList.stream().forEach((UserInfo userInfo) -> {
            userDataList.add(new userListTableBean(userInfo.getId(), userInfo.getName()));
        });
    }
}
