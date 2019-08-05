package com.yang.entity;

import java.util.Date;

public class AnswerInfo {
    private Long id;
    private Long infoId;

    private String content;

    private Date ctime;

    private Date utime;
    //演员
    private String protagonists;
    //发行时间
    private Date pubTime;
    //导演
    private String director;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public String getProtagonists() {
        return protagonists;
    }

    public void setProtagonists(String protagonists) {
        this.protagonists = protagonists;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}