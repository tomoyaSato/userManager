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

    private final String id;

    public String getId() {
        return id;
    }

    private final String name;

    public String getName() {
        return name;
    }

    public userListTableBean(final String id, final String name) {
        this.id = id;
        this.name = name;
    }
}
