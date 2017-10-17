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

public class Gefuehl extends AppCompatActivity
{
    //ImageView imageView;
    TextView entry;
    TextView inputHeadline;
    Button save;
    Button home;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gefuehl);

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

        TextView tv1 = (TextView) findViewById(R.id.question2);
        tv1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Gefuehl.this, Glossar.class);
                startActivity(i);
            }
        });


        entry = (TextView) findViewById(R.id.date2);
        entry.setText("Eintrag vom "+day+"."+month+"."+year+" "+hour+":"+minute+" Uhr");


        inputHeadline = (TextView) findViewById(R.id.headline2);
        inputHeadline.setText(emotion);

        //imageView = (ImageView) findViewById(R.id.emoji2);
        //imageView.setImageDrawable(getResources().getDrawable(imageRes));
        save = (Button) findViewById(R.id.back2);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                finish();
            }
        });

        home = (Button) findViewById(R.id.home2);
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                Intent i = new Intent(Gefuehl.this, MainActivity.class);
                startActivity(i);
            }
        });

        next = (Button) findViewById(R.id.next2);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData(key, year, month, day, hour, minute);
                Intent i = new Intent(Gefuehl.this, Ausloeser.class);
                i.putExtra("Emotion", emotion);
                // i.putExtra("image", imageRes);
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

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar20);
        value = ratingBar.getRating();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Mimik_Gestik").setValue(value*2);

        RatingBar ratingBar1 = (RatingBar) findViewById(R.id.ratingBar21);
        value = ratingBar1.getRating();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Verbale_Äußerung").setValue(value*2);

        RatingBar ratingBar2 = (RatingBar) findViewById(R.id.ratingBar22);
        value = ratingBar2.getRating();
        myRef.child(key).child(year+month+day).child(hour+minute).child("Verhaltensimpuls_nachgebend").setValue(value*2);

        Toast toast = Toast.makeText(Gefuehl.this, "Eintrag gespeichert", Toast.LENGTH_SHORT);
        toast.show();

    }

}
