package com.yy.study.bean;

import java.util.Map;

/**
 * 记录审计信息
 *
 * @author wyy
 * @since 2020-04-19 22:28
 */
public class AuditBean {

    private String method;
    private String url;
    private Map<String,Object> params;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
