package com.example.evans.androidapp;

import android.content.Intent;
import android.database.Cursor;
import android.renderscript.Element;
import android.support.v7.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;


public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        EditText inputuserid = findViewById(R.id.inputuserid2);
        Button search = findViewById(R.id.buttonsearch);
        Button back = findViewById(R.id.buttonback);
        LoadSpinnerData();
        Spinner spinner = findViewById(R.id.spinner);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Activity2.this, MainActivity.class);
                startActivity(intent);
                Activity2.this.finish();
            }
        });


        /**
         * Function to load the spinner data from SQLite database
         * */
        private void LoadSpinnerData {
            // database handler
            DBHelper db = new DBHelper(getApplicationContext());

            // Spinner Drop down elements
            List<String> dt = db.getDT();
            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, dt);

            // Drop down layout style - list view with radio button
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            spinner.setAdapter(dataAdapter);
        }
    }



        /*public ArrayList <Element> onSearch (String inputuserid,String dt,SQLiteDatabase  db)
        {
            String selectQuery = "SELECT * FROM LOCATION WHERE KEY_USERID=? AND DT=?";
            Cursor cursor = db.rawQuery(selectQuery,new String[]{inputuserid,dt})
            ArrayList <Element> elements = new ArrayList();
            cursor.moveToFirst();
            while(cursor.moveToNext()) {
                elements.add(new Element(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getFloat(2),
                        cursor.getFloat(3),
                        cursor.getString(4)));
            }
            cursor.close();
            return elements;
        }
        */



    }

