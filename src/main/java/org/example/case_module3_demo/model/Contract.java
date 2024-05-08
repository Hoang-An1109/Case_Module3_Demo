package org.example.case_module3_demo.model;

import java.util.Date;

public class Contract {
    private String id_hop_dong;
    private Boarding_House boardingHouse;
    private Client client;
    private Staff staff;
    private Date ngay_hd;
    private double gia_thue;
    private double tien_dat_coc;
    private String dieu_khoan;

    public Contract() {
    }

    public Contract(Boarding_House boardingHouse, Client client, Staff staff, Date ngay_hd, double gia_thue, double tien_dat_coc, String dieu_khoan) {
        this.boardingHouse = boardingHouse;
        this.client = client;
        this.staff = staff;
        this.ngay_hd = ngay_hd;
        this.gia_thue = gia_thue;
        this.tien_dat_coc = tien_dat_coc;
        this.dieu_khoan = dieu_khoan;
    }

    public Contract(String id_hop_dong, Boarding_House boardingHouse, Client client, Staff staff, Date ngay_hd, double gia_thue, double tien_dat_coc, String dieu_khoan) {
        this.id_hop_dong = id_hop_dong;
        this.boardingHouse = boardingHouse;
        this.client = client;
        this.staff = staff;
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

    public Boarding_House getBoardingHouse() {
        return boardingHouse;
    }

    public void setBoardingHouse(Boarding_House boardingHouse) {
        this.boardingHouse = boardingHouse;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
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
        return "Contract{" +
                "id_hop_dong='" + id_hop_dong + '\'' +
                ", boardingHouse=" + boardingHouse +
                ", client=" + client +
                ", staff=" + staff +
                ", ngay_hd=" + ngay_hd +
                ", gia_thue=" + gia_thue +
                ", tien_dat_coc=" + tien_dat_coc +
                ", dieu_khoan='" + dieu_khoan + '\'' +
                '}';
    }
}
