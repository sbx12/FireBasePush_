package com.conversion.sbx.firebasepush;

import android.app.Notification;

public class Notifications {

    String from, message;

    public Notifications(){

    }

    public String getFrom(){
        return  from;
    }

    public void setFrom(String from){
        this.from = from;
    }

    public String getMessage(){
        return from;
    }

    public  void setMessage(String message){
        this.message = message;
    }

    public Notifications(String from, String message){
        this.from = from;
        this.message = message;
    }
}
