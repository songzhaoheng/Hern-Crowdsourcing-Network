package com.hern.manager.bean;

import java.util.List;

public class TPermission {
    private Integer id;

    private Integer pid;

    private String name;

    private String icon;

    private String url;

    private List<TPermission> childs;


    /**
     * @return the childs
     */
    public List<TPermission> getChilds() {
        return childs;
    }


    /**
     * @param childs the childs to set
     */
    public void setChilds(List<TPermission> childs) {
        this.childs = childs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}