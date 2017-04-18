package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class InputIntensity extends AppCompatActivity
{

    TextView entry;
    //ImageView imageView;
    TextView inputHeadline;
    Button save;
    Button home;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intensity);

        Bundle extras = getIntent().getExtras();

        final String emotion = extras.getString("Emotion");
        //final int imageRes = extras.getInt("image");
        final String emo = extras.getString("emo");
        final String key = extras.getString("key");
        final String posNeg = extras.getString("posNeg");

        final String month = extras.getString("month");
        final String day = extras.getString("day");
        final String hour = extras.getString("hour");
        final String minute = extras.getString("minute");
        final String year = extras.getString("year");


        entry = (TextView) findViewById(R.id.date0);
        entry.setText("Eintrag vom "+day+"."+month+"."+year+" "+hour+":"+minute+" Uhr");


        inputHeadline = (TextView) findViewById(R.id.headline0);
        inputHeadline.setText(emotion);

        //imageView = (ImageView) findViewById(R.id.emoji0);
        //imageView.setImageDrawable(getResources().getDrawable(imageRes));

        save = (Button) findViewById(R.id.save0);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute, emo, posNeg);
                Intent i = new Intent(InputIntensity.this, MainActivity.class);
                startActivity(i);
            }
        });

        home = (Button) findViewById(R.id.home0);
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute, emo, posNeg);
                Intent i = new Intent(InputIntensity.this, MainActivity.class);
                startActivity(i);
            }
        });

        next = (Button) findViewById(R.id.next0);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                saveData(key, year, month, day, hour, minute, emo, posNeg);
                Intent i = new Intent(InputIntensity.this, Reaktionsmuster.class);
                i.putExtra("Emotion", emotion);

                i.putExtra("key",key);
                i.putExtra("month",month);
                i.putExtra("day",day);
                i.putExtra("hour",hour);
                i.putExtra("minute",minute);
                i.putExtra("year",year);
                i.putExtra("posNeg", posNeg);

                startActivity(i);
            }
        });

    }

    private void saveData(String key, String year, String month, String day, String hour, String minute, String emo, String posNeg)
    {
        DatabaseReference myRef = MainActivity.getReference();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Emotion").setValue(emo);
        myRef.child(key).child(year+month+day).child(hour+minute).child("PosNeg").setValue(posNeg);


        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar0);
        float intensity = ratingBar.getRating();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Intensity").setValue(intensity);

        Toast toast = Toast.makeText(InputIntensity.this, "Eintrag gespeichert", Toast.LENGTH_SHORT);
        toast.show();

    }


}
