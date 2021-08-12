package com.itc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHarian#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHarian extends Fragment {
    int hasil;

    int[] editTextId = {
            R.id.et_masukhr,
            R.id.et_keluarhr
    };

    int[] buttonId = {
            R.id.bt_iharian,
            R.id.bt_balikhr
    };

    ArrayList<EditText> editTexts = new ArrayList<>();
    ArrayList<Button> buttons = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentHarian() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHarian.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHarian newInstance(String param1, String param2) {
        FragmentHarian fragment = new FragmentHarian();
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
        View view = inflater.inflate(R.layout.fragment_harian, container, false);
        for (int j : editTextId) editTexts.add(view.findViewById(j));
        for (int j : buttonId) buttons.add(view.findViewById(j));

        buttons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasil = Integer.parseInt(editTexts.get(0).getText().toString())
                    - Integer.parseInt(editTexts.get(1).getText().toString());

            }
        });
        return view;
    }
}