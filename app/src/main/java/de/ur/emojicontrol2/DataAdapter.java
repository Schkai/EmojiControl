package de.ur.emojicontrol2;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aend on 22.05.2017.
 */

public class DataAdapter extends ArrayAdapter <DataEntry>
{
    private ArrayList<DataEntry>allEntries;
    private Context context;
    private int custom;

    public DataAdapter(Context context, ArrayList<DataEntry> allEntries)
    {
        super(context, R.layout.data, allEntries);
        this.context=context;
        this.allEntries=allEntries;
        this.custom=R.layout.data;
    }

    @Override
    public int getCount()
    {
        return allEntries.size();
    }

    @Override
    public DataEntry getItem(int position)
    {
        return allEntries.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View dataEntryItem;

        if (convertView==null)
        {
            LayoutInflater loi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            dataEntryItem = loi.inflate(custom, null);
        }

        else
        {
            dataEntryItem=convertView;
        }


        TextView editText = (TextView) dataEntryItem.findViewById(R.id.data_tv);
        ProgressBar progressBar = (ProgressBar) dataEntryItem.findViewById(R.id.data_pb) ;

        double val = allEntries.get(position).value;

        editText.setText(allEntries.get(position).entry+": "+Math.round(val)+" %");
        progressBar.setProgress((int)val);

        return dataEntryItem;
    }


}


