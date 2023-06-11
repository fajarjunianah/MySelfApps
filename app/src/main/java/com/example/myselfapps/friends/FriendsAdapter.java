package com.example.myselfapps.friends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myselfapps.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>{
//    10 Juni 2023
//    10120211 - Arif Rachmat Darmawan - IF6

    Context context;
    ArrayList<Friends> friendsArrayList;

    public FriendsAdapter(Context context, ArrayList<Friends> friendsArrayList) {
        this.context = context;
        this.friendsArrayList = friendsArrayList;
    }

    @NonNull
    @Override
    public FriendsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_item_friends, parent, false);
        return new FriendsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsViewHolder holder, int position) {

        Friends friends = friendsArrayList.get(position);
        holder.tvHeadingFriends.setText(friends.headingFriends);
        holder.titleImageFriends.setImageResource(friends.titleImageFriends);

    }

    @Override
    public int getItemCount() {
        return friendsArrayList.size();
    }

    public static class FriendsViewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView titleImageFriends;
        TextView tvHeadingFriends;

        public FriendsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImageFriends = itemView.findViewById(R.id.siv_friends);
            tvHeadingFriends = itemView.findViewById(R.id.tv_nama);
        }
    }

}
