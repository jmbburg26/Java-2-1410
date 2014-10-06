package com.bbgatestudios.apitest;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bbgatestudios.apitest.data.Headline;
import com.bbgatestudios.apitest.data.HeadlineData;

import java.util.List;

/**
 * Created by John on 9/10/2014.
 */
public class HeadlineListFragment extends ListFragment {
    List<Headline> headlines = new HeadlineData().getFormData();

    private Callbacks activity;
    public HeadlineListFragment(){
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
        View rootView = inflater.inflate(R.layout.headline_list_fragment, container, false);
        return rootView;
    }

    public interface Callbacks {
        public void onItemSelected(Headline headline);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Headline headline = headlines.get(position);
        activity.onItemSelected(headline);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.activity = (Callbacks) activity;
    }
}