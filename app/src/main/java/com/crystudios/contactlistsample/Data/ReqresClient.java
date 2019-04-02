package com.crystudios.contactlistsample.Data;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.crystudios.contactlistsample.Models.Users;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ReqresClient implements Callback<List<Users>> {
    static final String BASE_URL = "https://reqres.in/api/";

    IReqresGetCallback _sender;

    public void start(IReqresGetCallback sender) {

        _sender = sender;

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ReqresAPI reqresAPI = retrofit.create(ReqresAPI.class);

        Call<List<Users>> call = reqresAPI.loadChanges("status:open");
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
        if(response.isSuccessful()) {
            List<Users> changesList = response.body();

            _sender.LoadList(changesList);

        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Users>> call, Throwable t) {
        t.printStackTrace();
    }
}
