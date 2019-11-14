package com.sameer.reco;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String ROOT_URL = "http://134.209.144.24/api";
    private Map<String, String> params;

    RegisterRequest(String name, String username, String password, Response.Listener<String> Listner){
        super(Method.POST,ROOT_URL,Listner, null);

        params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
