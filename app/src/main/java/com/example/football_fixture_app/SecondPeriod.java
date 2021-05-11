package com.example.football_fixture_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.football_fixture_app.adapters.MyFixtureListAdapter;

import static com.example.football_fixture_app.FixtureActivity.matchDays2;

public class SecondPeriod extends Fragment {

    ListView seconPeriodList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_second_period,container,false);

        MyFixtureListAdapter adapter = new MyFixtureListAdapter(getActivity(),matchDays2);
        seconPeriodList = viewGroup.findViewById(R.id.secondperiodlist);
        seconPeriodList.setAdapter(adapter);

        return viewGroup;

    }
}
