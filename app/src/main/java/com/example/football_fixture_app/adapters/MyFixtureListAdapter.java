package com.example.football_fixture_app.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.football_fixture_app.MatchDay;
import com.example.football_fixture_app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyFixtureListAdapter extends ArrayAdapter<MatchDay> {

    private final Activity context;
    private List<MatchDay> matchDays;

    public MyFixtureListAdapter(Activity context, List<MatchDay> matchDays) {
        super(context, R.layout.list_item, matchDays);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.matchDays =matchDays;
    }



    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_fixture_item, null,true);
        View rowView2=inflater.inflate(R.layout.list_fixture_item, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.teams_fixture_name);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.teams_fixture_logo);

        TextView titleText2 = (TextView) rowView.findViewById(R.id.teams_fixture_name2);
        ImageView imageView2 = (ImageView) rowView.findViewById(R.id.teams_fixture_logo2);


        if(matchDays.get(position).getAwayOrHome() == 1){
            titleText.setText(matchDays.get(position).getTeam1().getName());
            Picasso.get().load(matchDays.get(position).getTeam1().getLogo()).into(imageView);
            titleText2.setText(matchDays.get(position).getTeam2().getName());
            Picasso.get().load(matchDays.get(position).getTeam2().getLogo()).into(imageView2);
        }else{
            titleText.setText(matchDays.get(position).getTeam2().getName());
            Picasso.get().load(matchDays.get(position).getTeam2().getLogo()).into(imageView);
            titleText2.setText(matchDays.get(position).getTeam1().getName());
            Picasso.get().load(matchDays.get(position).getTeam1().getLogo()).into(imageView2);
        }


        return rowView;
    }






}

/*


            titleText.setText(teamsList.get(position).getName());
            Picasso.get().load(teamsList.get(position).getLogo()).into(imageView);

            titleText2.setText(teamsList.get(19-position).getName());
            Picasso.get().load(teamsList.get(19-position).getLogo()).into(imageView2);


        for (int i = 0; i <teamsList.size()/2 ; i++) {
            titleText.setText(teamsList.get(i).getName());
            Picasso.get().load(teamsList.get(i).getLogo()).into(imageView);

            titleText2.setText(teamsList.get((teamsList.size()/2)-i).getName());
            Picasso.get().load(teamsList.get((teamsList.size()/2)-i).getLogo()).into(imageView2);
        }

 */