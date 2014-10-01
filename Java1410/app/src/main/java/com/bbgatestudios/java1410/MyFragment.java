package com.bbgatestudios.java1410;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by John on 9/28/2014.
 */
public class MyFragment extends Fragment {
    public MyFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.my_fragment, container, false);
        return rootView;
    }
}
