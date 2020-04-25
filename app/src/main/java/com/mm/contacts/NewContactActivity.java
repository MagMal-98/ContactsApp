package com.mm.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mm.contacts.Contact.ContactListContent;
import static com.mm.contacts.Contact.ContactListContent.ITEMS;

public class NewContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        add_contact();
    }

    public void add_contact() {
        Button addButton;
        addButton = findViewById(R.id.add_new_contact_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText contactNameEditTxt = findViewById(R.id.Name);
                EditText contactSurnameEditTxt = findViewById(R.id.Surname);
                EditText contactBirthdayEditTxt = findViewById(R.id.Birthday);
                EditText contactPhoneEditTxt = findViewById(R.id.Phone_number);

                String contactName = contactNameEditTxt.getText().toString();
                String contactSurname = contactSurnameEditTxt.getText().toString();
                String contactBirthdy = contactBirthdayEditTxt.getText().toString();
                String contactPhone = contactPhoneEditTxt.getText().toString();

                if(contactName.isEmpty()){
                    contactNameEditTxt.setError(getString(R.string.writename));
                    return;
                }
                if(contactSurname.isEmpty()){
                    contactName = "";
                }
                if(contactBirthdy.isEmpty()){
                    contactBirthdayEditTxt.setError(getString(R.string.writebirthday));
                    return;
                } else {
                    if( checkDate(contactBirthdy) == -1 ){
                        contactBirthdayEditTxt.setError(getString(R.string.dateFormat));
                        return;
                    }
                }
                if(contactPhone.isEmpty()){
                    contactPhoneEditTxt.setError(getString(R.string.writephone));
                    return;
                } else {
                    if ( !contactPhone.matches("([0-9]{9})") ){
                        contactPhoneEditTxt.setError(getString(R.string.phoneFormat));
                        return;
                    }
                }

                ContactListContent.Contact newContact = new ContactListContent.Contact( String.valueOf(ITEMS.size()+1),
                        contactName, contactSurname, contactBirthdy, contactPhone);
                ContactListContent.addItem(newContact);

                contactNameEditTxt.setText("");
                contactSurnameEditTxt.setText("");
                contactBirthdayEditTxt.setText("");
                contactPhoneEditTxt.setText("");

                finish(); //close this activity and go bac to main activity
            }
        });
    }

    private int checkDate (String date){

        int result = -1;

        if( date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") ){
            result = 1;
        }

        return result;
    }


    }
