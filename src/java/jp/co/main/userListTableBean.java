/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.main;

/**
 *
 * @author sac
 */
public class userListTableBean {
    private final boolean radioButton;
    private final String id;
    private final String name;

    public userListTableBean(final boolean radioButton,final String id, final String name) {
        this.radioButton = radioButton;
        this.id = id;
        this.name = name;
    }
}
