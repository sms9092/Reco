package com.sameer.reco;




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

    public Response(String object, String id, String firstName, String lastName, String gender, String emailAddress, String bloodGroup, String dob, String allergies, String chronicDisease) {
        this.object = object;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.bloodGroup = bloodGroup;
        this.dob = dob;
        this.allergies = allergies;
        this.chronicDisease = chronicDisease;
    }


}
