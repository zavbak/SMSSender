package com.anit.alex.smssender.constants;

import android.util.Log;

/**
 * Created by Alex on 03.03.2017.
 */

public class LogConstants {

    public static final String LOG_TAG = "pushsms_log";

    public static void Log(String message){
         Log.d(LOG_TAG,message); //Должно перейти в develop
    }

}
