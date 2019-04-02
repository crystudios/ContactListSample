package com.crystudios.contactlistsample.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.crystudios.contactlistsample.Data.IReqresGetCallback;
import com.crystudios.contactlistsample.Data.ReqresClient;
import com.crystudios.contactlistsample.Models.Users;

import java.util.List;

public class MainViewModel extends ViewModel implements IReqresGetCallback {

    private MutableLiveData<List<Users>> mUsers;

    public void init()
    {
        mUsers = new MutableLiveData<>();
        ReqresClient client = new ReqresClient();
        client.start(this);
    }

    @Override
    public void LoadList(List<Users> list) {
        mUsers.setValue(list);
    }

    public MutableLiveData<List<Users>> getUserList()
    {
        return this.mUsers;
    }

    // TODO: Implement the ViewModel
}
