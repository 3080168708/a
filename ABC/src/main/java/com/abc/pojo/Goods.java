package com.abc.pojo;

public class Goods {
    private Integer id;
    private int cid;
    private String pname;
    private double price;
    private String details;

    public Goods() {
    }

    public Goods(Integer id, int cid, String pname, double price) {
        this.id = id;
        this.cid = cid;
        this.pname = pname;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", cid=" + cid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                '}';
    }
}
