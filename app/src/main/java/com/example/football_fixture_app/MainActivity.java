package com.example.football_fixture_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TeamsDaoInterface teamsDIF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dark Mode u burada ayarlıyorum
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        teamsDIF = ApiUtils.getTeamsDaoInterface();

        allTeams();

    }

    public void allTeams(){
        try{
            teamsDIF.allTeams().enqueue(new Callback<TeamsReply>() {
                @Override
                public void onResponse(Call<TeamsReply> call, Response<TeamsReply> response) {
                    List<Teams> teamsList = response.body().getTeams();

                    for (Teams team: teamsList) {
                        System.out.println("**************");
                        System.out.println(team.getId());
                        System.out.println(team.getName());
                        System.out.println(team.getLogo());
                    }

                }

                @Override
                public void onFailure(Call<TeamsReply> call, Throwable t) {
                    System.out.println("--------------------------------- on faiulure çalıştı");
                }
            });
        }catch (NullPointerException Ex){
            System.out.println("Null Pointer Exception yakalandı.");
        }
    }

}