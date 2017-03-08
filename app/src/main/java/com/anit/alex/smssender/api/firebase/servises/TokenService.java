package com.anit.alex.smssender.api.firebase.servises;


import com.anit.alex.smssender.constants.LogConstants;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


public class TokenService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        try {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            //Toast.makeText(getApplicationContext(),refreshedToken,Toast.LENGTH_SHORT).show();
            LogConstants.Log( "Refreshed token: " + refreshedToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}