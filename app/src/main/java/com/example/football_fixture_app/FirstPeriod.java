package com.example.football_fixture_app;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.football_fixture_app.adapters.MyFixtureListAdapter;

import java.util.ArrayList;

import static com.example.football_fixture_app.FixtureActivity.matchDays;


public class FirstPeriod extends Fragment {

    ListView firstPeriodList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_first_period,container,false);

        MyFixtureListAdapter adapter = new MyFixtureListAdapter(getActivity(),matchDays);
        firstPeriodList = viewGroup.findViewById(R.id.firstperiodlist);
        firstPeriodList.setAdapter(adapter);

        return viewGroup;

    }
}
