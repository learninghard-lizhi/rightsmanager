package com.framework.rightsmanagervueservice.dto;

/**
 * Created by lizhi on 2017/11/12.
 */
public class ModifyPwdRequest {

    private String old_pwd;

    private String new_pwd;


    /**
     * @param old_pwd
     */
    public void setold_pwd(String old_pwd) {
        this.old_pwd = old_pwd;
    }

    public String getold_pwd() {
        return old_pwd;
    }

    /**
     * @param new_pwd
     */
    public void setnew_pwd(String new_pwd) {
        this.new_pwd = new_pwd;
    }

    public String getnew_pwd() {
        return new_pwd;
    }
}
