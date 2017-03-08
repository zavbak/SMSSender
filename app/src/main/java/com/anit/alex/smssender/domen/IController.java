package com.anit.alex.smssender.domen;

import android.content.Context;

/**
 * Created by Alex on 06.03.2017.
 */

public interface IController {

    void sendSms(String phone, String message);
    String getToken();
    void saveSms(String phone, String message);
    void sendTextMessage(String message, Context context);

    String getPhonePref();
    String getMessagePref();
    Long getDatePref();
}
