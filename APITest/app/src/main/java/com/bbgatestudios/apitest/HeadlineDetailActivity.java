package com.bbgatestudios.apitest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by John on 9/13/2014.
 */
public class HeadlineDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headline_detail);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
//          Create the fragment, set its args, add it to the detail container
            HeadlineDetailFragment fragment = new HeadlineDetailFragment();

            Bundle b = getIntent().getBundleExtra(MainActivity.HEADLINE_BUNDLE);
            fragment.setArguments(b);

            getFragmentManager().beginTransaction()
                    .add(R.id.detailContainer, fragment)
                    .commit();
        }

    }

    //  Returns to the list activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }

    public void implicitSendEmail(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Put your email text here.");
        intent.setType("text/plain");
        startActivity(intent);
    }
}
