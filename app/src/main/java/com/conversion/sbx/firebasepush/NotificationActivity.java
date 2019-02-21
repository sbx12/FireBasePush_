package com.conversion.sbx.firebasepush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    private TextView mNotifData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        String dataMessage = getIntent().getStringExtra("dataMessage");
        String dataFrom = getIntent().getStringExtra("dataFrom");

        mNotifData = (TextView) findViewById(R.id.Notification_Text);

        mNotifData.setText(" FROM : " + dataFrom + " | MESSAGE : " + dataMessage);
    }


}
