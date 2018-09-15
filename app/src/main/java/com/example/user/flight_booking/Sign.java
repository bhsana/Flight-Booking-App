package com.example.user.flight_booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Sign extends AppCompatActivity {
    EditText un,pass,count;
    RadioButton Bf;
    RadioGroup radio;
    String n,p,c,f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        un=(EditText) findViewById(R.id.userForm);
        pass=(EditText) findViewById(R.id.passwordForm);
        count=(EditText)findViewById(R.id.countryForm);
        radio = (RadioGroup) findViewById(R.id.group);


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
public void Submit(View v) {
    DatabaseHandler dbHandler = new DatabaseHandler(this, null, null, 1);
    int selectedId = radio.getCheckedRadioButtonId();

    // find the radiobutton by returned id
    Bf = (RadioButton) findViewById(selectedId);
    f=Bf.getText().toString();
    n=un.getText().toString();
    p=pass.getText().toString();
    c=count.getText().toString();

    User user = new User(n,p,c,f);
    dbHandler.addUser(user);
    Toast.makeText(getApplicationContext(),"Accout Created : "+n,Toast.LENGTH_LONG).show();

}
}
