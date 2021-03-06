package de.ur.emojicontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Bearbeiten extends AppCompatActivity
{

    ArrayList<String> days;
    ArrayAdapter aa;
    TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bearbeiten);

        Bundle extras = getIntent().getExtras();
        final String key = extras.getString("key");

        DatabaseReference myRef = MainActivity.getReference();
        number = (TextView) findViewById(R.id.textView9);
        ListView listView = (ListView) findViewById(R.id.listView) ;

        days = new ArrayList<>();
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, days);
        listView.setAdapter(aa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String date = days.get(position);

                Intent i = new Intent(Bearbeiten.this, Bearbeiten2.class);
                i.putExtra("key",key);
                i.putExtra("date",date);
                startActivity(i);
            }
        });


        myRef.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                for (DataSnapshot child : dataSnapshot.child(key).getChildren())
                {
                    String s = child.getKey().toString();
                    days.add(s);
                }
                aa.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });


    }

    private String getFormattedDate(String date)
    {
        return date.substring(6,8)+"."+date.substring(4,6)+"."+date.substring(0,4);
    }
}
