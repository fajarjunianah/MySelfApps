package com.example.myselfapps.music_video;

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

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {
//    10 Juni 2023
//    10120211 - Arif Rachmat Darmawan - IF6
    Context context;
    ArrayList<Music> musicArrayList;

    public MusicAdapter(Context context, ArrayList<Music> musicArrayList){
        this.context = context;
        this.musicArrayList = musicArrayList;
    }

    @NonNull
    @Override
    public MusicAdapter.MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_item_music, parent, false);
        return new MusicAdapter.MusicViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.MusicViewHolder holder, int position) {

        Music music = musicArrayList.get(position);
        holder.tvHeadingMusic.setText(music.headingMusic);
        holder.titleImageMusic.setImageResource(music.titleImageMusic);

    }

    @Override
    public int getItemCount() {
        return musicArrayList.size();
    }

    public static class MusicViewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView titleImageMusic;
        TextView tvHeadingMusic;

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImageMusic = itemView.findViewById(R.id.siv_music);
            tvHeadingMusic = itemView.findViewById(R.id.tv_heading);
        }
    }
}
