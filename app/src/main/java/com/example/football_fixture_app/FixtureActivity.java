package com.example.football_fixture_app;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.football_fixture_app.adapters.MyFixtureListAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class FixtureActivity extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;

    ListView listFixture, listFixture2;
    Random random = new Random();

    public static ArrayList<MatchDay> matchDays;
    public static ArrayList<MatchDay> matchDays2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fixture_activity);

        ArrayList<Teams> teamsList = (ArrayList<Teams>) getIntent().getSerializableExtra("key");
        matchDays = new ArrayList<>();
        matchDays2 = new ArrayList<>();

        fixtureAlgorithm(teamsList);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new FirstPeriod());

    }

    private void fixtureAlgorithm(ArrayList<Teams> teamsList) {
        for (int j = 0; j <teamsList.size() ; j++) {
            for (int i = 0; i <teamsList.size() ; i++) {
                System.out.println(random.nextInt(2));
                try{
                    if(teamsList.get(i) != teamsList.get((teamsList.size()-1)-(i+j))){
                        matchDays.add(new MatchDay(teamsList.get(i),teamsList.get((teamsList.size()-1)-(i+j)),random.nextInt(2)));
                    }
                }catch (ArrayIndexOutOfBoundsException ex){
                    System.out.println("Array boyutu aşıldı.");
                }
            }
        }

        for (int j = teamsList.size()-1 ; 0<j ; j--) {
            for (int i = teamsList.size()-1; 0<i ; i--) {
                System.out.println(random.nextInt(2));
                try {
                    if(teamsList.get(i) != teamsList.get((teamsList.size()-1)-(i+j))){
                        matchDays2.add(new MatchDay(teamsList.get(i),teamsList.get((teamsList.size()-1)-(i+j)),random.nextInt(2)));
                    }
                }catch (ArrayIndexOutOfBoundsException ex){
                    System.out.println("Array boyutu aşıldı.");
                }
            }
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new FirstPeriod();
                    break;
                case R.id.navigation_albums:
                    selectedFragment = new SecondPeriod();
                    break;
            }
            loadFragment(selectedFragment);
            return true;
        }
    };

    private void loadFragment(Fragment fragment) { //fragmentlarımızı çağırdığımız fonksiyon

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}


/*

 */