package de.ur.emojicontrol2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.firebase.database.DatabaseReference;

public class Umgang extends AppCompatActivity
{
    ImageView imageView;
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
        final int imageRes = extras.getInt("image");
        final String key = extras.getString("key");
        final String month = extras.getString("month");
        final String day = extras.getString("day");
        final String hour = extras.getString("hour");
        final String minute = extras.getString("minute");
        final String year = extras.getString("year");


        entry = (TextView) findViewById(R.id.textView7);
        entry.setText("Eintrag vom "+day+"."+month+"."+year+" "+hour+":"+minute+" Uhr");


        inputHeadline = (TextView) findViewById(R.id.headline4);
        inputHeadline.setText(emotion);

        imageView = (ImageView) findViewById(R.id.emoji4);
        imageView.setImageDrawable(getResources().getDrawable(imageRes));

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
                Intent i = new Intent(Umgang.this, MainActivity.class);
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
                Intent i = new Intent(Umgang.this, MainActivity.class);

                startActivity(i);
            }
        });
    }

    private void saveData(String key, String year, String month, String day, String hour, String minute)
    {
        DatabaseReference myRef = MainActivity.getReference();

        boolean b;

        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton4);
        b = rb1.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Gefühl_genossen").setValue(b);


        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton5);
        b = rb2.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Ereignisse_vorgestellt").setValue(b);


        RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton6);
        b = rb3.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Gefühl_nicht_fortbestehen").setValue(b);

        RadioButton rb4 = (RadioButton) findViewById(R.id.radioButton14);
        b = rb4.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Situation_verbessern").setValue(b);

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

        Toast toast = Toast.makeText(Umgang.this, "Eintrag gespeichert", Toast.LENGTH_SHORT);
        toast.show();

    }
}
