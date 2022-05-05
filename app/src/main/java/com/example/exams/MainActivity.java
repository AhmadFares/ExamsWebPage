package com.example.exams;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            SQLiteDatabase sql = this.openOrCreateDatabase("Exams", MODE_PRIVATE, null);
            sql.execSQL("CREATE Table IF NOT EXISTS exams (name VARCHAR)");
        sql.execSQL("INSERT INTO exams(name) VALUES ('MobileComputing')");
        sql.execSQL("INSERT INTO exams(name) VALUES ('Game')");



    }catch(Exception e){
        e.printStackTrace();
    }
    }
}
