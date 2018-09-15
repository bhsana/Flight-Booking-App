package com.example.user.flight_booking;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import static android.R.attr.dial;
import static android.content.Intent.ACTION_DIAL;


public class Contactus extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
    }

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
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

    public void Call(View v)
    {  Intent dial = new Intent();
        String PhoneNo="+216 11 111 111";
        dial.setAction("android.intent.action.DIAL");
        dial.setData(Uri.parse("tel:"+PhoneNo));
        startActivity(dial);

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + PhoneNo));
        startActivity(dial);


    }
    public void SMS(View v)
    { String PhoneNo="+216 11 111 111";
        Uri smsUri = Uri.parse(PhoneNo);
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra("address",PhoneNo);
        intent.setType("text/plain");
        startActivity(intent);


    }

    public void Findus(View v)
    {
        String geoCode ="geo:36.800287, 10.185343";
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(geoCode));
        startActivity(intent);

    }

}
