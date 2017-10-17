package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Bearbeiten3 extends AppCompatActivity {

    String emo;
    String posNeg;
    String emotion;
    String year;
    String month;
    String day;
    String hour;
    String minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bearbeiten3);

        Bundle extras = getIntent().getExtras();
        final String time = extras.getString("time");
        final String date = extras.getString("date");
        final String key = extras.getString("key");

        DatabaseReference myRef = MainActivity.getReference();

        myRef.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                emo = dataSnapshot.child(key).child(date).child(time).child("Emotion").getValue().toString();
                posNeg = dataSnapshot.child(key).child(date).child(time).child("posNeg").toString();
                emotion = "Du bearbeitest den Eintrag vom "+date+", "+time+" Uhr. Deine Emotion war: "+emo;

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        year= date.substring(0,4);
        month=date.substring(4,6);
        day=date.substring(6,8);
        hour=time.substring(0,2);
        minute=time.substring(2,4);

        Button next = (Button) findViewById(R.id.bearbeiten3_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bearbeiten3.this, InputIntensity.class);
                i.putExtra("Emotion", emotion);

                i.putExtra("emo", emo);
                i.putExtra("key",key);
                i.putExtra("posNeg", "negativ");

                i.putExtra("month",month);
                i.putExtra("day",day);
                i.putExtra("hour",hour);
                i.putExtra("minute",minute);
                i.putExtra("year",year);

                startActivity(i);
            }
        });

        Button home = (Button) findViewById(R.id.bearbeiten3_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bearbeiten3.this, MainActivity.class);
                startActivity(i);
            }
        });

        Button back = (Button) findViewById(R.id.bearbeiten3_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
}}
