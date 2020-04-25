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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeleteDialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeleteDialog extends DialogFragment {


    public DeleteDialog() {
        // Required empty public constructor
    }

    static DeleteDialog newInstance(){
        return new DeleteDialog();
    }

    public interface OnDeleteDialogInteractionListener{
        void OnDialogPositiveClick(DialogFragment dialog);
        void OnDialogNegativeClick(DialogFragment dialog);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(getString(R.string.delete_question));

        builder.setPositiveButton(getString(R.string.dialog_confirm), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                OnDeleteDialogInteractionListener mListener =  (OnDeleteDialogInteractionListener) getActivity();
                mListener.OnDialogPositiveClick(DeleteDialog.this);
            }
        });

        builder.setNegativeButton(getString(R.string.dialog_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                OnDeleteDialogInteractionListener mListener =  (OnDeleteDialogInteractionListener) getActivity();
               mListener.OnDialogNegativeClick(DeleteDialog.this);
            }
        });
        return builder.create();
    }
}
