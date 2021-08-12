package com.itc;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentBulanan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBulanan extends Fragment {

    int hasil;
    boolean check;

    int[] editTextId = {
            R.id.et_masukbln,
            R.id.et_keluarbln
    };

    int[] buttonId = {
            R.id.bt_ibulanan,
            R.id.bt_balikbln
    };

    int[] textViewId = {
            R.id.tv_dialog,
            R.id.tv_sisa
    };

    ArrayList<EditText> editTexts = new ArrayList<>();
    ArrayList<Button> buttons = new ArrayList<>();
    ArrayList<TextView> textViews = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentBulanan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBulanan.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBulanan newInstance(String param1, String param2) {
        FragmentBulanan fragment = new FragmentBulanan();
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
        View view = inflater.inflate(R.layout.fragment_bulanan, container, false);
        for (int j : editTextId) editTexts.add(view.findViewById(j));
        for (int j : buttonId) buttons.add(view.findViewById(j));

        buttons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    check = true;
                    hasil = Integer.parseInt(editTexts.get(0).getText().toString())
                            - Integer.parseInt(editTexts.get(1).getText().toString());
                } catch (NumberFormatException nfe) {
                    check = false;
                    Toast.makeText(getActivity(), "Harus masukin angka!", Toast.LENGTH_SHORT).show();
                }

                if (check==true) {
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity(), R.style.Transparent_Dialog);
                    View dialogView = getLayoutInflater().inflate(R.layout.fragment_dialog, null);
                    dialogBuilder.setView(dialogView);
                    final AlertDialog dialog = dialogBuilder.create();
                    dialog.show();
                    for (int value : textViewId) textViews.add(dialogView.findViewById(value));
                    textViews.get(0).setText("Sisa uang kamu tinggal : ");
                    textViews.get(1).setText("" + hasil);
                }
            }
        });

        buttons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentMenu fragmentMenu = new FragmentMenu();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_mainFrame, fragmentMenu);
                transaction.commit();
            }
        });
        return view;
    }
}