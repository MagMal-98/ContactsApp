package com.mm.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.mm.contacts.Contact.ContactListContent;

public class AddContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
    }

    public void add_contact(View view) {
        EditText contactNameEditTxt = findViewById(R.id.Name);
        EditText contactSurnameEditTxt = findViewById(R.id.Surname);
        EditText contactBirthdayEditTxt = findViewById(R.id.Birthday);
        EditText contactPhoneEditTxt = findViewById(R.id.Phone_number);

        String contactName = contactNameEditTxt.getText().toString();
        String contactSurname = contactSurnameEditTxt.getText().toString();
        String contactBirthdy = contactBirthdayEditTxt.getText().toString();
        String contactPhone = contactPhoneEditTxt.getText().toString();

        ContactListContent.addItem(new ContactListContent.Contact(5, contactName, contactSurname, contactBirthdy, contactPhone));

        ((ContactFragment) getSupportFragmentManager().findFragmentById(R.id.contact_fragment)).notifyDataChange();

        contactNameEditTxt.setText("");
        contactSurnameEditTxt.setText("");
        contactBirthdayEditTxt.setText("");
        contactPhoneEditTxt.setText("");

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
