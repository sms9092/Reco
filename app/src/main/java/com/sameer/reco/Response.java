package com.sameer.reco;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Response {

    private String object;
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String emailAddress;
    private String bloodGroup;
    private String dob;
    private String allergies;
    private String chronicDisease;


    public String getobject() {
        return object;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getDob() {
        return dob;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getChronicDisease() {
        return chronicDisease;
    }

    public static Response fromJson(JSONObject jsonObject) {
        Response b = new Response();
        // Deserialize json into object fields
        try {
            b.object = jsonObject.getString("object");
            b.id = jsonObject.getString("id");
            b.firstName = jsonObject.getString("firstName");
            b.lastName = jsonObject.getString("lastName");
            b.gender = jsonObject.getString("gender");
            b.emailAddress = jsonObject.getString("emailAddress");
            b.bloodGroup = jsonObject.getString("bloodGroup");
            b.dob = jsonObject.getString("dob");
            b.allergies = jsonObject.getString("allergies");
            b.chronicDisease = jsonObject.getString("chronicDisease");

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return b;
    }

    // Decodes array of business json results into business model objects
    public static ArrayList<Response> fromJson(JSONArray jsonArray) {
        JSONObject userJson;
        ArrayList<Response> user = new ArrayList<Response>(jsonArray.length());
        // Process each result in json array, decode and convert to business object
        for (int i=0; i < jsonArray.length(); i++) {
            try {
                userJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Response response = Response.fromJson(userJson);
            if (response != null) {
                user.add(response);
            }
        }

        return user;
    }


}
