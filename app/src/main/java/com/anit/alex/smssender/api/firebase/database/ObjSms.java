package com.anit.alex.smssender.api.firebase.database;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Alex on 07.03.2017.
 */
@IgnoreExtraProperties
public class ObjSms {

    public String date;
    public String phone;
    public String message;

    public ObjSms() {
    }

    public ObjSms(String date, String phone, String message) {
        this.date = date;
        this.phone = phone;
        this.message = message;
    }

}
