package org.example.case_module3_demo.model;


public class Client {
    private String id_kh;
    private String ten_kh;
    private int cmt_kh;
    private int dien_thoai_kh;
    private String dia_chi_lh;

    public Client() {
    }

    public Client(String id_kh) {
        this.id_kh = id_kh;
    }

    public Client(String ten_kh, int cmt_kh, int dien_thoai_kh, String dia_chi_lh) {
        this.ten_kh = ten_kh;
        this.cmt_kh = cmt_kh;
        this.dien_thoai_kh = dien_thoai_kh;
        this.dia_chi_lh = dia_chi_lh;
    }

    public Client(String ma_kh, String ten_kh, int cmt_kh, int dien_thoai_kh, String dia_chi_lh) {
        this.id_kh = ma_kh;
        this.ten_kh = ten_kh;
        this.cmt_kh = cmt_kh;
        this.dien_thoai_kh = dien_thoai_kh;
        this.dia_chi_lh = dia_chi_lh;
    }

    public String getId_kh() {
        return id_kh;
    }

    public void setId_kh(String id_kh) {
        this.id_kh = id_kh;
    }

    public String getTen_kh() {
        return ten_kh;
    }

    public void setTen_kh(String ten_kh) {
        this.ten_kh = ten_kh;
    }

    public int getCmt_kh() {
        return cmt_kh;
    }

    public void setCmt_kh(int cmt_kh) {
        this.cmt_kh = cmt_kh;
    }

    public int getDien_thoai_kh() {
        return dien_thoai_kh;
    }

    public void setDien_thoai_kh(int dien_thoai_kh) {
        this.dien_thoai_kh = dien_thoai_kh;
    }

    public String getDia_chi_lh() {
        return dia_chi_lh;
    }

    public void setDia_chi_lh(String dia_chi_lh) {
        this.dia_chi_lh = dia_chi_lh;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_kh='" + id_kh + '\'' +
                ", ten_kh='" + ten_kh + '\'' +
                ", cmt_kh=" + cmt_kh +
                ", dien_thoai_kh=" + dien_thoai_kh +
                ", dia_chi_lh='" + dia_chi_lh + '\'' +
                '}';
    }
}

