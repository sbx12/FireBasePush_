package com.conversion.sbx.firebasepush;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.ViewHolder> {

    private List<Users> usersList;
    private Context context;
    private  String mUserName;

    public  UsersRecyclerAdapter(Context context, List<Users> usersList){
        this.usersList = usersList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        final  String user_name = usersList.get(position).getName();

        holder.user_name_view.setText(usersList.get(position).getName());

        CircleImageView user_image_view = holder.user_image_view;
        Glide.with(context).load(usersList.get(position).getImage()).into(user_image_view);

        final String user_id = usersList.get(position).userId;

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntet = new Intent(context, SendActivity.class);
                sendIntet.putExtra("user_id", user_id);
                sendIntet.putExtra("user_name", user_name);
                context.startActivity(sendIntet);
            }
        });
    }

    @Override
    public int getItemCount(){
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private  View mView;

        private CircleImageView user_image_view;
        private TextView user_name_view;

        public ViewHolder(View itemView){
            super(itemView);

            mView = itemView;
            user_image_view = (CircleImageView) mView.findViewById(R.id.user_list_image);
            user_name_view = (TextView) mView.findViewById(R.id.user_list_name);
        }
    }
}
