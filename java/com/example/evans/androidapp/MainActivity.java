package com.example.evans.androidapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import static com.example.evans.androidapp.DBHelper.KEY_ID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DBHelper dbHelper = new DBHelper(MainActivity.this);

        final EditText inputid = findViewById(R.id.number_inputid);
        final String strinputid = inputid.getText().toString();
        final EditText inputuserid = findViewById(R.id.text_inputuserid);
        final String strinputuserid = inputuserid.getText().toString();
        final EditText inputlat = findViewById(R.id.numberDecimal_inputlat);
        final String strinputlat =  inputlat.getText().toString();
        final EditText inputlong = findViewById(R.id.numberDecimal_inputlong);
        final String strinputlong =  inputlong.getText().toString();
        final EditText inputdt = findViewById(R.id.date_inputdt);
        final String strinputdt = inputdt.getText().toString();

        Button save = findViewById(R.id.buttonsave);
        Button next = findViewById(R.id.buttonnext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(strinputid )){
                    inputid.setError("This item name cannot be empty");
                }
                if(TextUtils.isEmpty(strinputuserid )){
                    inputuserid.setError("This item name cannot be empty");
                }
                if(TextUtils.isEmpty(strinputlat )){
                    inputlat.setError("This item name cannot be empty");
                }
                if(TextUtils.isEmpty(strinputlong )){
                    inputlong.setError("This item name cannot be empty");
                }
                if(TextUtils.isEmpty(strinputdt )){
                    inputdt.setError("This item name cannot be empty");
                }

                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Activity2.class);
                startActivity(intent);
                MainActivity.this.finish();

            }

        });
        final SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();


        findViewById(R.id.buttonsave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ContentValues cv = new ContentValues();
            cv.put(DBHelper.KEY_ID,inputid.getText().toString());
            cv.put(DBHelper.KEY_USERID,inputuserid.getText().toString());
            cv.put(DBHelper.KEY_LATITUDE,inputlat.getText().toString());
            cv.put(DBHelper.KEY_LONGITUDE,inputlong.getText().toString());
            cv.put(DBHelper.KEY_DT,inputlong.getText().toString());
                dbHelper.Insert(cv,sqLiteDatabase);
                //clear text after successful input
                inputid.getText().clear();
                inputuserid.getText().clear();
                inputlat.getText().clear();
                inputlong.getText().clear();
                inputdt.getText().clear();
                //https://stackoverflow.com/questions/5308200/clear-text-in-edittext-when-entered
            }
        });

    }

}
