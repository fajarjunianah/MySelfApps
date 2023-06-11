package com.example.myselfapps.daily;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myselfapps.friends.Friends;
import com.example.myselfapps.friends.FriendsAdapter;
import com.example.myselfapps.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DailyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DailyFragment extends Fragment {
//    10 Juni 2023
//    10120211 - Arif Rachmat Darmawan - IF6

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Daily> dailyArrayList;
    private ArrayList<Friends> friendsArrayList;
    private String[] dailyHeading, friendsHeading;
    private int[] ImageResourceIDDaily, ImageResourceIDFriends;
    private RecyclerView recylerviewDaily, recylerviewFriends;
    public DailyFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DailyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DailyFragment newInstance(String param1, String param2) {
        DailyFragment fragment = new DailyFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitializeDaily();
        recylerviewDaily = view.findViewById(R.id.rv_daily);
        recylerviewDaily.setLayoutManager(new LinearLayoutManager(getContext()));
        recylerviewDaily.setHasFixedSize(true);
        DailyAdapter dailyAdapter = new DailyAdapter(getContext(), dailyArrayList);
        recylerviewDaily.setAdapter(dailyAdapter);
        dailyAdapter.notifyDataSetChanged();

        dataInitializeFriends();
        recylerviewFriends = view.findViewById(R.id.rv_friendlist);
        recylerviewFriends.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        recylerviewFriends.setHasFixedSize(true);
        FriendsAdapter friendsAdapter = new FriendsAdapter(getContext(), friendsArrayList);
        recylerviewFriends.setAdapter(friendsAdapter);
        friendsAdapter.notifyDataSetChanged();


    }

    private void dataInitializeDaily() {
        dailyArrayList = new ArrayList<>();
        dailyHeading = new String[]{
                getString(R.string.nama_kegiatan1),
                getString(R.string.nama_kegiatan2),
                getString(R.string.nama_kegiatan3),
                getString(R.string.nama_kegiatan4),
                getString(R.string.nama_kegiatan5),

        };

        ImageResourceIDDaily = new int[]{
                R.drawable.makan,
                R.drawable.kuliah,
                R.drawable.olahraga,
                R.drawable.bermain,
                R.drawable.tidur,

        };

        for (int i = 0; i < dailyHeading.length; i++) {
            Daily daily = new Daily(dailyHeading[i], ImageResourceIDDaily[i]);
            dailyArrayList.add(daily);
        }

    }

    private void dataInitializeFriends() {
        friendsArrayList = new ArrayList<>();
        friendsHeading = new String[]{
                getString(R.string.nama_teman1),
                getString(R.string.nama_teman2),
                getString(R.string.nama_teman3),
                getString(R.string.nama_teman4),
                getString(R.string.nama_teman5),
                getString(R.string.nama_teman6),
                getString(R.string.nama_teman7),

        };

        ImageResourceIDFriends = new int[]{
                R.drawable.friends_arif,
                R.drawable.friends_adit,
                R.drawable.friends_naufal,
                R.drawable.friends_faris,
                R.drawable.friends_fahmi,
                R.drawable.friends_abyan,
                R.drawable.friends_tri,

        };

        for (int i = 0; i < friendsHeading.length; i++) {
            Friends friends = new Friends(friendsHeading[i], ImageResourceIDFriends[i]);
            friendsArrayList.add(friends);
        }
    }
}