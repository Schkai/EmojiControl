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

public class Bearbeiten2 extends AppCompatActivity
{
    ArrayList<String> entries;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bearbeiten2);

        Bundle extras = getIntent().getExtras();
        final String key = extras.getString("key");
        final String date = extras.getString("date");

        DatabaseReference myRef = MainActivity.getReference();

        ListView listView = (ListView) findViewById(R.id.listView2) ;

        entries = new ArrayList<>();
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, entries);
        listView.setAdapter(aa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String time = entries.get(position);

                Intent i = new Intent(Bearbeiten2.this, MainActivity.class);

                i.putExtra("date",date);
                i.putExtra("time",time);
                startActivity(i);

            }
        });


        myRef.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                for (DataSnapshot child : dataSnapshot.child(key).child(date).getChildren())
                {
                    String s = child.getKey().toString();
                    entries.add(s);
                }
                aa.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });


    }

    private String getFormattedTime(String time)
    {
        return time.substring(0,2)+":"+time.substring(2,4);
    }
}


