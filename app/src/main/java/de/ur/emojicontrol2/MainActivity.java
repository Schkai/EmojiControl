package de.ur.emojicontrol2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static android.R.attr.key;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setupEmojiButtons();

        Button edit = (Button) findViewById(R.id.bearbeiten);
        edit.setText(getKey());
        edit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, Bearbeiten.class);
                startActivity(i);

            }
        });

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        String date = ""+month+day;
        String time = ""+hour+minute;

        myRef.child(getKey()).child(date).child(time).setValue("test");
    }

    private String getKey()
    {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String result = sharedPref.getString("ID","NoEntry");
        if (result=="NoEntry")
        {

            result=getRandomString();
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("ID",result);
            editor.commit();

        }
        return result;



    }

    private String getRandomString()
    {
        Random random = new Random();
        String result ="";
        String allowedCharacters = "0123456789qwertzuiopasdfghjklyxcvbnmQWERTZUIOPASDFGHJKLYXCVBNM";
        for (int i = 0; i<8; i++)
        {
            result+=allowedCharacters.charAt(random.nextInt(allowedCharacters.length()));
        }
        return result;

    }

    private void setupEmojiButtons()
    {
        ImageView i1 = (ImageView) findViewById(R.id.ängstlich);
        i1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, InputIntensity.class);
                i.putExtra("Emotion", "Du hast Angst");
                i.putExtra("image",R.drawable.angst);
                startActivity(i);
            }
        });

        ImageView i2 = (ImageView) findViewById(R.id.begeistert);
        i2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, InputIntensity.class);
                i.putExtra("Emotion", "Du bist begeistert");
                i.putExtra("image",R.drawable.begeistert);
                startActivity(i);
            }
        });

        ImageView i3 = (ImageView) findViewById(R.id.dankbar);
        i3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, InputIntensity.class);
                i.putExtra("Emotion", "Du bist dankbar");
                i.putExtra("image",R.drawable.dankbar);
                startActivity(i);
            }
        });


        ImageView i5 = (ImageView) findViewById(R.id.freudig);
        i5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, InputIntensity.class);
                i.putExtra("Emotion", "Du freust Dich");
                i.putExtra("image",R.drawable.freude);
                startActivity(i);
            }
        });

        ImageView i6 = (ImageView) findViewById(R.id.hoffnungsvoll);
        i6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, InputIntensity.class);
                i.putExtra("Emotion", "Du bist voller Hoffnung");
                i.putExtra("image",R.drawable.hoffnungsvoll);
                startActivity(i);
            }
        });

        ImageView i7 = (ImageView) findViewById(R.id.gelangweilt);
        i7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, InputIntensity.class);
                i.putExtra("Emotion", "Du langweilst Dich");
                i.putExtra("image",R.drawable.langeweile);
                startActivity(i);
            }
        });

        ImageView i8 = (ImageView) findViewById(R.id.beschämt);
        i8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, InputIntensity.class);
                i.putExtra("Emotion", "Du schämst Dich");
                i.putExtra("image",R.drawable.scham);
                startActivity(i);
            }
        });

        ImageView i9 = (ImageView) findViewById(R.id.schuldig);
        i9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, InputIntensity.class);
                i.putExtra("Emotion", "Du fühlst Dich schuldig");
                i.putExtra("image",R.drawable.schuld);
                startActivity(i);
            }
        });

        ImageView i10 = (ImageView) findViewById(R.id.stolz);
        i10.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, InputIntensity.class);
                i.putExtra("Emotion", "Du bist stolz");
                i.putExtra("image",R.drawable.stolz);
                startActivity(i);
            }
        });

        ImageView i11 = (ImageView) findViewById(R.id.traurig);
        i11.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, InputIntensity.class);
                i.putExtra("Emotion", "Du bist traurig");
                i.putExtra("image",R.drawable.trauer);
                startActivity(i);
            }
        });



        ImageView i13 = (ImageView) findViewById(R.id.wütend);
        i13.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, InputIntensity.class);
                i.putExtra("Emotion", "Du bist wütend");
                i.putExtra("image",R.drawable.wut);
                startActivity(i);
            }
        });

        ImageView i14 = (ImageView) findViewById(R.id.zufrieden);
        i14.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, InputIntensity.class);
                i.putExtra("Emotion", "Du bist zufrieden");
                i.putExtra("image",R.drawable.zufrieden);
                startActivity(i);
            }
        });
    }


}