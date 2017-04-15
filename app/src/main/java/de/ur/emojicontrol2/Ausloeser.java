package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Ausloeser extends AppCompatActivity
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
        setContentView(R.layout.activity_ausloeser);

        Bundle extras = getIntent().getExtras();

        final String emotion = extras.getString("Emotion");
        final int imageRes = extras.getInt("image");

        inputHeadline = (TextView) findViewById(R.id.headline3);
        inputHeadline.setText(emotion);

        imageView = (ImageView) findViewById(R.id.emoji3);
        imageView.setImageDrawable(getResources().getDrawable(imageRes));
        save = (Button) findViewById(R.id.back3);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast toast = Toast.makeText(Ausloeser.this, "Eintrag gespeichert", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });

        home = (Button) findViewById(R.id.home3);
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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
                Intent i = new Intent(Ausloeser.this, Umgang.class);
                i.putExtra("Emotion", emotion);
                i.putExtra("image", imageRes);

                startActivity(i);
            }
        });
    }
}
