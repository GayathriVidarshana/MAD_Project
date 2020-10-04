package com.example.madproject.DATABASE;

public class Add_Item_DB {

    public Add_Item_DB() {

    }

    private String Icode;
    private String BrName;
    private String Imodel;
    private Double Iprice;
    private Double IDiscount;
    private String Idescription;
    private Integer Stock;



    //create getters and setters

    public String getIcode() {
        return Icode;
    }

    public void setIcode(String icode) {
        Icode = icode;
    }

    public String getBrName() {
        return BrName;
    }

    public void setBrName(String brName) {
        BrName = brName;
    }

    public String getImodel() {
        return Imodel;
    }

    public void setImodel(String imodel) {
        Imodel = imodel;
    }

    public Double getIprice() {
        return Iprice;
    }

    public void setIprice(Double iprice) {
        Iprice = iprice;
    }

    public Double getIDiscount() {
        return IDiscount;
    }

    public void setIDiscount(Double IDiscount) {
        this.IDiscount = IDiscount;
    }

    public String getIdescription() {
        return Idescription;
    }

    public void setIdescription(String idescription) {
        Idescription = idescription;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer stock) {
        Stock = stock;
    }
}
