package com.crystudios.contactlistsample.Data;

import com.crystudios.contactlistsample.Models.Users;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ReqresAPI {
    @GET("users")
    Call<List<Users>> loadChanges(@Query("q") String status);
}
