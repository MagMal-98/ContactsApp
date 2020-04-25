package com.mm.contacts.Contact;

import android.os.Parcel;
import android.os.Parcelable;

import com.mm.contacts.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class ContactListContent {

    public static final List<Contact> ITEMS = new ArrayList<Contact>();

    public static final Map<String, Contact> ITEM_MAP = new HashMap<String, Contact>();

    private static final int COUNT = 5;

    private static String[] Names = {"", "Cassandra", "Alex", "Adam", "Lena", "Jane"};
    private static String[] Surnames = {"", "Fray", "Gomez", "Smith", "Hastings", "Doe"};
    private static String[] B_dates = {"", "22/07/1995", "19/03/1993", "27/11/1991", "13/12/1989", "29/09/1998"};
    private static String[] Numbers = {"", "449827760", "881527865", "654888910", "999383712", "773126722"};


    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    public static void addItem(Contact item) {
        ITEMS.add(item);
       // ITEM_MAP.put(item.name, item);
    }

    public static void deleteItem(int position){
        ITEMS.remove(position);
    }

    private static Contact createDummyItem(int position) {
        return new Contact(String.valueOf(position), Names[position], Surnames[position], B_dates[position], Numbers[position]);
    }

   /* private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Nazwisko");
       // builder.append("Details about Item: ").append(position);
       // for (int i = 0; i < position; i++) {
        //    builder.append("\nMore details information here.");
       // }
        return builder.toString();
    }*/


    public static int getRandomDoubleBetweenRange(int min, int max){
        Random rand = new Random();
        int randomNum = rand.nextInt((max-min)+1)+min;
        return randomNum;
    }

    public static class Contact implements Parcelable {
        public final String id;
        public final String name;
        public final String surname;
        public final String birthday;
        public final String phone;
        public final int avatarnum;

        public Contact(String id, String name, String surname, String birthday, String phone) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.birthday = birthday;
            this.phone = phone;
            this.avatarnum = Avatar_pic();
        }

        protected Contact(Parcel in){
            id = in.readString();
            name = in.readString();
            surname = in.readString();
            birthday = in.readString();
            phone = in.readString();
            avatarnum = in.readInt();
        }

        public static final Creator<Contact> CREATOR = new Creator<Contact>() {
            @Override
            public Contact createFromParcel(Parcel in) {
                return new Contact(in);
            }

            @Override
            public Contact[] newArray(int size) {
                return new Contact[size];
            }
        };

        @Override
        public String toString() {
            return name;
        }

        private int Avatar_pic(){
            switch ((int) (Math.random() * (5))) {  //Math.random() * (max - min + 1) + min
                case 0: return R.drawable.avatar_1;
                case 1: return R.drawable.avatar_2;
                case 3: return R.drawable.avatar_3;
                case 4: return R.drawable.avatar_4;
                case 5: return R.drawable.avatar_5;
                default: return R.drawable.avatar_1;
            }
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags){
            dest.writeString(id);
            dest.writeString(name);
            dest.writeString(surname);
            dest.writeString(birthday);
            dest.writeString(phone);
            dest.writeInt(avatarnum);
        }
    }

}
