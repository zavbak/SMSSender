package com.anit.alex.smssender.api.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Alex on 07.03.2017.
 */

public class MessChangeData implements IEventMessage {
    @Override
    public void send() {
        EventBus.getDefault().post(this);
    }
}
