package com.anit.alex.smssender.api.firebase.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.Date;

/**
 * Created by Alex on 03.03.2017.
 */

public class FireDataBaseHelper {

    public void saveToFireBase(String phone, String message) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference messageRef = database.getReference("message");
        DatabaseReference refToken = messageRef.child(FirebaseInstanceId.getInstance().getToken());

        DatabaseReference sms = refToken.push();

        ObjSms objSms = new ObjSms(new Date().toString(), phone, message);

        try {
            sms.setValue(objSms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
