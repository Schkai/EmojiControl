package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class Ausloeser extends AppCompatActivity
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
        setContentView(R.layout.activity_ausloeser);

        Bundle extras = getIntent().getExtras();

        final String emotion = extras.getString("Emotion");
        //final int imageRes = extras.getInt("image");
        final String key = extras.getString("key");
        final String month = extras.getString("month");
        final String day = extras.getString("day");
        final String hour = extras.getString("hour");
        final String minute = extras.getString("minute");
        final String year = extras.getString("year");
        final String posNeg = extras.getString("posNeg");

        TextView tv = (TextView) findViewById(R.id.question3);
        tv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Ausloeser.this, Glossar.class);
                startActivity(i);
            }
        });

        TextView tv1 = (TextView) findViewById(R.id.textView10);
        tv1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Ausloeser.this, Glossar.class);
                startActivity(i);
            }
        });

        TextView tv3 = (TextView) findViewById(R.id.textView13);
        tv3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Ausloeser.this, Glossar.class);
                startActivity(i);
            }
        });


        entry = (TextView) findViewById(R.id.date3);
        entry.setText("Eintrag vom "+day+"."+month+"."+year+" "+hour+":"+minute+" Uhr");



        inputHeadline = (TextView) findViewById(R.id.headline3);
        inputHeadline.setText(emotion);

        save = (Button) findViewById(R.id.back3);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                finish();
            }
        });

        home = (Button) findViewById(R.id.home3);
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                Intent i = new Intent(Ausloeser.this, MainActivity.class);
                startActivity(i);
            }
        });

        next = (Button) findViewById(R.id.next3);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                if (posNeg.equals("positiv"));
                {
                    Intent i = new Intent(Ausloeser.this, UmgangPos.class);
                    i.putExtra("Emotion", emotion);
                    //i.putExtra("image", imageRes);
                    i.putExtra("key", key);
                    i.putExtra("month",month);
                    i.putExtra("day",day);
                    i.putExtra("hour",hour);
                    i.putExtra("minute",minute);
                    i.putExtra("year",year);

                    startActivity(i);
                }

                if (posNeg.equals("negativ"))
                {
                    Intent i = new Intent(Ausloeser.this, UmgangNeg.class);
                    i.putExtra("Emotion", emotion);
                    //i.putExtra("image", imageRes);
                    i.putExtra("key", key);
                    i.putExtra("month", month);
                    i.putExtra("day", day);
                    i.putExtra("hour", hour);
                    i.putExtra("minute", minute);
                    i.putExtra("year", year);

                    startActivity(i);
                }
            }
        });
    }

    private void saveData(String key, String year, String month, String day, String hour, String minute)
    {
        DatabaseReference myRef = MainActivity.getReference();

        float value;
        boolean b;

        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton2);
        b = rb1.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Auslöser_jetzt").setValue(b);

        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton);
        b = rb2.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Auslöser_Vergangenheit").setValue(b);

        RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
        b = rb3.isChecked();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Auslöser_Zukunft").setValue(b);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar4);
        value = ratingBar.getRating();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Auslöser_Selbst_Andere").setValue(value);

        RatingBar ratingBar1 = (RatingBar) findViewById(R.id.ratingBar5);
        value = ratingBar1.getRating();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Auslöser_Kontrollierbarkeit").setValue(value);


        Toast toast = Toast.makeText(Ausloeser.this, "Eintrag gespeichert", Toast.LENGTH_SHORT);
        toast.show();

    }
}
