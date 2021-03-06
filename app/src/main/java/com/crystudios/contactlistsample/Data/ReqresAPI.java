package com.crystudios.contactlistsample.Data;

import com.crystudios.contactlistsample.Models.ApiDataModel;
import com.crystudios.contactlistsample.Models.UserRequest;
import com.crystudios.contactlistsample.Models.UserResponse;
import com.crystudios.contactlistsample.Models.Users;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ReqresAPI {
    @GET("users?per_page=100")
    Call<ApiDataModel> loadChanges(@Query("q") String status);

    @POST("users")
    Call<UserResponse> postUser(@Body UserRequest user);

}
