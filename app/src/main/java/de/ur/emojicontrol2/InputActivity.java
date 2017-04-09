package de.ur.emojicontrol2;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity
{

    ImageView imageView;
    TextView inputHeadline;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Bundle extras = getIntent().getExtras();
        String emotion = extras.getString("Emotion");
        int imageRes = extras.getInt("image");
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
                Toast toast = Toast.makeText(InputActivity.this, "Eintrag gespeichert", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });

    }
}
