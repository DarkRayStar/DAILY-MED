package com.united.dailymed.Diet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.united.dailymed.Adapter.DietRVAdapter;
import com.united.dailymed.Heart.Heart;
import com.united.dailymed.Home.Home;
import com.united.dailymed.Model.DietModel;
import com.united.dailymed.Pill.Pill;
import com.united.dailymed.R;
import com.united.dailymed.Utils.DietDBHandler;
import com.united.dailymed.Water.Water;

import java.util.ArrayList;

public class DietPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan);
        ArrayList<DietModel> DietModelArrayList;
        DietDBHandler DietdbHandler;
        DietRVAdapter courseRVAdapter;
        RecyclerView coursesRV;

        // initializing our all variables.
        DietModelArrayList = new ArrayList<>();
        DietdbHandler = new DietDBHandler(DietPlan.this);

        // getting our course array
        // list from db handler class.
        DietModelArrayList = DietdbHandler.getAllDietPlans();

        // on below line passing our array lost to our adapter class.
        courseRVAdapter = new DietRVAdapter(DietModelArrayList, DietPlan.this);
        coursesRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DietPlan.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(courseRVAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Heart Selected
        bottomNavigationView.setSelectedItemId(R.id.Fitness);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()) {
                    case R.id.Heart:
                        startActivity(new Intent(getApplicationContext(), Heart.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Fitness:
                        startActivity(new Intent(getApplicationContext(), Diet.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Pill:
                        startActivity(new Intent(getApplicationContext(), Pill.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Water:
                        startActivity(new Intent(getApplicationContext(), Water.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }

        });
    }
}