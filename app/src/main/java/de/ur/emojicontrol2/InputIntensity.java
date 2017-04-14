package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InputIntensity extends AppCompatActivity
{

    ImageView imageView;
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
        final int imageRes = extras.getInt("image");

        inputHeadline = (TextView) findViewById(R.id.headline0);
        inputHeadline.setText(emotion);

        imageView = (ImageView) findViewById(R.id.emoji0);
        imageView.setImageDrawable(getResources().getDrawable(imageRes));

        save = (Button) findViewById(R.id.save0);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast toast = Toast.makeText(InputIntensity.this, "Eintrag gespeichert", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });

        home = (Button) findViewById(R.id.home0);
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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
                Intent i = new Intent(InputIntensity.this, Reaktionsmuster.class);
                i.putExtra("Emotion", emotion);
                i.putExtra("image", imageRes);

                startActivity(i);
            }
        });


    }
}
