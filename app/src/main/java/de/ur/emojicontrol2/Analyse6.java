package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Analyse6 extends AppCompatActivity {


    ArrayList<DataSet> dataSets;
    ArrayList<DataEntry> allEntries;

    ListView listView2;
    DataAdapter dataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse6);

        dataSets = Analyse.dataSets;

        allEntries = new ArrayList<>();

        dataAdapter = new DataAdapter(this, allEntries);
        listView2 = (ListView) findViewById(R.id.analyse6_list);
        listView2.setAdapter(dataAdapter);

        updateList();

        Button back = (Button) findViewById(R.id.analyse6_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Button home = (Button) findViewById(R.id.analyse6_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Analyse6.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void updateList()
    {
        genossen();
        weitere();
        nichtfort();
        verlassen();
        veraendern();
        umdeuten();
        ablenken();
        konsumiert();
        nachgeg();
        resigniert();
        verbessern();

        dataAdapter.notifyDataSetChanged();
    }

    private void verbessern()
    {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Situation_verbessern!=0) {
                count++;
                sum += (ds.Situation_verbessern + 5);
            }
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Ich habe überlegt, wie ich die Situation verbessern könnte", 10 * (sum / count));
            allEntries.add(de);
        }

    }

    private void resigniert() {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Resigniert_abgewartet!=0){
                count++;
            sum+=(ds.Resigniert_abgewartet+5);}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Ich habe resigniert abgewartet", 10 * (sum / count));
            allEntries.add(de);
        }
    }

    private void nachgeg() {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Lange_nachgegrübelt!=0){
                count++;
            sum+=(ds.Lange_nachgegrübelt+5);}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Ich habe lange nachgegrübelt", 10 * (sum / count));
            allEntries.add(de);
        }
    }

    private void konsumiert() {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Substanz_konsumiert!=0){
                count++;
            sum+=(ds.Substanz_konsumiert+5);}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Ich habe eine Substanz konsumiert", 10 * (sum / count));
            allEntries.add(de);
        }
    }

    private void ablenken() {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Versucht_abzulenken!=0){
                count++;
            sum+=(ds.Versucht_abzulenken+5);}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Ich habe versucht mich abzulenken", 10 * (sum / count));
            allEntries.add(de);
        }
    }

    private void umdeuten() {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Situation_umdeuten!=0){
                count++;
            sum+=(ds.Situation_umdeuten+5);}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Ich habe die Situation umgedeutet", 10 * (sum / count));
            allEntries.add(de);
        }
    }

    private void veraendern() {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Situation_verändern!=0){
                count++;
            sum+=(ds.Situation_verändern+5);}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Ich wollte die Situation verändern", 10 * (sum / count));
            allEntries.add(de);
        }
    }

    private void verlassen() {

        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Situation_verlassen!=0){
                count++;
            sum+=(ds.Situation_verlassen+5);}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Ich wollte die Situation verlassen", 10 * (sum / count));
            allEntries.add(de);
        }
    }

    private void genossen()
    {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Gefühl_genossen!=0){
                count++;
            sum+=(ds.Gefühl_genossen+5);}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Ich habe das Gefühl genossen", 10 * (sum / count));
            allEntries.add(de);
        }
    }

    private void weitere()
    {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Ereignisse_vorgestellt!=0){
                count++;
            sum+=(ds.Ereignisse_vorgestellt+5);}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Ich habe mir weitere positive Ereignisse vorgestellt", 10 * (sum / count));
            allEntries.add(de);
        }
    }

    private void nichtfort()
    {
        double sum=0.0;
        int count =0;
        for (DataSet ds : dataSets)
        {
            if (ds.Gefühl_nicht_fortbestehen!=0){
                count++;
            sum+=(ds.Gefühl_nicht_fortbestehen+5);}
        }

        if (count>0)
        {
            DataEntry de = new DataEntry("Das Gefühl wird nicht fortbestehen", 10 * (sum / count));
            allEntries.add(de);
        }
    }

}

