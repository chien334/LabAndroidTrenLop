package com.example.labtrentruong.Models;

import com.example.labtrentruong.R;

import java.util.ArrayList;

public class DongVat {
    private String Name;
    private int HinhAnh;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public DongVat(String name, int hinhAnh) {
        Name = name;
        HinhAnh = hinhAnh;
    }
    public  static ArrayList init(){
        ArrayList<DongVat> arrayList = new ArrayList<>();
        arrayList.add(new DongVat("Chó", R.drawable.cho));
        arrayList.add(new DongVat("Mèo", R.drawable.meo));
        arrayList.add(new DongVat("Heo", R.drawable.heo));
        arrayList.add(new DongVat("Gà", R.drawable.ga));
        arrayList.add(new DongVat("Vịt", R.drawable.vit));
        arrayList.add(new DongVat("Thiên Nga", R.drawable.thiennga));
        arrayList.add(new DongVat("Đà Điểu", R.drawable.dadieu));
        arrayList.add(new DongVat("Chuột", R.drawable.chuot));
        arrayList.add(new DongVat("Ếch", R.drawable.ech));
        arrayList.add(new DongVat("Vẹt", R.drawable.vet));
        arrayList.add(new DongVat("Sóc", R.drawable.soc));
        arrayList.add(new DongVat("Hải Cẩu", R.drawable.haicau));
        return arrayList;
    }
}
