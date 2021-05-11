package com.example.football_fixture_app;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamsReply {

    @SerializedName("premiere_league")
    @Expose
    private ArrayList<Teams> teams = null;
    @SerializedName("success")
    @Expose
    private Integer success;

    public ArrayList<Teams> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Teams> teams) {
        this.teams = teams;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

}