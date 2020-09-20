package com.hxg.dao;

/**
 * 学生网上卡片信息
 * @author : Dot
 */
public class StudentOnlineCard {
    //姓名
    private String name;
    //专业
    private String profession;
    //公寓
    private String apartment;
    //房间
    private String bedroom;
    //考试号
    private String Prometric;

    public StudentOnlineCard() {
    }

    public StudentOnlineCard(String name, String profession, String apartment, String bedroom, String prometric) {
        this.name = name;
        this.profession = profession;
        this.apartment = apartment;
        this.bedroom = bedroom;
        Prometric = prometric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getPrometric() {
        return Prometric;
    }

    public void setPrometric(String prometric) {
        Prometric = prometric;
    }
}
