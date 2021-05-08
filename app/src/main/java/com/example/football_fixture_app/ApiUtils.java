package com.example.football_fixture_app;

public class ApiUtils {

    public  static  final String BASE_URL = "http://thetreemedia.com/";

    public static TeamsDaoInterface getTeamsDaoInterface(){
        return  RetrofitClient.getClient(BASE_URL).create(TeamsDaoInterface.class);
    }

}
