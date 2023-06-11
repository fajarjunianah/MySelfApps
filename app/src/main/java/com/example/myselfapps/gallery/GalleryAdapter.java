package com.example.myselfapps.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myselfapps.R;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
//    10 Juni 2023
//    10120211 - Arif Rachmat Darmawan - IF6
    public GalleryAdapter(int[] arr) {
        this.arr = arr;
    }

    int [] arr;

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_gallery, parent, false);
        GalleryViewHolder galleryViewHolder = new GalleryViewHolder(view);
        return galleryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.ivGambar.setImageResource(arr[position]);
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder{
        ImageView ivGambar;
        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGambar = itemView.findViewById(R.id.iv_gambar);
        }
    }
}
