package com.mm.contacts;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mm.contacts.ContactFragment.OnListFragmentInteractionListener;
import com.mm.contacts.Contact.ContactListContent.Contact;

import java.util.List;

public class MyContactRecyclerViewAdapter extends RecyclerView.Adapter<MyContactRecyclerViewAdapter.ViewHolder> {

    private final List<Contact> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyContactRecyclerViewAdapter(List<Contact> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Contact mContact = mValues.get(position);
        holder.mItem = mContact;
        holder.mName.setText(mContact.name);
        holder.mAvatarPic.setImageResource(mContact.avatarnum);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentClickInteraction(holder.mItem, v);
                }
            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mListener.onListFragmentLongClickInteraction(holder.mItem);
                return false;
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mListener.onDeleteButtonClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
       // public final TextView mIdView;
        //public final TextView mContentView;
        public final ImageView mAvatarPic;
        public final TextView mName;
        public Contact mItem;
        public ImageButton deleteButton;

        public ViewHolder(View view) {
            super(view);
            mView = view;
           // mIdView = (TextView) view.findViewById(R.id.item_number);
           // mContentView = (TextView) view.findViewById(R.id.content);
            mAvatarPic = view.findViewById(R.id.contact_pic);
            mName = view.findViewById(R.id.contact_id);
            deleteButton = view.findViewById(R.id.delete);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mName.getText() + "'";
        }
    }
}
