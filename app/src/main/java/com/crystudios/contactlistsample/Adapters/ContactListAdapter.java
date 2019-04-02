package com.crystudios.contactlistsample.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.crystudios.contactlistsample.Models.*;
import com.crystudios.contactlistsample.R;

import java.util.ArrayList;
import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Users> _userList = new ArrayList<>();
    private Context mContext;

    public ContactListAdapter (Context context, List<Users> users)
    {
        this.mContext = context;
        this._userList = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_list_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        // Set the name of the 'NicePlace'
        ((ViewHolder)viewHolder).mFirstName.setText(_userList.get(i).GetFirstName());
        ((ViewHolder)viewHolder).mLastName.setText(_userList.get(i).GetLastName());
        ((ViewHolder)viewHolder).mImage.setImageBitmap(_userList.get(i).GetAvatarImage());
    }

    @Override
    public int getItemCount() {
        return this._userList.size();
    }


    private class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImage;
        private TextView mFirstName;
        private TextView mLastName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.imgAvatar);
            mFirstName = itemView.findViewById(R.id.lblFirstName);
            mFirstName = itemView.findViewById(R.id.lblLastName);
        }
    }
}
