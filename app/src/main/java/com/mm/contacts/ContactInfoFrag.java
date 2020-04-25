package com.mm.contacts;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mm.contacts.Contact.ContactListContent;


public class ContactInfoFrag extends Fragment {

    public ContactInfoFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_info, container, false);
    }

    public void showContactInfo(ContactListContent.Contact contact){
        FragmentActivity activity = getActivity();

        TextView nameAndSurnameTxtView = activity.findViewById(R.id.contact_name);
        ImageView avatarImageView = activity.findViewById(R.id.avatarImg);
        TextView phoneNumberTxtView = activity.findViewById(R.id.phone_num);
        TextView birthDateTxtView = activity.findViewById(R.id.birthdate);

        avatarImageView.setVisibility(View.VISIBLE);
        String name = contact.name;
        String surname = contact.surname;
        int avatarID = contact.avatarnum;
        String phoneNumber = contact.phone;
        String birthDate = contact.birthday;

        nameAndSurnameTxtView.setText(name + " " + surname);
        avatarImageView.setImageResource(avatarID);
        phoneNumberTxtView.setText("Phone number: "+phoneNumber);
        birthDateTxtView.setText("Birthday: "+birthDate);
    }

    public void displayEmptyContact(){
        FragmentActivity activity = getActivity();

        TextView nameAndSurnameTxtView = activity.findViewById(R.id.contact_name);
        ImageView avatarImageView = activity.findViewById(R.id.avatarImg);
        TextView phoneNumberTxtView = activity.findViewById(R.id.phone_num);
        TextView birthDateTxtView = activity.findViewById(R.id.birthdate);

        nameAndSurnameTxtView.setText("");
        avatarImageView.setVisibility(View.INVISIBLE);
        phoneNumberTxtView.setText("");
        birthDateTxtView.setText("");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Intent intent = getActivity().getIntent();
        if(intent != null){
            ContactListContent.Contact recivedContact = intent.getParcelableExtra(MainActivity.contactExtra);
            if(recivedContact != null) {
                showContactInfo(recivedContact);
            }
        }
    }

}
