package com.example.football_fixture_app.adapters;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.football_fixture_app.R;
import com.example.football_fixture_app.Teams;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<Teams> {

    private final Activity context;
    //private final String[] maintitle;
    //private final Integer[] imgid;
    private List<Teams> teamsList;

    public MyListAdapter(Activity context, List<Teams> teamsList) {
        super(context, R.layout.list_item, teamsList);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.teamsList=teamsList;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.teams_fixture_name);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.teams_fixture_logo);


        titleText.setText(teamsList.get(position).getName());
        Picasso.get().load(teamsList.get(position).getLogo()).into(imageView);
        //imageView.setImageResource(R.drawable.arsenal);


        return rowView;

    };
}

//  teamsList.get(position).getLogo()