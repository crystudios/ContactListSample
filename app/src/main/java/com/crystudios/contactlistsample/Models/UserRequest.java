package com.crystudios.contactlistsample.Models;

import java.util.HashMap;
import java.util.Map;

public class UserRequest {
    private String name;
    private String job;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public UserRequest(String name, String job)
    {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
