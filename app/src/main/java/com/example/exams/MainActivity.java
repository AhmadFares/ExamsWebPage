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
                    String URRL="https://www.edx.org/learn/game-development";
                    Intent obj = new Intent(getApplicationContext(), Web.class);
                    obj.putExtra("GameUrl", URRL);
                    startActivity(obj);
                }
                if(selectedItem.equals("        MobileComputing ")){
                    String URRL="https://ionicframework.com/";
                    Intent obj = new Intent(getApplicationContext(), Web.class);
                    obj.putExtra("GameUrl", URRL);
                    startActivity(obj);
                }
                if(selectedItem.equals("        NLP ")){
                    String URRL="https://www.codecademy.com/learn/natural-language-processing?g_network=g&g_device=c&g_adid=525783088229&g_keyword=natural%20language%20learning&g_acctid=243-039-7011&g_adtype=search&g_campaign=ROW+Language%3A+Pro+-+Exact&g_keywordid=kwd-296866638144&g_campaignid=10074200768&g_adgroupid=102650145273&utm_id=t_kwd-296866638144:ag_102650145273:cp_10074200768:n_g:d_c&utm_term=natural%20language%20learning&utm_campaign=ROW%20Language%3A%20Pro%20-%20Exact&utm_source=google&utm_medium=paid-search&utm_content=525783088229&hsa_acc=2430397011&hsa_cam=10074200768&hsa_grp=102650145273&hsa_ad=525783088229&hsa_src=g&hsa_tgt=kwd-296866638144&hsa_kw=natural%20language%20learning&hsa_mt=e&hsa_net=adwords&hsa_ver=3&gclid=CjwKCAjw682TBhATEiwA9crl38LyyS5MAVZqCNPyvEm0EohyLDx9f6e95HeK-bSRGXDY2XMw4DVVvxoCJbYQAvD_BwE";
                    Intent obj = new Intent(getApplicationContext(), Web.class);
                    obj.putExtra("GameUrl", URRL);
                    startActivity(obj);
                }
                if(selectedItem.equals("        Actuarial Mathematics ")){
                    String URRL="https://www.edx.org/learn/actuarial-science";
                    Intent obj = new Intent(getApplicationContext(), Web.class);
                    obj.putExtra("GameUrl", URRL);
                    startActivity(obj);
                }
                if(selectedItem.equals("        Discrete II ")){
                    String URRL="https://www.codecademy.com/learn/discrete-math";
                    Intent obj = new Intent(getApplicationContext(), Web.class);
                    obj.putExtra("GameUrl", URRL);
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
