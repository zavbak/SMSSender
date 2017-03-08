package com.anit.alex.smssender.api.sms;

import android.app.PendingIntent;
import android.telephony.SmsManager;

import java.util.ArrayList;

/**
 * Created by Alex on 02.03.2017.
 */

public class ApiSendSms {

    /**
     * Send sms
     * <p>
     * <uses-permission android:name="android.permission.SEND_SMS"/>
     *
     * @param phoneNumber
     * @param message
     */
    public void send(String phoneNumber, String message) {

        try {

            String smsNumber = phoneNumber;
            String smsText = message;

            SmsManager smsManager = SmsManager.getDefault();

            ArrayList<String> messageArray = smsManager.divideMessage(message);

            if (message.length() > 1) {
                ArrayList<PendingIntent> sentIntents = new ArrayList<PendingIntent>();
                smsManager.sendMultipartTextMessage(smsNumber, null, messageArray, null, null);

            } else {

                smsManager.sendTextMessage(smsNumber, null, smsText, null, null);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
