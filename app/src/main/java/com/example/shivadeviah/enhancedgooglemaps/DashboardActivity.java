package com.example.shivadeviah.enhancedgooglemaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    public static boolean isLoggedIn = false;

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

    }

    public boolean isUserPartOfGroup()
    {
        // TODO: complete this
        return false;
    }

    @Override
    protected void onResume()
    {
        // Change elements on the UI depending on whether the user is logged in or not
        // TODO: check if this works
        super.onResume();

        String username = getIntent().getStringExtra("username");

        isLoggedIn = (username != null);

        //onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;
        if(!isLoggedIn)
        {
            getMenuInflater().inflate(R.menu.menu_anonymous, menu);
        }
        else
        {
            getMenuInflater().inflate(R.menu.menu_loggedin, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.action_login:
                intent = new Intent(DashboardActivity.this, LoginActivity.class);

                startActivity(intent);
                return true;

            case R.id.action_help:
                // TODO

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    public void callFirstFeature(View v)
    {
        startActivity(new Intent(DashboardActivity.this, FreestyleActivity.class));
    }

    public void callSecondFeature(View v)
    {
        startActivity(new Intent(DashboardActivity.this, RoundaboutActivity.class));
    }

    public void callThirdFeature(View v)
    {
        Intent intent;
        if(!isLoggedIn) {
            startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
        }

        if(!isUserPartOfGroup())
        {
            intent = new Intent(DashboardActivity.this, CreateGroupActivity.class);
        }

        else {
            intent = new Intent(DashboardActivity.this, GroupTripDashboardActivity.class);
        }

        startActivity(intent);
    }

    public void callFourthFeature(View v)
    {
        if(!isLoggedIn)
        {
            startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
        }

        startActivity(new Intent(DashboardActivity.this, TravelDiaryActivity.class));

    }



}
