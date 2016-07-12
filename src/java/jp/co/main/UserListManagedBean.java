/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.main;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author sac
 */
@Named(value = "userListManagedBean")
@RequestScoped
public class UserListManagedBean {
    
    @Inject 
    UserInfoFacade userInfoFacade;
    
    private List<userListTableBean> userDataList = null;
    public List<userListTableBean> getUserDataList() {
        return userDataList;
    }
    public void setUserDataList(List<userListTableBean> userDataList) {
        this.userDataList = userDataList;
    }
   
    private String testStr;

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
    
    
    @PostConstruct
    public void init(){
        setUserInfoList();
    }
    
    public UserListManagedBean() {
    }
    private void setUserInfoList(){
        userDataList = new ArrayList<>();
        List<UserInfo> userInfoList;
        try{
            // 削除されてないユーザーを全て取得する
            userInfoList = userInfoFacade.findByDeleteFlg(false);
        }
        catch(Exception ex){
            throw ex;
        }
        // 画面ユーザー一覧表示用リストへデータをセット
        userInfoList.stream().forEach((UserInfo userInfo) -> {
            userDataList.add(new userListTableBean(userInfo.getId(), userInfo.getName()));
        });
    }

}
