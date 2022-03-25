package com.example.oldagemanagmentsystem;

public class PersonViewItems {
    private String Name;
    private String Religion;
    private String Age;
    private String Image;
    private String Literacy;
    private String health_con;
    private String Id;
    private String bed_w;
    private String Pension;



    public PersonViewItems() {
    }

    public PersonViewItems(String name, String religion, String age, String image, String literacy, String health_con, String id, String bed_w, String pension) {
        Name = name;
        Religion = religion;
        Age = age;
        Image = image;
        Literacy = literacy;
        this.health_con = health_con;
        Id = id;
        this.bed_w = bed_w;
        Pension = pension;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String religion) {
        Religion = religion;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getLiteracy() {
        return Literacy;
    }

    public void setLiteracy(String literacy) {
        Literacy = literacy;
    }

    public String getHealth_con() {
        return health_con;
    }

    public void setHealth_con(String health_con) {
        this.health_con = health_con;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBed_w() {
        return bed_w;
    }

    public void setBed_w(String bed_w) {
        this.bed_w = bed_w;
    }

    public String getPension() {
        return Pension;
    }

    public void setPension(String pension) {
        Pension = pension;
    }
}
