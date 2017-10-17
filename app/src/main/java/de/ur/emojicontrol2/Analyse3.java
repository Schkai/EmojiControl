package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Analyse3 extends AppCompatActivity
{


    ArrayList<DataSet> dataSets;

    ArrayList<DataEntry> allEntries;

    ListView listView2;
    DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse3);


        dataSets = Analyse.dataSets;

        allEntries = new ArrayList<>();

        dataAdapter = new DataAdapter(this, allEntries);
        listView2 = (ListView) findViewById(R.id.analyse3_list);
        listView2.setAdapter(dataAdapter);

        updateList();

        Button back = (Button) findViewById(R.id.analyse3_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button next = (Button) findViewById(R.id.analyse3_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Analyse3.this, Analyse4.class);
                startActivity(i);
            }
        });

        Button home = (Button) findViewById(R.id.analyse3_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Analyse3.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void updateList()
    {
        updateAnspannung();
        updateTendenz();
        updateAufmerksamkeit();
        dataAdapter.notifyDataSetChanged();
    }

    private void updateTendenz()
    {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Tendenz>0){
                count++;
            sum+=ds.Tendenz;}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Tendenz: Vermeidung - Annäherung", 10 * (sum / count));
            allEntries.add(de);
        }

    }

    private void updateAufmerksamkeit()
    {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Aufmerksamkeit>0){
                count++;
            sum+=ds.Aufmerksamkeit;}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Aufmerksamkeit: Innen - Außen", 10 * (sum / count));
            allEntries.add(de);
        }

    }


    private void updateAnspannung()
    {

        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Anspannung>0){
                count++;
                sum+=ds.Anspannung;}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Anspannung - Entspannung", 10 * (sum / count));
            allEntries.add(de);
        }

    }



}
