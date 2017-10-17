package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Analyse2 extends AppCompatActivity
{

    ArrayList<String> allEmos;
    ArrayList<DataSet> dataSets;

    ArrayList<DataEntry> allIntensities;

    ListView listView;
    DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse2);



        allEmos = Analyse.allEmos;
        dataSets = Analyse.dataSets;

        allIntensities = new ArrayList<>();

        dataAdapter = new DataAdapter(this, allIntensities);
        listView = (ListView) findViewById(R.id.analyse2_list);
        listView.setAdapter(dataAdapter);

        updateList();

        Button back = (Button) findViewById(R.id.analyse2_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button next = (Button) findViewById(R.id.analyse2_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Analyse2.this, Analyse3.class);
                startActivity(i);
            }
        });

        Button home = (Button) findViewById(R.id.analyse2_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Analyse2.this, MainActivity.class);
                startActivity(i);
            }
        });


    }

    private void updateList()
    {
        for (String emo : allEmos)
        {
            double sum=0.0;
            int count = 0;

            for (DataSet ds : dataSets)
            {
                if (ds.Emotion.equals(emo)) //
                {
                    count++;
                    sum+=ds.Intensity;
                }
            }

            double median = 10*(sum/count);
            DataEntry da = new DataEntry(emo, median);
            allIntensities.add(da);
        }

        dataAdapter.notifyDataSetChanged();
        setListViewHeightBasedOnChildren(listView);
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }


}
