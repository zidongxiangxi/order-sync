package com.xdchen.order.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "taobao")
public class TaobaoConfig {
    private String refreshTokenUrl;
    private String tbPostSessionUrl;
    private String topBoxApiUrl;
    private String topSecurityUrl;
    private String topBoxAutUrl;
    private String topBoxAppKey;
    private String topBoxAppSecret;
    private String redirectUri;
    private String topBoxAppKeyForBuyer;
    private String topBoxAppSecretForBuyer;
    private String topToken;

    public String getRefreshTokenUrl() {
        return refreshTokenUrl;
    }

    public void setRefreshTokenUrl(String refreshTokenUrl) {
        this.refreshTokenUrl = refreshTokenUrl;
    }

    public String getTbPostSessionUrl() {
        return tbPostSessionUrl;
    }

    public void setTbPostSessionUrl(String tbPostSessionUrl) {
        this.tbPostSessionUrl = tbPostSessionUrl;
    }

    public String getTopBoxApiUrl() {
        return topBoxApiUrl;
    }

    public void setTopBoxApiUrl(String topBoxApiUrl) {
        this.topBoxApiUrl = topBoxApiUrl;
    }

    public String getTopSecurityUrl() {
        return topSecurityUrl;
    }

    public void setTopSecurityUrl(String topSecurityUrl) {
        this.topSecurityUrl = topSecurityUrl;
    }

    public String getTopBoxAutUrl() {
        return topBoxAutUrl;
    }

    public void setTopBoxAutUrl(String topBoxAutUrl) {
        this.topBoxAutUrl = topBoxAutUrl;
    }

    public String getTopBoxAppKey() {
        return topBoxAppKey;
    }

    public void setTopBoxAppKey(String topBoxAppKey) {
        this.topBoxAppKey = topBoxAppKey;
    }

    public String getTopBoxAppSecret() {
        return topBoxAppSecret;
    }

    public void setTopBoxAppSecret(String topBoxAppSecret) {
        this.topBoxAppSecret = topBoxAppSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getTopBoxAppKeyForBuyer() {
        return topBoxAppKeyForBuyer;
    }

    public void setTopBoxAppKeyForBuyer(String topBoxAppKeyForBuyer) {
        this.topBoxAppKeyForBuyer = topBoxAppKeyForBuyer;
    }

    public String getTopBoxAppSecretForBuyer() {
        return topBoxAppSecretForBuyer;
    }

    public void setTopBoxAppSecretForBuyer(String topBoxAppSecretForBuyer) {
        this.topBoxAppSecretForBuyer = topBoxAppSecretForBuyer;
    }

    public String getTopToken() {
        return topToken;
    }

    public void setTopToken(String topToken) {
        this.topToken = topToken;
    }
}
