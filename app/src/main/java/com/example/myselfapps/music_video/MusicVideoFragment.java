package com.example.myselfapps.music_video;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myselfapps.R;
import com.example.myselfapps.daily.Daily;
import com.example.myselfapps.daily.DailyAdapter;
import com.example.myselfapps.friends.Friends;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicVideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicVideoFragment extends Fragment {
//    10 Juni 2023
//    10120211 - Arif Rachmat Darmawan - IF6
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Music> musicArrayList;
    private String[] musicHeading;
    private int[] ImageResourceIDMusic;
    private RecyclerView recylerviewMusic, recyclerViewVideo;
    private VideoAdapter videoAdapter;

    public MusicVideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MusicVideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicVideoFragment newInstance(String param1, String param2) {
        MusicVideoFragment fragment = new MusicVideoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music_video, container, false);
        recyclerViewVideo = view.findViewById(R.id.rv_video);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitializeMusic();
        recylerviewMusic = view.findViewById(R.id.rv_music);
        recylerviewMusic.setLayoutManager(new LinearLayoutManager(getContext()));
        recylerviewMusic.setHasFixedSize(true);
        MusicAdapter musicAdapter = new MusicAdapter(getContext(), musicArrayList);
        recylerviewMusic.setAdapter(musicAdapter);
        musicAdapter.notifyDataSetChanged();

        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem("android.resource://" + requireContext().getPackageName() + "/" + R.raw.glimpse));
        videoItems.add(new VideoItem("android.resource://" + requireContext().getPackageName() + "/" + R.raw.ayomenabung));
        videoItems.add(new VideoItem("android.resource://" + requireContext().getPackageName() + "/" + R.raw.membuatprakarya));
        videoItems.add(new VideoItem("android.resource://" + requireContext().getPackageName() + "/" + R.raw.bintangkecil));

        videoAdapter = new VideoAdapter(requireContext(), videoItems);
        recyclerViewVideo.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerViewVideo.setAdapter(videoAdapter);

    }

    private void dataInitializeMusic() {
        musicArrayList = new ArrayList<>();
        musicHeading = new String[]{
                getString(R.string.nama_lagu1),
                getString(R.string.nama_lagu2),
                getString(R.string.nama_lagu3),
                getString(R.string.nama_lagu4),

        };

        ImageResourceIDMusic = new int[]{
                R.drawable.joji,
                R.drawable.cocomelon,
                R.drawable.cocomelon,
                R.drawable.cocomelon,

        };

        for (int i = 0; i < musicHeading.length; i++) {
            Music music = new Music(musicHeading[i], ImageResourceIDMusic[i]);
            musicArrayList.add(music);
        }

    }

}