package com.example.labtrentruong.Models;

import java.io.Serializable;

public class Person implements Serializable {
    int code;
    private int avatar;
    private String name;
    private String address;
    private Boolean gioiTinh;
    private String phone;

    public Person(int code, int avatar, String name, String address, Boolean gioiTinh, String phone) {
        this.code = code;
        this.avatar = avatar;
        this.name = name;
        this.address = address;
        this.gioiTinh = gioiTinh;
        this.phone = phone;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
