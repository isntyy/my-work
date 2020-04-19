package com.yy.study.bean;

/**
 * 审计路由表
 * 可以配置需要拦截哪些方法，方法类型等
 * @author wyy
 * @since 2020-04-19 22:21
 */
public class AuditRouteSearchBean {

    private String method;
    private String url;

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
}
