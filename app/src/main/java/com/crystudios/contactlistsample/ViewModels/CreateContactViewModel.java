package com.crystudios.contactlistsample.ViewModels;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.crystudios.contactlistsample.Data.IRegresPostCallback;
import com.crystudios.contactlistsample.Data.ReqresClient;
import com.crystudios.contactlistsample.Models.UserRequest;
import com.crystudios.contactlistsample.Models.UserResponse;
import com.crystudios.contactlistsample.Models.Users;

public class CreateContactViewModel extends ViewModel implements IRegresPostCallback {

    Users user;
    Context mContext;

    public void init( Context context)
    {
        user = new Users();
        mContext = context;
    }

    public void finish()
    {
        ((Activity) mContext).finish();
    }

    public void addUser(String _name, String _job)
    {
        ReqresClient client = new ReqresClient();
        client.postData(this, new UserRequest(_name, _job));

    }

    @Override
    public void getUserResponse(UserResponse user) {
        String toast = "USER : " + user.getId()
                     + " : " + user.getName()
                     + " (" + user.getJob() + " ) Created At "
                     + user.getCreatedAt();

        //Snackbar.make( new View(mContext), toast, Snackbar.LENGTH_LONG)
        //        .setAction("Action", null).show();

    }
}
