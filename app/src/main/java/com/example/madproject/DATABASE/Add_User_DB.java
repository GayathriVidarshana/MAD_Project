package com.example.madproject.DATABASE;

public class Add_User_DB {

    //create constructor
    public Add_User_DB() {


    }

    private String UName;
    private int Uphone;
    private String UEmail;
    private String UPw;


    //create getters and setters

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public int getUphone() {
        return Uphone;
    }

    public void setUphone(int uphone) {
        Uphone = uphone;
    }

    public String getUEmail() {
        return UEmail;
    }

    public void setUEmail(String UEmail) {
        this.UEmail = UEmail;
    }

    public String getUPw() {
        return UPw;
    }

    public void setUPw(String UPw) {
        this.UPw = UPw;
    }
}
