/*package com.conversion.sbx.firebasepush;

import android.app.Notification;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.conversion.sbx.firebasepush.Notifications;
import com.conversion.sbx.firebasepush.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>{

    private List<Notifications> mNotifList;
    private FirebaseFirestore firebaseFirestore;
    private Context context;


    public NotificationAdapter(Context context, List<Notifications> mNotifList){
        this.mNotifList = mNotifList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_notification, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersRecyclerAdapter.ViewHolder holder, int position) {
        firebaseFirestore = FirebaseFirestore.getInstance();
        String from_id = mNotifList.get(position).getFrom();
        holder.mNotifiMessage.setText
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
*/