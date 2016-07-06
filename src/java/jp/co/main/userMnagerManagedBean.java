/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.main;

import javax.activation.DataSource;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

/**
 *
 * @author sac
 */
@Named(value = "userMnagerManagedBean")
@ManagedBean
@RequestScoped
public class userMnagerManagedBean {
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
    
    public userMnagerManagedBean() {
    }
    
    @PostConstruct
    public void init(){
    }
    public String send(){		
        this.msg =  this.name + "は" + String.valueOf(this.age)  + "歳です。";	
        return "output.xhtml";
    }
    
    public String login(){
        UserInfo _userInfo = new UserInfo();
        String userId =  _userInfo.getId();
        return "output.xhtml";
    }
    
}
