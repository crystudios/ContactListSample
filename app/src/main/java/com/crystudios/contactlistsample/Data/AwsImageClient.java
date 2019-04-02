package com.crystudios.contactlistsample.Data;

import android.graphics.BitmapFactory;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AwsImageClient implements Callback{

    IGetImageCallback sender;

    public void getImage(IGetImageCallback _sender, String _url) {

        sender = _sender;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(_url)
                .build();

        client.newCall(request).enqueue(this);
    }

    @Override
    public void onFailure(Call call, IOException e) {
        System.out.println("request failed: " + e.getMessage());
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        sender.setBitmap(BitmapFactory.decodeStream(response.body().byteStream()));
    }
}
