package com.mm.contacts.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ContactListContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Contact> ITEMS = new ArrayList<Contact>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Contact> ITEM_MAP = new HashMap<String, Contact>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    public static void addItem(Contact item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }

    private static Contact createDummyItem(int position) {
        return new Contact(1 ,String.valueOf(position), "Item " + position, makeDetails(position), "111111111");
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */

    public static int getRandomDoubleBetweenRange(int min, int max){
        Random rand = new Random();
        int randomNum = rand.nextInt((max-min)+1)+min;
        return randomNum;
    }

    public static class Contact {
        public final int avatarnum;
        public final String name;
        public final String surname;
        public final String birthday;
        public final String phone;

        public Contact(int avatarnum, String name, String surname, String birthday, String phone) {
            this.avatarnum = getRandomDoubleBetweenRange(0, 5);
            this.name = name;
            this.surname = surname;
            this.birthday = birthday;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return surname;
        }
    }

}
