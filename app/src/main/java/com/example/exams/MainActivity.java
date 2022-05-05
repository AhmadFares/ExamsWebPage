package com.example.exams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView Lview;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lview=(ListView) findViewById(R.id.list);
        arrayList=new ArrayList<>();
        adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
        Lview.setAdapter(adapter);

        Lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = (String) adapterView.getItemAtPosition(i);
                Log.i(selectedItem, "akal");
                if(selectedItem.equals("        Game ")){
                    Intent obj = new Intent(getApplicationContext(), Web.class);
                    startActivity(obj);
                }

            }
        });


        try{


            SQLiteDatabase sql = this.openOrCreateDatabase("Exams", MODE_PRIVATE, null);
            sql.execSQL("CREATE Table IF NOT EXISTS exams (name VARCHAR)");
//        sql.execSQL("INSERT INTO exams(name) VALUES ('MobileComputing')");
//        sql.execSQL("INSERT INTO exams(name) VALUES ('NLP')");
//            sql.execSQL("INSERT INTO exams(name) VALUES ('Discrete II')");
//            sql.execSQL("INSERT INTO exams(name) VALUES ('Actuarial Mathematics')");
//            sql.execSQL("INSERT INTO exams(name) VALUES ('Game')");

//   sql.execSQL("DELETE  FROM exams");


        Cursor c = sql.rawQuery("Select * from exams", null);
        int examname = c.getColumnIndex("name");
        c.moveToFirst();

        while (c != null) {
            String name = "        " +c.getString(examname) + " " ;
            arrayList.add(name);
//            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
            c.moveToNext();
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    }
}
