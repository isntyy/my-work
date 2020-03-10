package com.yy.study.bean;

import java.util.List;

/**
 * @author wyy
 * @date 2020/3/10 20:15
 */
public class MarkDown {

    private Integer level;
    private String contnet;
    private Integer index;
    private List<MarkDown> child;

    public MarkDown(Integer level, String contnet, Integer index, List<MarkDown> child) {
        this.level = level;
        this.contnet = contnet;
        this.index = index;
        this.child = child;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getContnet() {
        return contnet;
    }

    public void setContnet(String contnet) {
        this.contnet = contnet;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public List<MarkDown> getChild() {
        return child;
    }

    public void setChild(List<MarkDown> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "MarkDown{" +
                "level=" + level +
                ", contnet='" + contnet + '\'' +
                ", index=" + index +
                ", child=" + child +
                '}';
    }
}
