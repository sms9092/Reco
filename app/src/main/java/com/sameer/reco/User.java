package com.sameer.reco;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("response")
    private String Response;

    @SerializedName("name")
    private String Name;


    public String getName() {
        return Name;
    }

    public String getResponse() {
        return Response;
    }
}
