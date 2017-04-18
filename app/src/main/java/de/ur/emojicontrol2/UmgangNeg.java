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

        boolean b;

        RadioButton rb5 = (RadioButton) findViewById(R.id.radioButton7);
        b = rb5.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Situation_verlassen").setValue(b);

        RadioButton rb6 = (RadioButton) findViewById(R.id.radioButton8);
        b = rb6.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Situation_verändern").setValue(b);

        RadioButton rb7 = (RadioButton) findViewById(R.id.radioButton9);
        b = rb7.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Situation_umdeuten").setValue(b);

        RadioButton rb8 = (RadioButton) findViewById(R.id.radioButton10);
        b = rb8.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Versucht_abzulenken").setValue(b);

        RadioButton rb9 = (RadioButton) findViewById(R.id.radioButton11);
        b = rb9.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Substanz_konsumiert").setValue(b);

        RadioButton rb10 = (RadioButton) findViewById(R.id.radioButton12);
        b = rb10.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Lange_nachgegrübelt").setValue(b);

        RadioButton rb11 = (RadioButton) findViewById(R.id.radioButton13);
        b = rb11.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Resigniert_abgewartet").setValue(b);

        Toast toast = Toast.makeText(UmgangNeg.this, "Eintrag gespeichert", Toast.LENGTH_SHORT);
        toast.show();

    }
}
