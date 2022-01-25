package com.example.gogamegreen.fragmentclass;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.gogamegreen.R;
import com.example.gogamegreen.activityclass.funfarm;
import com.example.gogamegreen.activityclass.gogreengame;
import com.example.gogamegreen.dinoassist;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link gamezone#newInstance} factory method to
 * create an instance of this fragment.
 */
public class gamezone extends Fragment {
    LinearLayout gogreen, funfarm, saveearth;
    ImageView gamezonebackbutton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public gamezone() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment gamezone.
     */
    // TODO: Rename and change types and number of parameters
    public static gamezone newInstance(String param1, String param2) {
        gamezone fragment = new gamezone();
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
        View view = inflater.inflate(R.layout.fragment_gamezone, container, false);

        gamezonebackbutton = (ImageView) view.findViewById(R.id.gamezonebackbtn);
        gamezonebackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager m = getActivity().getSupportFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                Fragment game = new home();
                t.replace(R.id.fragment, game);
                t.addToBackStack(null);
                t.commit();
            }
        });

        gogreen = (LinearLayout) view.findViewById(R.id.gogreencard);
        gogreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), gogreengame.class);
                startActivity(i);
            }
        });

        saveearth = (LinearLayout) view.findViewById(R.id.dinoassist);
        saveearth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), dinoassist.class);
                startActivity(i);
            }
        });


        funfarm = (LinearLayout) view.findViewById(R.id.funfarmcard);
        funfarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),funfarm.class);
                startActivity(i);
            }
        });
        return view;
    }
}