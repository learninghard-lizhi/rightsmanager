package com.framework.rightsmanagervueservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by lizhi on 2017/11/7.
 */
public class SysSystemConfigRequest {

    @JsonProperty(value = "SYSTEM_NAME")
    private String SYSTEM_NAME;

    @JsonProperty(value = "IDENTIFYING_CODE")
    private String IDENTIFYING_CODE;

    @JsonProperty(value = "LOGIN_SESSION_VALID")
    private String LOGIN_SESSION_VALID;

    @JsonProperty(value = "SYSTEM_LOGO")
    private String SYSTEM_LOGO;

    @JsonProperty(value = "LOGO_TYPE")
    private String LOGO_TYPE;

    public String getSYSTEM_NAME() {
        return SYSTEM_NAME;
    }

    /**
     * @param system_name
     */
    public void setSYSTEM_NAME(String system_name) {
        this.SYSTEM_NAME = system_name;
    }

    public String getIDENTIFYING_CODE() {
        return IDENTIFYING_CODE;
    }

    /**
     * @param identifying_code
     */
    public void setIDENTIFYING_CODE(String identifying_code) {
        this.IDENTIFYING_CODE = identifying_code;
    }

    public String getLOGIN_SESSION_VALID() {
        return LOGIN_SESSION_VALID;
    }

    /**
     * @param login_session_valid
     */
    public void setLOGIN_SESSION_VALID(String login_session_valid) {
        this.LOGIN_SESSION_VALID = login_session_valid;
    }

    public String getSYSTEM_LOGO() {
        return SYSTEM_LOGO;
    }

    /**
     * @param system_logo
     */
    public void setSYSTEM_LOGO(String system_logo) {
        this.SYSTEM_LOGO = system_logo;
    }

    public String getLOGO_TYPE() {
        return LOGO_TYPE;
    }

    /**
     * @param logo_type
     */
    public void setLOGO_TYPE(String logo_type) {
        this.SYSTEM_LOGO = logo_type;
    }
}
