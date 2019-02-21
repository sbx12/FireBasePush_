package com.conversion.sbx.firebasepush;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class SendActivity extends AppCompatActivity {

    private TextView user_id_view;
    private String mUserId;
    private String mCurrentId;
    private String mUserName;
    private ProgressBar mProgressBar;

    private EditText mMessageView;
    private Button mSendBtn;

    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        user_id_view = (TextView) findViewById(R.id.useer_name_view);
        mMessageView = (EditText) findViewById(R.id.send_message);
        mSendBtn = (Button) findViewById(R.id.send_btn);
        mProgressBar = (ProgressBar) findViewById(R.id.send_ProgressBar);

        mFirestore = FirebaseFirestore.getInstance();
        mCurrentId = FirebaseAuth.getInstance().getUid();

        mUserId = getIntent().getStringExtra("user_id");
        mUserName = getIntent().getStringExtra("user_name");
        user_id_view.setText("Send to " + mUserName);

        mSendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                String message = mMessageView.getText().toString();

                if(!TextUtils.isEmpty(message)){
                    mProgressBar.setVisibility(View.VISIBLE);

                    Map<String, Object> notificationMessage = new HashMap<>();
                    notificationMessage.put("message", message);
                    notificationMessage.put("from", mCurrentId);
                    mFirestore.collection("Users/" + mUserId + "/Notifications").add(notificationMessage).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(SendActivity.this, "Notification Sent", Toast.LENGTH_LONG).show();
                            mMessageView.setText("");
                            mProgressBar.setVisibility(View.INVISIBLE);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SendActivity.this, "ERROR!" + e.getMessage(), Toast.LENGTH_LONG).show();
                            mProgressBar.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            }
        });
    }
}
