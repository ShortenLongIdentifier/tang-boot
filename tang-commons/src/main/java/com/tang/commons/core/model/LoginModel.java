package com.tang.commons.core.model;

import java.io.Serializable;

/**
 * 登陆模型
 *
 * @author Tang
 */
public class LoginModel implements Serializable {

    @java.io.Serial
    private static final long serialVersionUID = -1126768973671963020L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 登陆方式
     */
    private String loginType;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

}
