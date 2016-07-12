/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.main;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author sac
 */
@Named(value = "userInfoDetailManagedBean")
@RequestScoped
public class UserInfoDetailManagedBean {

    // タイトル
    private String outputTitle;

    public String getOutputTitle() {
        return outputTitle;
    }

    public void setOutputTitle(String outputTitle) {
        this.outputTitle = outputTitle;
    }

    // 登録・変更ボタン名
    private String buttonText;

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
    
    // ID
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    // Password
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    // Password保持用
    private String hiddenPassword;

    public String getHiddenPassword() {
        return hiddenPassword;
    }

    public void setHiddenPassword(String hiddenPassword) {
        this.hiddenPassword = hiddenPassword;
    }
    
    private boolean isPasswordChange;

    public boolean isIsPasswordChange() {
        return isPasswordChange;
    }

    public void setIsPasswordChange(boolean isPasswordChange) {
        this.isPasswordChange = isPasswordChange;
    }




    
    
    // ユーザー名
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    // 作成日時
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
        
    // 登録・変更区分
    private int moveType;

    public int getMoveType() {
        return moveType;
    }

    public void setMoveType(int moveType) {
        this.moveType = moveType;
    }
    
    private boolean rendereFlg;

    public boolean isRendereFlg() {
        return rendereFlg;
    }

    public void setRendereFlg(boolean rendereFlg) {
        this.rendereFlg = rendereFlg;
    }
    
    
    public UserInfoDetailManagedBean() {
    }
    @Inject 
    UserInfoFacade userInfoFacade;
    public void init() {
    }

    public String moveUserInfoDetail(int moveTypeParam) {
        this.moveType = moveTypeParam;
        
        // モードの切り替え
        if (this.moveType == 0) {
            // 登録モード
            this.outputTitle = "ユーザー情報登録";
            this.buttonText = "登録";
            this.id = userInfoFacade.getNewId();
            this.rendereFlg = false; 
        } else if (this.moveType == 1) {
            // 変更モード
            this.outputTitle = "ユーザー情報変更";
            this.buttonText = "変更";
            
            // ユーザー情報をDBより取得
             List<UserInfo> userInfoList;
            userInfoList = userInfoFacade.findByID(this.id);
                
            if(userInfoList.size() != 1){
                return "userList.xhtml";
            }
            
            this.password   = userInfoList.get(0).getPassword();
            this.userName   = userInfoList.get(0).getName();
            this.createDate = userInfoList.get(0).getCreateTimestamp();
            this.rendereFlg = true; 
        }

        return "userInfoDetail.xhtml";
    }
    
    public String editData(){
        UserInfo userInfo = new UserInfo();
        Date nowDate = new Date();
        if(this.moveType == 0){
            // 登録
            userInfo.setAllParam( this.id,
                                        this.password,
                                        this.userName,
                                        nowDate,
                                        nowDate,
                                        false);
            userInfoFacade.insert(userInfo);
        }else if(this.moveType == 1){
            // 変更
            if(this.isPasswordChange == false){
                this.password = this.hiddenPassword;
            }
            userInfo.setAllParam( this.id,
                                        this.password,
                                        this.userName,
                                        this.createDate,
                                        nowDate,
                                        false);
            userInfoFacade.update(userInfo);
        }
        return moveUserInfoDetail(1);
    }
    
    public String backUserList(){
        return "userList.xhtml";
    }
}
