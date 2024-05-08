package org.example.case_module3_demo.model;

public class Staff {
    private String id_nv;
    private String ten_nv;
    private String vai_tro;
    private int cmt_nv;
    private int dien_thoai_nv;

    public Staff() {
    }

    public Staff(String id_nv) {
        this.id_nv = id_nv;
    }

    public Staff(String ten_nv, String vai_tro, int cmt_nv, int dien_thoai_nv) {
        this.ten_nv = ten_nv;
        this.vai_tro = vai_tro;
        this.cmt_nv = cmt_nv;
        this.dien_thoai_nv = dien_thoai_nv;
    }

    public Staff(String ma_nv, String ten_nv, String vai_tro, int cmt_nv, int dien_thoai_nv) {
        this.id_nv = ma_nv;
        this.ten_nv = ten_nv;
        this.vai_tro = vai_tro;
        this.cmt_nv = cmt_nv;
        this.dien_thoai_nv = dien_thoai_nv;
    }

    public String getId_nv() {
        return id_nv;
    }

    public void setId_nv(String id_nv) {
        this.id_nv = id_nv;
    }

    public String getTen_nv() {
        return ten_nv;
    }

    public void setTen_nv(String ten_nv) {
        this.ten_nv = ten_nv;
    }

    public String getVai_tro() {
        return vai_tro;
    }

    public void setVai_tro(String vai_tro) {
        this.vai_tro = vai_tro;
    }

    public int getCmt_nv() {
        return cmt_nv;
    }

    public void setCmt_nv(int cmt_nv) {
        this.cmt_nv = cmt_nv;
    }

    public int getDien_thoai_nv() {
        return dien_thoai_nv;
    }

    public void setDien_thoai_nv(int dien_thoai_nv) {
        this.dien_thoai_nv = dien_thoai_nv;
    }
}

