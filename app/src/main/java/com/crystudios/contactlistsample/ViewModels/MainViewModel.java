package com.crystudios.contactlistsample.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.crystudios.contactlistsample.Models.Users;

import java.util.List;

public class MainViewModel extends ViewModel {

    public MutableLiveData<List<Users>> mUsers;

    // TODO: Implement the ViewModel
}
