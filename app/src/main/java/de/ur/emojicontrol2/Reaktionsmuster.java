package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Reaktionsmuster extends AppCompatActivity
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
        setContentView(R.layout.activity_reaktionsmuster);

        Bundle extras = getIntent().getExtras();

        final String emotion = extras.getString("Emotion");
        final int imageRes = extras.getInt("image");

        inputHeadline = (TextView) findViewById(R.id.inputHeadline);
        inputHeadline.setText(emotion);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(imageRes));
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast toast = Toast.makeText(Reaktionsmuster.this, "Eintrag gespeichert", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });

        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Reaktionsmuster.this, MainActivity.class);
                startActivity(i);
            }
        });

        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Reaktionsmuster.this, Reaktionsmuster.class);
                i.putExtra("Emotion", emotion);
                i.putExtra("image", imageRes);

                startActivity(i);
            }
        });
    }
}
