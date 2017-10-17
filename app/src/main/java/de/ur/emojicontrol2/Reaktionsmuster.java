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

public class Reaktionsmuster extends AppCompatActivity
{

    //ImageView imageView;
    TextView inputHeadline;
    TextView entry;
    Button save;
    Button home;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaktionsmuster);

        Bundle extras = getIntent().getExtras();

        final String emotion = extras.getString("Emotion");
        //final int imageRes = extras.getInt("image");
        final String posNeg = extras.getString("posNeg");
        final String key = extras.getString("key");
        final String month = extras.getString("month");
        final String day = extras.getString("day");
        final String hour = extras.getString("hour");
        final String minute = extras.getString("minute");
        final String year = extras.getString("year");


        entry = (TextView) findViewById(R.id.date1);
        entry.setText("Eintrag vom "+day+"."+month+"."+year+" "+hour+":"+minute+" Uhr");


        inputHeadline = (TextView) findViewById(R.id.headline1);
        inputHeadline.setText(emotion);

        TextView tv1 = (TextView) findViewById(R.id.question1);
        tv1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Reaktionsmuster.this, Glossar.class);
                startActivity(i);
            }
        });

        //imageView = (ImageView) findViewById(R.id.emoji1);
        //imageView.setImageDrawable(getResources().getDrawable(imageRes));

        save = (Button) findViewById(R.id.back1);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                finish();
            }
        });

        home = (Button) findViewById(R.id.home1);
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                Intent i = new Intent(Reaktionsmuster.this, MainActivity.class);
                startActivity(i);
            }
        });

        next = (Button) findViewById(R.id.next1);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);

                Intent i = new Intent(Reaktionsmuster.this, Gefuehl.class);
                i.putExtra("Emotion", emotion);
                //i.putExtra("image", imageRes);
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

    private void saveData(String key, String year, String month, String day, String hour, String minute)
    {
        DatabaseReference myRef = MainActivity.getReference();

        float value;

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar10);
        value = ratingBar.getRating();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Anspannung").setValue(value*2);

        RatingBar ratingBar1 = (RatingBar) findViewById(R.id.ratingBar11);
        value = ratingBar1.getRating();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Tendenz").setValue(value*2);

        RatingBar ratingBar2 = (RatingBar) findViewById(R.id.ratingBar12);
        value = ratingBar2.getRating();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Aufmerksamkeit").setValue(value*2);

        Toast toast = Toast.makeText(Reaktionsmuster.this, "Eintrag gespeichert", Toast.LENGTH_SHORT);
        toast.show();

    }
}
