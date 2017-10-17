package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



public class Analyse extends AppCompatActivity
{
    DatabaseReference myRef;
    int numdays, pos, neg;
    static ArrayList<DataSet> dataSets;
    String key;

    Button back;
    Button next;

    Button button;
    ListView listView;

    static ArrayList<String> allEmos;
    ArrayList<DataEntry> allEntries;
    DataAdapter dataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse);

        Bundle extras = getIntent().getExtras();
        key = extras.getString("key");

        button = (Button) findViewById(R.id.button4);
        listView = (ListView) findViewById(R.id.data_listView);



        allEmos = new ArrayList<>();
        allEntries = new ArrayList<>();
        dataAdapter = new DataAdapter(this, allEntries);
        listView.setAdapter(dataAdapter);

        dataSets = new ArrayList<>();
        initButtons();
        initDataSets();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                TextView textView2 = (TextView) findViewById(R.id.textView2);
                textView2.setVisibility(View.VISIBLE);
                textView2.setText("Insgesamt hast du "+dataSets.size()+" Einträge an "+numdays+" Tagen gemacht");

                TextView textView35 = (TextView) findViewById(R.id.textView35);
                textView35.setVisibility(View.VISIBLE);
                textView35.setText("Davon waren "+pos+" eher positiv ("+(int)(100*pos/dataSets.size())+" %)");

                TextView textView36 = (TextView) findViewById(R.id.textView36);
                textView36.setVisibility(View.VISIBLE);
                textView36.setText("und "+neg+" eher negativ ("+(int)(100*neg/dataSets.size())+" %)");

                ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
                progressBar2.setVisibility(View.VISIBLE);

                progressBar2.setMax(dataSets.size());
                progressBar2.setProgress(pos);

                ProgressBar progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
                progressBar3.setVisibility(View.VISIBLE);
                progressBar3.setMax(dataSets.size());
                progressBar3.setProgress(neg);

                listView.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);

                TextView t = (TextView) findViewById(R.id.analyse_emotionen_aufgezeichnet) ;
                t.setVisibility(View.VISIBLE);
                button.setVisibility(View.INVISIBLE);


                calculate();
                dataAdapter.notifyDataSetChanged();
                setListViewHeightBasedOnChildren(listView);


            }
        });}

        private void initButtons()
        {

            back = (Button) findViewById(R.id.analyse_back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

            next = (Button) findViewById(R.id.analyse_next);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Analyse.this, Analyse2.class);
                    startActivity(i);
                }
            });
        }


    private void initDataSets()
    {
        numdays=0;
        pos=0;
        neg=0;
        myRef = MainActivity.getReference();
        myRef.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                for (DataSnapshot allDates : dataSnapshot.child(key).getChildren())
                {
                    numdays++;
                    for (DataSnapshot allTimes : allDates.getChildren())
                    {

                        DataSet dataSet = allTimes.getValue(DataSet.class);
                        dataSets.add(dataSet);



                        String emo = allTimes.child("Emotion").getValue().toString();

                        if (!allEmos.contains(emo))
                        {
                            allEmos.add(emo);

                        }



                        if (allTimes.child("PosNeg").getValue().equals("positiv"))
                        {
                            pos++;
                        }

                        if (allTimes.child("PosNeg").getValue().equals("negativ"))
                        {
                            neg++;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Toast toast = Toast.makeText(Analyse.this, databaseError.getCode(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }


    private void calculate()
    {
        for (String s : allEmos)
        {
            int count = 0;

            for (DataSet ds : dataSets)
            {
                if (ds.Emotion.equals(s))
                {
                    count++;
                }
            }

            if (count>0)
            {
                DataEntry de = new DataEntry(s, count);
                allEntries.add(de);
            }
        }

        for (DataEntry de2 : allEntries)
        {
            de2.value = Math.round(100*(de2.value/dataSets.size()));
        }


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
