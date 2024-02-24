package com.example.myrs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class YourBottomSheetDialogFragment extends BottomSheetDialogFragment {

    private String message;  // Variable to store the message

    // Static method to create an instance of YourBottomSheetDialogFragment with data
    public static YourBottomSheetDialogFragment newInstance(String message) {
        YourBottomSheetDialogFragment fragment = new YourBottomSheetDialogFragment();
        Bundle args = new Bundle();
        args.putString("message", message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_dialog, container, false);

        // Get the TextView from the layout
        TextView bottomSheetTextView = view.findViewById(R.id.bottomSheetTextView);

        // Get the message from the arguments
        if (getArguments() != null) {
            message = getArguments().getString("message");
        }

        // Set the text dynamically
        bottomSheetTextView.setText(message);

        return view;
    }
}

