package com.bbgatestudios.apitest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bbgatestudios.apitest.data.Headline;

import java.util.List;

/**
 * Created by John on 9/9/2014.
 */
public class HeadlineArrayAdapter extends ArrayAdapter {
    private Context context;
    private List<Headline> objects;

    public HeadlineArrayAdapter(Context context, int resource, List<Headline> objects){
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Headline headline = objects.get(position);

        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.headline_listitem, null);
        TextView tv1 = (TextView) view.findViewById(R.id.headline);
        tv1.setText(headline.getStoryTitle());

        TextView tv2 = (TextView) view.findViewById(R.id.description);

        tv2.setText(headline.getStoryTitle());

        return view;
    }
}
