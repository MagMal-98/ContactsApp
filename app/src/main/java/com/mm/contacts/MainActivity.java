package com.mm.contacts;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import android.app.FragmentTransaction;
import com.mm.contacts.ContactInfoFrag;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mm.contacts.Contact.ContactListContent;


public class MainActivity extends AppCompatActivity implements
        ContactFragment.OnListFragmentInteractionListener,
        DeleteDialog.OnDeleteDialogInteractionListener,
        CallDialog.OnCallDialogInteractionListener{

    int selectedDeleteItem = -1;
    public static final String contactExtra = "contactExtra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewContactActivity.class);
                startActivity(intent);
            }
        });

    }

    public void showContactInfo(ContactListContent.Contact contact){
        Intent intent = new Intent(this, ContactInfoAct.class);
        intent.putExtra(contactExtra, contact);
        startActivity(intent);
    }


    @Override
    public void onListFragmentClickInteraction(ContactListContent.Contact item, View view) {
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            displayContactInFragment(item);
        } else {
            showContactInfo(item);
        }
    }

    public void displayContactInFragment(ContactListContent.Contact contact){
       // ContactInfoFrag contactInfoFragment = ( (ContactInfoFrag) getSupportFragmentManager().findFragmentByTag(ContactInfoFrag));
        //if(contactInfoFragment != null){
       //     contactInfoFragment.showContactInfo(contact);
       // }
    }

    @Override
    public void onListFragmentLongClickInteraction(ContactListContent.Contact item) {
        CallDialog.newInstance(item.name).show(getSupportFragmentManager(), getString(R.string.call_dialog));
    }


    @Override
    public void onDeleteButtonClick(int position) {
        selectedDeleteItem = position;
        DeleteDialog.newInstance().show(getSupportFragmentManager(), getString(R.string.delete_dialog_tag));
    }


    @Override
    public void onCallDialogPositiveClick(DialogFragment dialog) {
        Toast.makeText(getApplicationContext(), getString(R.string.calling), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCallDialogNegativeClick(DialogFragment dialog) {

    }


    @Override
    public void OnDialogPositiveClick(DialogFragment dialog) {
      //  if (selectedDeleteItem >= 0 && selectedDeleteItem < ContactListContent.ITEMS.size()) {
       //     ContactListContent.deleteItem(selectedDeleteItem);
       //     ((ContactFragment) getFragmentManager().findFragmentById(R.id.ContactFragment)).notifyDataChange();
        //    ContactInfoFrag contactInfoFragment = ( (ContactInfoFrag) getSupportFragmentManager().findFragmentById(R.id.ContactInfoFrag));
        //    if(contactInfoFragment != null){
         //       contactInfoFragment.displayEmptyContact();
         //   }
       // }

    }

    @Override
    public void OnDialogNegativeClick(DialogFragment dialog) {

    }
}
