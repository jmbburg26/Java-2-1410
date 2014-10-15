package com.bbgatestudios.week3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import fragment.DetailFragment;
import listdata.Contact;

/**
 * Created by John on 10/15/2014.
 */
public class DetailActivity extends Activity implements DetailFragment.DetailListener {

    private final String TAG = "DETAILACTIVITY";

    private Contact mContact;
    private int mDelete;

    public static final String CONTACTEXTRA = "com.bbgatestudios.week3.Contact";
    public static final String DELETEEXTRA = "com.bbgatestudios.week3.Delete";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null){
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new DetailFragment())
                    .commit();
        }

        Intent detailIntent = getIntent();
        if (detailIntent != null){
            mContact = (Contact) detailIntent.getSerializableExtra(CONTACTEXTRA);
            mDelete = detailIntent.getIntExtra(DELETEEXTRA, 0);
        }
    }

    @Override
    public Contact getContact(){
        return mContact;
    }

    @Override
    public int getDelete(){
        return mDelete;
    }

    @Override
    public void deleteContact(){
        Intent returnIntent = new Intent();
        returnIntent.putExtra(MainActivity.DELETECONTACTEXTRA, mDelete);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
