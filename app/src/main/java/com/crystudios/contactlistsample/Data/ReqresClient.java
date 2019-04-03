package com.crystudios.contactlistsample.Data;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.crystudios.contactlistsample.Models.ApiDataModel;
import com.crystudios.contactlistsample.Models.UserRequest;
import com.crystudios.contactlistsample.Models.UserResponse;
import com.crystudios.contactlistsample.Models.Users;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ReqresClient implements Callback<ApiDataModel> {
    static final String BASE_URL = "https://reqres.in/api/";

    IReqresGetCallback _sender;
    IRegresPostCallback _postCallback;

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

        Call<ApiDataModel> call = reqresAPI.loadChanges("status:open");
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ApiDataModel> call, Response<ApiDataModel> response) {
        if(response.isSuccessful()) {
            List<Users> changesList = response.body().getData();

            _sender.LoadList(changesList);

        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<ApiDataModel> call, Throwable t) {
        t.printStackTrace();
    }

    public void postData(IRegresPostCallback sender, UserRequest _request)
    {
        _postCallback = sender;

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ReqresAPI reqresAPI = retrofit.create(ReqresAPI.class);

        Call<UserResponse> call = reqresAPI.postUser(_request);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                _postCallback.getUserResponse(response.body());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("RetrofitPOST", "Error sending data");
            }
        });
    }
}
