package org.example.case_module3_demo.model.DTO;

import java.util.Date;

public class ContractDTO {
    private String id_hop_dong;
    private String ten_kh;
    private int dien_thoai_kh;
    private String ten_nv;
    private String vai_tro;
    private int dien_thoai_nv;
    private Date ngay_hd;
    private double gia_thue;
    private double tien_dat_coc;
    private String dieu_khoan;

    public ContractDTO() {
    }

    public ContractDTO(String id_hop_dong, String ten_kh, int dien_thoai_kh, String ten_nv, String vai_tro, int dien_thoai_nv, Date ngay_hd, double gia_thue, double tien_dat_coc, String dieu_khoan) {
        this.id_hop_dong = id_hop_dong;
        this.ten_kh = ten_kh;
        this.dien_thoai_kh = dien_thoai_kh;
        this.ten_nv = ten_nv;
        this.vai_tro = vai_tro;
        this.dien_thoai_nv = dien_thoai_nv;
        this.ngay_hd = ngay_hd;
        this.gia_thue = gia_thue;
        this.tien_dat_coc = tien_dat_coc;
        this.dieu_khoan = dieu_khoan;
    }

    public String getId_hop_dong() {
        return id_hop_dong;
    }

    public void setId_hop_dong(String id_hop_dong) {
        this.id_hop_dong = id_hop_dong;
    }

    public String getTen_kh() {
        return ten_kh;
    }

    public void setTen_kh(String ten_kh) {
        this.ten_kh = ten_kh;
    }

    public int getDien_thoai_kh() {
        return dien_thoai_kh;
    }

    public void setDien_thoai_kh(int dien_thoai_kh) {
        this.dien_thoai_kh = dien_thoai_kh;
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

    public int getDien_thoai_nv() {
        return dien_thoai_nv;
    }

    public void setDien_thoai_nv(int dien_thoai_nv) {
        this.dien_thoai_nv = dien_thoai_nv;
    }

    public Date getNgay_hd() {
        return ngay_hd;
    }

    public void setNgay_hd(Date ngay_hd) {
        this.ngay_hd = ngay_hd;
    }

    public double getGia_thue() {
        return gia_thue;
    }

    public void setGia_thue(double gia_thue) {
        this.gia_thue = gia_thue;
    }

    public double getTien_dat_coc() {
        return tien_dat_coc;
    }

    public void setTien_dat_coc(double tien_dat_coc) {
        this.tien_dat_coc = tien_dat_coc;
    }

    public String getDieu_khoan() {
        return dieu_khoan;
    }

    public void setDieu_khoan(String dieu_khoan) {
        this.dieu_khoan = dieu_khoan;
    }

    @Override
    public String toString() {
        return "ContractDTO{" +
                "id_hop_dong='" + id_hop_dong + '\'' +
                ", ten_kh='" + ten_kh + '\'' +
                ", dien_thoai_kh=" + dien_thoai_kh +
                ", ten_nv='" + ten_nv + '\'' +
                ", vai_tro='" + vai_tro + '\'' +
                ", dien_thoai_nv=" + dien_thoai_nv +
                ", ngay_hd=" + ngay_hd +
                ", gia_thue=" + gia_thue +
                ", tien_dat_coc=" + tien_dat_coc +
                ", dieu_khoan='" + dieu_khoan + '\'' +
                '}';
    }
}
