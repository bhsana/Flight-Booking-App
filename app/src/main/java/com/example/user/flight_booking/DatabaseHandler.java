package com.example.user.flight_booking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 11/30/2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "UserDB";
    public static final String TABLE_USER = "User";

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_COUNTRY = "country";
    public static final String KEY_GENDER = "gender";

    public DatabaseHandler(Context context, String NAME, SQLiteDatabase.CursorFactory factory, int VERSION) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    // Creation Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER +
                "(" + KEY_USERNAME + " TEXT PRIMARY KEY, "
                + KEY_PASSWORD + " TEXT,"
                + KEY_COUNTRY + " TEXT ,"
        + KEY_GENDER + " TEXT )";
        db.execSQL(CREATE_USER_TABLE);
    }

    // Upgrading BD
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop ancienne table s'il existe)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        // Create tables une autre fois
        onCreate(db);
    }

    public void addUser(User user) {
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, user.getUsername());
        values.put(KEY_PASSWORD, user.getPassword());
        values.put(KEY_COUNTRY, user.getCountry());
        values.put(KEY_GENDER, user.getGender());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USER, null, values);
        db.close();


    }

    public User findUser(String username,String password) {

        String query = "select * from " + TABLE_USER + " where " + KEY_USERNAME + "= \"" + username + "\" and "+ KEY_PASSWORD + "= \"" + password + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        User user = new User();
        if (cursor.moveToFirst()) {

            user.setUsername(cursor.getString(0));
            user.setPassword(cursor.getString(1));
            user.setCountry(cursor.getString(2));
            user.setGender(cursor.getString(3));

            cursor.close();
        } else {
            user = null;
        }
        db.close();
        return user;
    }








}
