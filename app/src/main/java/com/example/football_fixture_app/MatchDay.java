package com.example.football_fixture_app;

import android.os.Parcel;
import android.os.Parcelable;

public class MatchDay implements Parcelable {

    Teams team1,team2;
    int awayOrHome=0;

    public MatchDay(Teams team1, Teams team2,int awayOrHome) {
        this.team1 = team1;
        this.team2 = team2;
        this.awayOrHome = awayOrHome;
    }


    protected MatchDay(Parcel in) {
        awayOrHome = in.readInt();
    }

    public static final Creator<MatchDay> CREATOR = new Creator<MatchDay>() {
        @Override
        public MatchDay createFromParcel(Parcel in) {
            return new MatchDay(in);
        }

        @Override
        public MatchDay[] newArray(int size) {
            return new MatchDay[size];
        }
    };

    public int getAwayOrHome() {
        return awayOrHome;
    }

    public void setAwayOrHome(int awayOrHome) {
        this.awayOrHome = awayOrHome;
    }

    public Teams getTeam1() {
        return team1;
    }

    public void setTeam1(Teams team1) {
        this.team1 = team1;
    }

    public Teams getTeam2() {
        return team2;
    }

    public void setTeam2(Teams team2) {
        this.team2 = team2;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(awayOrHome);
    }
}
