package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Analyse5 extends AppCompatActivity {

    ArrayList<DataSet> dataSets;
    ArrayList<DataEntry> allEntries;

    ListView listView2;
    DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse5);


        dataSets = Analyse.dataSets;

        allEntries = new ArrayList<>();

        dataAdapter = new DataAdapter(this, allEntries);
        listView2 = (ListView) findViewById(R.id.analyse5_list);
        listView2.setAdapter(dataAdapter);

        updateList();

        Button back = (Button) findViewById(R.id.analyse5_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button next = (Button) findViewById(R.id.analyse5_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Analyse5.this, Analyse6.class);
                startActivity(i);
            }
        });

        Button home = (Button) findViewById(R.id.analyse5_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Analyse5.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void updateList()
    {
        jetzt();
        vergangenheit();
        zukunft();
        selbst();
        kontrolle();
        dataAdapter.notifyDataSetChanged();
    }

    private void vergangenheit()
    {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Auslöser_Vergangenheit!=0){
                count++;
            sum+=(ds.Auslöser_Vergangenheit+5);}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Der Auslöser liegt in der Vergangenheit", 10 * (sum / count));
            allEntries.add(de);
        }
    }

    private void zukunft()
    {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Auslöser_Zukunft!=0){
                count++;
            sum+=(ds.Auslöser_Zukunft+5);}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Der Auslöser liegt in der Zukunft", 10 * (sum / count));
            allEntries.add(de);
        }
    }



    private void jetzt()
    {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Auslöser_jetzt!=0){
                count++;
            sum+=(ds.Auslöser_jetzt+5);}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Der Auslöser liegt in der Gegenwart", 10 * (sum / count));
            allEntries.add(de);
        }


    }

    private void selbst()
    {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Auslöser_Selbst_Andere>0){
                count++;
            sum+=ds.Auslöser_Selbst_Andere;}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Das Gefühl wurde von anderen ausgelöst", 10 * (sum / count));
            allEntries.add(de);
        }

    }

    private void kontrolle()
    {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Auslöser_Kontrollierbarkeit>0){
                count++;
            sum+=ds.Auslöser_Kontrollierbarkeit;}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Ich konnte das Gefühl kontrollieren", 10 * (sum / count));
            allEntries.add(de);
        }

    }
}
