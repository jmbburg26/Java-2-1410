package com.bbgatestudios.apitest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbgatestudios.apitest.data.Headline;

/**
 * Created by John on 9/13/2014.
 */
public class HeadlineDetailFragment extends Fragment {

    Headline headline;


   public HeadlineDetailFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Bundle b = getArguments();
        if (b != null && b.containsKey(Headline.STORY_TITLE)){
            headline = new Headline(b);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        Load the layout
        View view = inflater.inflate(R.layout.headline_detail_fragment, container, false);

        if (headline != null) {

            //Display values and image
            TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvTitle.setText(headline.getStoryTitle());

            TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);
            tvDescription.setText(headline.getStoryDescription());

            TextView tvPublished = (TextView) view.findViewById(R.id.tvPublished);
            tvPublished.setText(headline.getStoryPublished());

        }

        return view;
    }
}
