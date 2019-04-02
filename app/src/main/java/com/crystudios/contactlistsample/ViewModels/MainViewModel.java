package com.crystudios.contactlistsample.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.crystudios.contactlistsample.Data.IReqresGetCallback;
import com.crystudios.contactlistsample.Data.ReqresClient;
import com.crystudios.contactlistsample.Models.Users;

import java.util.List;

public class MainViewModel extends ViewModel implements IReqresGetCallback {

    public MutableLiveData<List<Users>> mUsers;

    public void init()
    {
        ReqresClient client = new ReqresClient();
        client.start(this);
    }

    @Override
    public void LoadList(List<Users> list) {
        mUsers.setValue(list);
    }

    // TODO: Implement the ViewModel
}
