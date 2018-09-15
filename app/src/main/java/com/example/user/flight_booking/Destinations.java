package com.example.user.flight_booking;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


public class Destinations extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rowlayout);



//ALERT DIALOG
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Destinations.this);
        builder1.setMessage("Choose your Destination !");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder1.show();
//LIST OF DESTINATIONS
        String[] values = new String[] { "Tunisia", "India", "Tailand","Korea", "Switzerland", "Canada","France", "Italy", "Turkey" ,"Espagne","United Kingdom","Mexico","Almagne"};
        MonAdaptateurDeListe adaptateur = new MonAdaptateurDeListe(this, values);
        setListAdapter(adaptateur);


    }






}
