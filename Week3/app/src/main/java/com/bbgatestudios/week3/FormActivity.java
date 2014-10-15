package com.bbgatestudios.week3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

       sButton = (Button)findViewById(R.id.button_save_data);
       fName   = (EditText)findViewById(R.id.form_add_fname);
       lName   = (EditText)findViewById(R.id.form_add_lnamne);
       eMail  = (EditText)findViewById(R.id.form_add_email);

       sButton.setOnClickListener(
               new View.OnClickListener()
               {
                   public void onClick(View view)
                   {
                       Log.v("EditText", fName.getText().toString());
                       Log.v("EditText", lName.getText().toString());
                       Log.v("EditText", eMail.getText().toString());
                   }
               });
   }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
