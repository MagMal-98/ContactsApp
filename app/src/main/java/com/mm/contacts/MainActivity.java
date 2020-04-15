package com.mm.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mm.contacts.dummy.DummyContent;

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
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
