package com.anit.alex.smssender.application;

import android.app.Application;
import android.content.Context;

import com.anit.alex.smssender.api.firebase.database.FireDataBaseHelper;
import com.anit.alex.smssender.api.preferense.ApiPreferense;
import com.anit.alex.smssender.domen.Controller;
import com.anit.alex.smssender.domen.IController;


/**
 * Created by Alex on 06.03.2017.
 */

public class App extends Application {

    private static App sInstance;
    private static IController controller;
    private static ApiPreferense preferences;
    private static FireDataBaseHelper fireDataBaseHelper;

    public static synchronized App get() {
        return sInstance;
    }

    public static synchronized FireDataBaseHelper getFireDataBaseHelper() {
        return fireDataBaseHelper;
    }

    public static Context getContext() {
        return App.get().getApplicationContext();
    }


    public static synchronized IController getController() {
        return controller;
    }


    public static ApiPreferense getPreferences() {
        return preferences;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        sInstance.initializeInstance();
    }

    private void initializeInstance() {
        controller = new Controller();
        preferences = new ApiPreferense(getSharedPreferences(this.getClass().getName(), MODE_PRIVATE));
        fireDataBaseHelper = new FireDataBaseHelper();

    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
