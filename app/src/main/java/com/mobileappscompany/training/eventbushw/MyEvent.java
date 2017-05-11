package com.mobileappscompany.training.eventbushw;

/**
 * Created by Albert on 5/9/17.
 */

public class MyEvent {
    private int mEventCode;
    private String mMessage;

    public MyEvent(int mEventCode, String mMessage) {
        this.mEventCode = mEventCode;
        this.mMessage = mMessage;
    }

    public int getmEventCode() {
        return mEventCode;
    }

    public String getmMessage() {
        return mMessage;
    }
}
