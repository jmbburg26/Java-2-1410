package com.bbgatestudios.week3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import listdata.Contact;

/**
 * Created by John on 9/18/2014.
 */
public class FormActivity extends Activity{
    Button   sButton;
    EditText fName;
    EditText lName;
    EditText eMail;

   @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.form_add);

       getActionBar().setDisplayHomeAsUpEnabled(true);

       fName   = (EditText)findViewById(R.id.form_add_fname);
       lName   = (EditText)findViewById(R.id.form_add_lnamne);
       eMail  = (EditText)findViewById(R.id.form_add_email);
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.form_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.saveButton:
                Log.v("EditText", fName.getText().toString());
                Log.v("EditText", lName.getText().toString());
                Log.v("EditText", eMail.getText().toString());

                Contact contact = new Contact();
                contact.setFirst(fName.getText().toString());
                contact.setLast(lName.getText().toString());
                contact.setEmail(eMail.getText().toString());

                addToList(contact);
                break;
            case R.id.cancelButton:
                    Intent cancelIntent = new Intent (this, MainActivity.class);
                startActivity(cancelIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addToList(Contact contact){
        Intent intent = new Intent();
        intent.putExtra("firstName", contact.getFirst());
        intent.putExtra("lastName", contact.getLast());
        intent.putExtra("email", contact.getEmail());

        setResult(RESULT_OK, intent);
        finish();
    }

    public void selfDestruct(View view) {
        //Cancel the form and return to main view
    }
}
