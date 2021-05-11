package com.example.football_fixture_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;


import com.example.football_fixture_app.adapters.MyListAdapter;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TeamsDaoInterface teamsDIF;
    ListView list;
    private Button btnFixture,btnDarkLight;
    ArrayList<Teams> allTeams = new ArrayList<>();

    static Boolean isDarkModeOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Premiere League");


        //Dark Mode u burada ayarlıyorum
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        list = findViewById(R.id.list_all_team);
        btnFixture = findViewById(R.id.btnFixture);
        btnDarkLight = findViewById(R.id.btnDarkLight);

        btnDarkLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDarkModeOn == true){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    isDarkModeOn = false;
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    isDarkModeOn = true;
                }
            }
        });

        teamsDIF = ApiUtils.getTeamsDaoInterface();
        getAllTeams();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    Toast.makeText(getApplicationContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 1) {
                    Toast.makeText(getApplicationContext(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {
                    Toast.makeText(getApplicationContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {
                    Toast.makeText(getApplicationContext(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {
                    Toast.makeText(getApplicationContext(),"Place Your Fifth Option Code", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void getAllTeams() {
        try{
            teamsDIF.allTeams().enqueue(new Callback<TeamsReply>() {
                @Override
                public void onResponse(Call<TeamsReply> call, Response<TeamsReply> response) {
                    ArrayList<Teams> teamsList = response.body().getTeams();

                    MyListAdapter adapter=new MyListAdapter(MainActivity.this, teamsList);
                    list = findViewById(R.id.list_all_team);
                    list.setAdapter(adapter);

                    btnFixture.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            System.out.println("Fikstür butonu çalıştı.");
                            System.out.println(teamsList.size()+"-------------------------");
                            Intent intent = new Intent(MainActivity.this,FixtureActivity.class);
                            intent.putExtra("key",teamsList);
                            startActivity(intent);
                        }
                    });



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

/*
switchButton = findViewById(R.id.switch_actionbar);

        switchButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isTouched = true;
                return false;
            }
        });

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isTouched) {
                    isTouched = false;
                    if (isChecked) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    }
                    else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    }
                }
            }
        });
 */