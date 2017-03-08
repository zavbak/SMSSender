package com.anit.alex.smssender.api.firebase.servises;

/**
 * Created by Alex on 03.03.2017.
 */


import com.anit.alex.smssender.application.App;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {



    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {


        if (remoteMessage.getData().size() > 0) {

            try {
                String phone = remoteMessage.getData().get("phone");
                String message = remoteMessage.getData().get("message");


                App.getController().sendSms(phone,message);
                App.getController().saveSms(phone,message);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }


}
