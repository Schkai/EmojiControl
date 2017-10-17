package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Analyse4 extends AppCompatActivity
{

    ArrayList<DataSet> dataSets;

    ArrayList<DataEntry> allEntries;

    ListView listView2;
    DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse4);


        dataSets = Analyse.dataSets;

        allEntries = new ArrayList<>();

        dataAdapter = new DataAdapter(this, allEntries);
        listView2 = (ListView) findViewById(R.id.analyse4_list);
        listView2.setAdapter(dataAdapter);

        updateList();

        Button back = (Button) findViewById(R.id.analyse4_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button next = (Button) findViewById(R.id.analyse4_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Analyse4.this, Analyse5.class);
                startActivity(i);
            }
        });

        Button home = (Button) findViewById(R.id.analyse4_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Analyse4.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void updateList()
    {
        updateMimikGestik();
        updateVerbal();
        updateVerhaltensimpuls();
        dataAdapter.notifyDataSetChanged();
    }

    private void updateVerbal()
    {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Verbale_Äußerung>0){
                count++;
            sum+=ds.Verbale_Äußerung;}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Verbale Äußerung", 10 * (sum / count));
            allEntries.add(de);
        }

    }

    private void updateVerhaltensimpuls()
    {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Verhaltensimpuls_nachgebend>0){
                count++;
            sum+=ds.Verhaltensimpuls_nachgebend;}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Verhaltensimpuls nachgebend", 10 * (sum / count));
            allEntries.add(de);
        }

    }


    private void updateMimikGestik()
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
            DataEntry de = new DataEntry("Mimik - Gestik", 10 * (sum / count));
            allEntries.add(de);
        }
    }
}

