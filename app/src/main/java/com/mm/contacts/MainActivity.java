package com.mm.contacts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mm.contacts.Contact.ContactListContent;

public class MainActivity extends AppCompatActivity
    implements ContactFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newcontact(View view) {
        Intent intent = new Intent(this, AddContact.class);
        startActivity(intent);
    }


    @Override
    public void onListFragmentClickInteraction(ContactListContent.Contact item, int position) {

    }

    @Override
    public void onListFragmentLongClickInteraction(int position) {

    }


}
