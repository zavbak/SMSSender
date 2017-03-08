package com.anit.alex.smssender.domen;

import android.content.Context;
import android.content.Intent;

;
import com.anit.alex.smssender.api.eventbus.IEventMessage;
import com.anit.alex.smssender.api.eventbus.MessChangeData;
import com.anit.alex.smssender.api.preferense.ApiPreferense;
import com.anit.alex.smssender.api.sms.ApiSendSms;
import com.anit.alex.smssender.application.App;
import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by Alex on 06.03.2017.
 */

public class Controller implements IController {

    @Override
    public void sendSms(String phone, String message) {
        ApiSendSms apiSendSms = new ApiSendSms();
        apiSendSms.send(phone, message);
    }

    @Override
    public String getToken() {
        try {
            return FirebaseInstanceId.getInstance().getToken();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveSms(String phone, String message) {
        App.getPreferences().SaveSms(phone, message);
        IEventMessage mess = new MessChangeData();
        App.getFireDataBaseHelper().saveToFireBase(phone,message);
        mess.send();
    }

    @Override
    public void sendTextMessage(String message, Context context) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }



    @Override
    public String getPhonePref() {
        return App.getPreferences().getPhone();
    }

    @Override
    public String getMessagePref() {
        return App.getPreferences().getMessage();
    }

    @Override
    public Long getDatePref() {
        return App.getPreferences().getDate();
    }


}
