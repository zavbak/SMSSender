package com.anit.alex.smssender.api.preferense;

import android.content.SharedPreferences;



import java.util.Date;

/**
 * Created by Alex on 06.03.2017.
 */

public class ApiPreferense {

    SharedPreferences sharedPreferences;

    public ApiPreferense(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    final private String PREF_PHONE   = "pref_phone";
    final private String PREF_MESSAGE = "pref_message";
    final private String PREF_DATE    = "pref_date";

    public void SaveSms(String phone,String message){

        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putString(PREF_PHONE,phone);
        ed.putString(PREF_MESSAGE,message);
        ed.putLong(PREF_DATE,new Date().getTime());
        ed.commit();
    }


    public String getPhone(){
        return sharedPreferences.getString(PREF_PHONE,"");
    }

    public String getMessage(){
        return sharedPreferences.getString(PREF_MESSAGE,"");
    }

    public Long getDate(){
        return sharedPreferences.getLong(PREF_DATE,0);
    }

}
