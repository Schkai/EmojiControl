package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class UmgangNeg extends AppCompatActivity
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
        setContentView(R.layout.activity_umgang_neg);

        Bundle extras = getIntent().getExtras();

        final String emotion = extras.getString("Emotion");
        final String key = extras.getString("key");
        final String month = extras.getString("month");
        final String day = extras.getString("day");
        final String hour = extras.getString("hour");
        final String minute = extras.getString("minute");
        final String year = extras.getString("year");

        TextView tv1 = (TextView) findViewById(R.id.textView17n);
        tv1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(UmgangNeg.this, Glossar.class);
                startActivity(i);
            }
        });


        entry = (TextView) findViewById(R.id.textView7n);
        entry.setText("Eintrag vom "+day+"."+month+"."+year+" "+hour+":"+minute+" Uhr");


        inputHeadline = (TextView) findViewById(R.id.headline4n);
        inputHeadline.setText(emotion);


        save = (Button) findViewById(R.id.back4n);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                finish();
            }
        });

        home = (Button) findViewById(R.id.start4n);
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                Intent i = new Intent(UmgangNeg.this, MainActivity.class);
                startActivity(i);
            }
        });

        next = (Button) findViewById(R.id.button5n);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                Intent i = new Intent(UmgangNeg.this, MainActivity.class);

                startActivity(i);
            }
        });
    }

    private void saveData(String key, String year, String month, String day, String hour, String minute)
    {
        DatabaseReference myRef = MainActivity.getReference();

        float f = -5;

        RadioButton rb5 = (RadioButton) findViewById(R.id.radioButton7);
        if (rb5.isChecked())
        {
            f=5;
        }
        myRef.child(key).child(year+month+day).child(hour+minute).child("Situation_verlassen").setValue(f);

        f=-5;

        RadioButton rb6 = (RadioButton) findViewById(R.id.radioButton8);
        if (rb6.isChecked())
        {
            f=5;
        }
        myRef.child(key).child(year+month+day).child(hour+minute).child("Situation_verändern").setValue(f);

        f=-5;

        RadioButton rb7 = (RadioButton) findViewById(R.id.radioButton9);
        if (rb7.isChecked())
        {
            f=5;
        }
        myRef.child(key).child(year+month+day).child(hour+minute).child("Situation_umdeuten").setValue(f);

        f=-5;

        RadioButton rb8 = (RadioButton) findViewById(R.id.radioButton10);
        if (rb8.isChecked())
        {
            f=5;
        }
        myRef.child(key).child(year+month+day).child(hour+minute).child("Versucht_abzulenken").setValue(f);

        f=-5;

        RadioButton rb9 = (RadioButton) findViewById(R.id.radioButton11);
        if (rb9.isChecked())
        {
            f=5;
        }
        myRef.child(key).child(year+month+day).child(hour+minute).child("Substanz_konsumiert").setValue(f);

        f=-5;

        RadioButton rb10 = (RadioButton) findViewById(R.id.radioButton12);
        if (rb10.isChecked())
        {
            f=5;
        }
        myRef.child(key).child(year+month+day).child(hour+minute).child("Lange_nachgegrübelt").setValue(f);

        f=-5;

        RadioButton rb11 = (RadioButton) findViewById(R.id.radioButton13);
        if (rb11.isChecked())
        {
            f=5;
        }
        myRef.child(key).child(year+month+day).child(hour+minute).child("Resigniert_abgewartet").setValue(f);

        f=5;

        RadioButton rb12 = (RadioButton) findViewById(R.id.radioButton15);
        if (rb12.isChecked())
        {
            f=-5;
        }
        myRef.child(key).child(year+month+day).child(hour+minute).child("Situation_verbessern").setValue(f);


        Toast toast = Toast.makeText(UmgangNeg.this, "Eintrag gespeichert", Toast.LENGTH_SHORT);
        toast.show();

    }
}
