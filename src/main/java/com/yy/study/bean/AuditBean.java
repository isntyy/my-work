package com.yy.study.bean;

import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 记录审计信息
 *
 * @author wyy
 * @since 2020-04-19 22:28
 */
public class AuditBean {
    /**
     * range可以作用在string上
     */
    @Range(min = 20,max = 22,message = "年龄只能为20")
    private String age;
    private String method;
    private String url;
    private Map<String, Object> params;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

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
