package com.yes.dl.shop.db.domain;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.io.Serializable;
import java.util.Date;

public class SysModule implements Serializable {

      private String id; //主键id
      private String title; //菜单标题
      private String intro; //菜单显示内容
      private String url; //菜单对应的页面url
      private Integer level; //显示顺序
      private String pCode; //父级编码
      private String code; //子级编码
      private String flag; //是否有效 0为失效，1为有效
      private Date createDate; //创建时间
      private String iconCode; //菜单对应的图标

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIconCode() {
        return iconCode;
    }

    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
    }

    @Override
    public String toString() {
        return "SysModule{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", url='" + url + '\'' +
                ", level=" + level +
                ", pCode='" + pCode + '\'' +
                ", code='" + code + '\'' +
                ", flag='" + flag + '\'' +
                ", createDate=" + createDate +
                ", iconCode='" + iconCode + '\'' +
                '}';
    }
}
