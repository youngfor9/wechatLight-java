package com.yang.entity;

import java.io.Serializable;
import java.util.Date;
public class UserInfo  {
    private Long id;
    private String nickName;
    //1：男，2：女
    private Integer gender;
    //语言
    private String language;
    //市/县
    private String city;
    //省份
    private String province;
    //国籍
    private String country;
    //头像
    private String avatarUrl;
    //创建时间
    private Date cTime;
    //更新时间
    private Date uTime;
    //总分
    private Long score;
    //上次得分
    private Long lastScore;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getuTime() {
        return uTime;
    }

    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getLastScore() {
        return lastScore;
    }

    public void setLastScore(Long lastScore) {
        this.lastScore = lastScore;
    }
}