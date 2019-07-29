package com.example.labtrentruong.Models;

import java.util.ArrayList;

public class LaiThangKH {
    private String NameKH;
    private int SoTienVay;
    private int SoThangTra;
    private int LaiXuat;

    public LaiThangKH(String nameKH, int soTienVay, int soThangTra, int laiXuat) {
        NameKH = nameKH;
        SoTienVay = soTienVay;
        SoThangTra = soThangTra;
        LaiXuat = laiXuat;
    }

    public int getSoTienVay() {
        return SoTienVay;
    }

    public void setSoTienVay(int soTienVay) {
        SoTienVay = soTienVay;
    }

    public int getLaiXuat() {
        return LaiXuat;
    }

    public void setLaiXuat(int laiXuat) {
        LaiXuat = laiXuat;
    }

    public String getNameKH() {
        return NameKH;
    }

    public void setNameKH(String nameKH) {
        NameKH = nameKH;
    }


    public int getSoThangTra() {
        return SoThangTra;
    }

    public void setSoThangTra(int soThangTra) {
        SoThangTra = soThangTra;
    }
    public static ArrayList init(){
        ArrayList<LaiThangKH> arrayList = new ArrayList<>();
        arrayList.add(new LaiThangKH("Lê Quyết Chiến",120000,12,3));
        return arrayList;
    }
}
