package com.example.madproject.DATABASE;

public class Add_Driver
{

    //create constructor
    public Add_Driver() {

    }



    private String name;
    private int phone;
    private String LicenseNo;
    private String NIC;
    private String V_type;
    private String V_No;

    //getters
    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getLicenseNo() {
        return LicenseNo;
    }

    public String getNIC() {
        return NIC;
    }

    public String getV_type() {
        return V_type;
    }

    public String getV_No() {
        return V_No;
    }
    //setters


    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setLicenseNo(String licenseNo) {
        LicenseNo = licenseNo;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public void setV_type(String v_type) {
        V_type = v_type;
    }

    public void setV_No(String v_No) {
        V_No = v_No;
    }
}


