package com.bbgatestudios.apitest.data;

import com.bbgatestudios.apitest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 9/17/2014.
 */
public class HeadlineData {
    private List<Headline> headline = new ArrayList<Headline>();

    public List<Headline> getFormData() { return headline; }


    public HeadlineData(){
        headline.add(new Headline("John", R.drawable.wilson_football, "Brandenburg",
                "jmbburg26@gmail.com"));
        headline.add(new Headline("Amanda", R.drawable.spalding_basketball, "Brandenburg",
                "mrsjmbburg@gmail.com"));
        headline.add(new Headline("Douglas", R.drawable.rawlings_baseball, "Brandenburg",
                "papabnsd@gmail.com"));
    }
}
