/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.main;

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
@Named(value = "loginManagedBean")
@ManagedBean
@RequestScoped
public class LoginManagedBean {
    private String inputTitle = "最初の画面です"; 
    public String getInputTitle() {
        return inputTitle;
    }
    public void setInputTitle(String inputTitle) {
        this.inputTitle = inputTitle;
    }
    
    private String id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    private int age;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    private String msg;
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    private boolean loginFlg;
    public boolean isLoginFlg() {
        return loginFlg;
    }
    public void setLoginFlg(boolean loginFlg) {
        this.loginFlg = loginFlg;
    }
    
    private boolean loginErrFlg = false;
    public boolean isLoginErrFlg() {
        return loginErrFlg;
    }
    public void setLoginErrFlg(boolean loginErrFlg) {
        this.loginErrFlg = loginErrFlg;
    }
    
    
    public LoginManagedBean() {
    }
    
    @Inject 
    UserInfoFacade userInfoFacade;
    
    @PostConstruct
    public void init(){
        this.loginErrFlg = false;
    }
    
    public String login(){
        // IDからユーザー情報を取得しパスワードの照合を行う
        List<UserInfo> userInfoList;
        userInfoList = userInfoFacade.findByID(this.id);
        this.loginFlg = false;
        this.loginErrFlg = false;
        
        if(userInfoList.size() != 1){
            this.loginErrFlg = true;
            return "login.xhtml";
        }
            
        if(userInfoList.get(0).getPassword().equals(this.password)){
            this.loginFlg = true;
            this.loginErrFlg = false;
            return "userList.xhtml";
        }else{
            this.loginErrFlg = true;
            return "login.xhtml";
        }    
    }
    public String moveLoginPage(){
        return "login.xhtml";
    }   
    public String userListloginCheck(){
        if(this.loginFlg)
        {
            return "userList.xhtml";
        }
        return "warning.xhtml";
    }
}
