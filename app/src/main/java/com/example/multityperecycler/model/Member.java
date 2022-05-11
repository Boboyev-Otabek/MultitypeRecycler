package com.example.multityperecycler.model;

import java.io.Serializable;
import java.io.StringReader;

public class Member implements Serializable {
    private String ism;
    private String familiya;
    private boolean available=false;

    public Member(String ism, String familiya, boolean available){
        this.ism=ism;
        this.familiya=familiya;
        this.available=available;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getIsm() {
        return ism;
    }

    public String getFamiliya() {
        return familiya;
    }
}
