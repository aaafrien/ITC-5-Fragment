package com.itc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMenu extends Fragment {

    private String nama;
    int[] buttonId = {
            R.id.bt_harian,
            R.id.bt_bulanan
    };

    ArrayList<Button> buttons = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentMenu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMenu.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMenu newInstance(String param1, String param2) {
        FragmentMenu fragment = new FragmentMenu();
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
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        for (int value : buttonId) buttons.add(view.findViewById(value));

        buttons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHarian fragmentHarian = new FragmentHarian();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_mainFrame, fragmentHarian);
                transaction.commit();
            }
        });

        buttons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentBulanan fragmentBulanan = new FragmentBulanan();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_mainFrame, fragmentBulanan);
                transaction.commit();
            }
        });
        return view;
    }
}