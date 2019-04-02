package com.crystudios.contactlistsample.Models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Users {

    private String id;
    private String first_name;
    private String last_name;
    private String avatar;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Users ()
    {
        this.id = "";
        this.first_name = "";
        this.last_name = "";
        this.avatar = "";
    }

    public Users (String _id, String _first_name, String _last_name, String _avatar)
    {
        this.id = _id;
        this.first_name = _first_name;
        this.last_name = _last_name;
        this.avatar = _avatar;
    }

    public String getId()
    {
        return this.id;
    }
    public void setId( String _id)
    {
        this.id = _id;
    }
    public String getFirstName()
    {
        return this.first_name;
    }
    public void setFirstName( String _first_name)
    {
        this.first_name = _first_name;
    }
    public String getLastName()
    {
        return this.last_name;
    }
    public void setLastName( String _last_name)
    {
        this.last_name = _last_name;
    }
    public String getAvatar()
    {
        return this.avatar;
    }
    public void setAvatar( String _avatar)
    {
        this.avatar = _avatar;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
