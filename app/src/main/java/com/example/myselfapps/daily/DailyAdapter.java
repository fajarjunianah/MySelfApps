package com.example.myselfapps.daily;

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

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyViewHolder> {
//    10 Juni 2023
//    10120211 - Arif Rachmat Darmawan - IF6
    Context context;
    ArrayList<Daily> dailyArrayList;

    public DailyAdapter(Context context, ArrayList<Daily> dailyArrayList) {
        this.context = context;
        this.dailyArrayList = dailyArrayList;
    }

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_item_daily, parent, false);
        return new DailyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder holder, int position) {

        Daily daily = dailyArrayList.get(position);
        holder.tvHeadingDaily.setText(daily.headingDaily);
        holder.titleImageDaily.setImageResource(daily.titleImageDaily);

    }

    @Override
    public int getItemCount() {
        return dailyArrayList.size();
    }

    public static class DailyViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView titleImageDaily;
        TextView tvHeadingDaily;

        public DailyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImageDaily = itemView.findViewById(R.id.siv_daily);
            tvHeadingDaily = itemView.findViewById(R.id.tv_heading);
        }
    }

}
