package com.bbgatestudios.apitest.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 10/7/2014.
 */
public class HeadlineData {

    private List<Headline> headline = new ArrayList<Headline>();

    public List<Headline> getFormData() { return headline; }


    public HeadlineData(){
        headline.add(new Headline("John", "Brandenburg", "jmbburg26@gmail.com"));
        headline.add(new Headline("Amanda", "Brandenburg", "mrsjmbburg@gmail.com"));
        headline.add(new Headline("Douglas", "Brandenburg","papabnsd@gmail.com"));
    }
}
