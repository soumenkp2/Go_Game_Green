package com.example.gogamegreen.fragmentclass;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.gogamegreen.R;
import com.example.gogamegreen.SliderAdapter;
import com.example.gogamegreen.image_recog;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {

    CardView viewbill,designcard;
    ViewPager pager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home.
     */
    // TODO: Rename and change types and number of parameters
    public static home newInstance(String param1, String param2) {
        home fragment = new home();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        pager = view.findViewById(R.id.viewpager);

        Bundle bundle = getArguments();


        // ImageView infobtn = (ImageView) view.findViewById(R.id.ibutton);

        List<Integer> imagelist = new ArrayList<>();
        imagelist.add(R.drawable.waterboy);
        imagelist.add(R.drawable.tractor);

        SliderAdapter imageAdapter = new SliderAdapter(imagelist);
        pager.setAdapter(imageAdapter);

        LinearLayout gameview = (LinearLayout) view.findViewById(R.id.gamelayout);

        gameview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment game = new gamezone();
                ft.replace(R.id.fragment,game);
                ft.commit();
            }
        });
//        LinearLayout billcalculatorlayout = (LinearLayout) view.findViewById(R.id.billcalculatorlayout);
//        billcalculatorlayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /* to replace a fragment with a fragment */
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                Fragment billcalculatingfragment = new billcalculator();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment, billcalculatingfragment).addToBackStack(null).commit();
//            }
//        });

//        ImageView ibutton = (ImageView) view.findViewById(R.id.ibutton);
//        ibutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getContext(), i_btninfo.class);
//                startActivity(i);
//            }
//        });


       viewbill = (CardView) view.findViewById(R.id.viewbill);
       viewbill.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(getContext(), image_recog.class);
               startActivity(i);

           }
    });


//        designcard = (CardView) view.findViewById(R.id.design);
//        designcard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getContext(), billtips.class);
//                i.putExtra("bundle", bundle);
//                startActivity(i);
//            }
//        });

        return view;
    }
}