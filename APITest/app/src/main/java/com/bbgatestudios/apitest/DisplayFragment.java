package com.bbgatestudios.apitest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by John on 9/5/2014.
 */
public class DisplayFragment extends Fragment {

    public static final String TAG = "DisplayFragment.TAG";
    //Factory method
    //Don't overload
    public static DisplayFragment newInstance(){
        DisplayFragment frag = new DisplayFragment();
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container, Bundle _savedInstanceState){
        //Create and return view for this fragment
        View view = _inflater.inflate(R.layout.fragment_main, _container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle _savedInstanceState){
        super.onActivityCreated(_savedInstanceState);

        TextView fragTV = (TextView)getView().findViewById(R.id.name_display);
        fragTV.setText("Hello from my fragment!");
    }
}
