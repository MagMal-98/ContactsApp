package com.mm.contacts;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CallDialog extends DialogFragment {

    private String name;

    public CallDialog() {
        // Required empty public constructor
    }

    public CallDialog(String name){
        this.name = name;
    }

   static CallDialog newInstance(String name) {
        return new CallDialog(name);
    }

    public interface OnCallDialogInteractionListener {
        void onCallDialogPositiveClick(DialogFragment dialog);
        void onCallDialogNegativeClick(DialogFragment dialog);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Call to "+name+"?");

        builder.setPositiveButton(getString(R.string.dialog_confirm), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                OnCallDialogInteractionListener mListener =  (OnCallDialogInteractionListener) getActivity();
                mListener.onCallDialogPositiveClick(CallDialog.this);
            }
        });

        builder.setNegativeButton(getString(R.string.dialog_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                OnCallDialogInteractionListener mListener =  (OnCallDialogInteractionListener) getActivity();
                mListener.onCallDialogNegativeClick(CallDialog.this);
            }
        });
        return builder.create();
    }
}
