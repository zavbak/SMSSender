package com.anit.alex.smssender.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.anit.alex.smssender.R;
import com.anit.alex.smssender.api.eventbus.MessChangeData;
import com.anit.alex.smssender.api.firebase.database.FireDataBaseHelper;
import com.anit.alex.smssender.application.App;
import com.anit.alex.smssender.domen.Controller;
import com.anit.alex.smssender.domen.IController;
import com.anit.alex.smssender.utils.DataUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    IController controller;

    TextView tvToken;
    TextView tvDate;
    TextView tvPhone;
    TextView tvMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Refresh", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                refresh();
            }
        });


        controller =  App.getController();


        tvToken   = (TextView) findViewById(R.id.tvToken);
        tvDate    = (TextView) findViewById(R.id.tvDate);
        tvPhone   = (TextView) findViewById(R.id.tvPhone);
        tvMessage = (TextView) findViewById(R.id.tvMessage);

        tvToken.setOnClickListener(this);

        refresh();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessChangeData event) {
        refresh();
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

    }


    private void refresh() {
        tvToken.setText(controller.getToken());
        tvDate.setText(DataUtils.getFullDate(controller.getDatePref()));
        tvPhone.setText(controller.getPhonePref());
        tvMessage.setText(controller.getMessagePref());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        controller.sendTextMessage(controller.getToken(),this);
    }
}
