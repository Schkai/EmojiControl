package de.ur.emojicontrol2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.firebase.database.DatabaseReference;

public class UmgangPos extends AppCompatActivity
{
    TextView inputHeadline;
    TextView entry;
    Button save;
    Button home;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umgang);

        Bundle extras = getIntent().getExtras();

        final String emotion = extras.getString("Emotion");
        final String key = extras.getString("key");
        final String month = extras.getString("month");
        final String day = extras.getString("day");
        final String hour = extras.getString("hour");
        final String minute = extras.getString("minute");
        final String year = extras.getString("year");

        TextView tv1 = (TextView) findViewById(R.id.question40);
        tv1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(UmgangPos.this, Glossar.class);
                startActivity(i);
            }
        });


        entry = (TextView) findViewById(R.id.date4p);
        entry.setText("Eintrag vom "+day+"."+month+"."+year+" "+hour+":"+minute+" Uhr");


        inputHeadline = (TextView) findViewById(R.id.headline4b);
        inputHeadline.setText(emotion);


        save = (Button) findViewById(R.id.back4);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                finish();
            }
        });

        home = (Button) findViewById(R.id.start4);
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                Intent i = new Intent(UmgangPos.this, MainActivity.class);
                startActivity(i);
            }
        });

        next = (Button) findViewById(R.id.button5);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                Intent i = new Intent(UmgangPos.this, MainActivity.class);

                startActivity(i);
            }
        });
    }

    private void saveData(String key, String year, String month, String day, String hour, String minute)
    {
        DatabaseReference myRef = MainActivity.getReference();

       float f=-5;

        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton4);
        if (rb1.isChecked())
        {
            f=5;
        }
        myRef.child(key).child(year+month+day).child(hour+minute).child("Gefühl_genossen").setValue(f);

        f=-5;

        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton5);
        if (rb2.isChecked())
        {
            f=5;
        }
        myRef.child(key).child(year+month+day).child(hour+minute).child("Ereignisse_vorgestellt").setValue(f);

        f=-5;


        RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton6);
        if (rb3.isChecked())
        {
            f=5;
        }
        myRef.child(key).child(year+month+day).child(hour+minute).child("Gefühl_nicht_fortbestehen").setValue(f);




        Toast toast = Toast.makeText(UmgangPos.this, "Eintrag gespeichert", Toast.LENGTH_SHORT);
        toast.show();

    }
}
