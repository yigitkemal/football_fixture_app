package com.example.football_fixture_app;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TeamsDaoInterface {

    @GET("premiere_league/all_teams.php")
    Call<TeamsReply> allTeams();

    @POST("premiere_league/all_teams_search.php")
    @FormUrlEncoded
    Call<TeamsReply> teamSearch(@Field("name") String name);

}
