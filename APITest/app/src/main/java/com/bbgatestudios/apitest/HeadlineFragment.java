package com.bbgatestudios.apitest;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbgatestudios.apitest.data.Headline;
import com.bbgatestudios.apitest.data.HeadlineData;

import java.util.List;

/**
 * Created by John on 9/10/2014.
 */
public class HeadlineFragment extends ListFragment {
    List<Headline> headlines = new HeadlineData().getFormData();

    public HeadlineFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        HeadlineArrayAdapter adapter = new HeadlineArrayAdapter(getActivity(), R.layout.headline_listitem, headlines);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.my_fragment, container, false);
        return rootView;
    }
}