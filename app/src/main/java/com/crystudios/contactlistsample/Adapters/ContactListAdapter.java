package com.crystudios.contactlistsample.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.crystudios.contactlistsample.Models.*;
import com.crystudios.contactlistsample.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

        ((ViewHolder)viewHolder).mFirstName.setText(_userList.get(i).getFirstName());
        ((ViewHolder)viewHolder).mLastName.setText(_userList.get(i).getLastName());

        // Set the image
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(_userList.get(i).getAvatar())
                .into(((ViewHolder)viewHolder).mImage);

        Log.wtf("DANIEL", _userList.get(i).getFirstName() + " " + _userList.get(i).getLastName() + " " + _userList.get(i).getAvatar());
    }

    @Override
    public int getItemCount() {
        if (_userList != null)
            return this._userList.size();
        else
            return 0;
    }


    private class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImage;
        private TextView mFirstName;
        private TextView mLastName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.imgAvatar);
            mFirstName = itemView.findViewById(R.id.lblFirstName);
            mLastName = itemView.findViewById(R.id.lblLastName);
        }
    }
}
