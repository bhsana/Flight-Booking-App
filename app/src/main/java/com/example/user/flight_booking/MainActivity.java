package com.example.user.flight_booking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.menu_home:
            Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                return true;

            case R.id.menu_dest:
            Intent intent2 = new Intent(this, Destinations.class);
                startActivity(intent2);
                return true;
            case R.id.menu_book:
            Intent intent3 = new Intent(this, Book.class);
                startActivity(intent3);
                return true;
            case R.id.menu_log:
            Intent intent4 = new Intent(this, Log.class);
                startActivity(intent4);
                return true;
            case R.id.menu_share:
            Intent intent6 = new Intent(this, Share.class);
                startActivity(intent6);
                return true;
            case R.id.menu_contact:
            Intent intent5 = new Intent(this, Contactus.class);
                startActivity(intent5);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    public void Destin(View v)
    {
        Intent i1 = new Intent(this, Destinations.class);
        this.startActivity(i1);
    }
    public void Book(View v)
    {
        Intent i2 = new Intent(this, Book.class);
        startActivity(i2);

    }
    public void Log(View v)
    {
        Intent i3 = new Intent(this, Log.class);
       startActivity(i3);

    }

    public void Share(View v)
    {
        Intent i4 = new Intent(this,Share.class);
        startActivity(i4);

    }
    public void Contact(View v)
    {
        Intent i5 = new Intent(this, Contactus.class);
       startActivity(i5);

    }



}
