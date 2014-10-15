package com.bbgatestudios.week3;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import fragment.MainFragment;
import listdata.Contact;


public class MainActivity extends Activity implements MainFragment.ContactListener {

    private final String TAG = "MAINACTIVITY";

    public static final int DELETEREQUEST = 1;
    public static final String DELETECONTACTEXTRA = "com.bbgatestudios.week3.Delete";

    private ArrayList<Contact> mContactDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new Fragment())
                    .commit();
        }

        mContactDataList = new ArrayList<Contact>();
        mContactDataList.add(new Contact("John", "Brandenburg", "jmbburg26@gmail.com", "619-750-2219"));
        mContactDataList.add(new Contact("Amanda", "Brandenburg", "mrsjmbburg@gmail.com", "619-2458-9854"));
        mContactDataList.add(new Contact("Douglas", "Brandenburg", "papabnsd@gmail.com", "586-350-6021"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == Activity.RESULT_OK && requestCode == DELETEREQUEST){
            mContactDataList.remove(data.getIntExtra(DELETECONTACTEXTRA, 0));
            MainFragment mf = (MainFragment) getFragmentManager().findFragmentById(R.id.container);
            mf.updateListData();
        }
    }

    @Override
    public void viewContact(int position){
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra(DetailActivity.CONTACTEXTRA, mContactDataList.get(position));
        startActivity(detailIntent);
    }

    @Override
    public void deleteContact(int position){
        Intent deleteIntent = new Intent(this, DetailActivity.class);
        deleteIntent.putExtra(DetailActivity.CONTACTEXTRA, mContactDataList.get(position));
        deleteIntent.putExtra(DetailActivity.DELETEEXTRA, position);
        startActivityForResult(deleteIntent, DELETEREQUEST);
    }

    @Override
    public ArrayList<Contact>getContacts(){
        return mContactDataList;
    }
}
