package com.bbgatestudios.apitest;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by John on 10/4/2014.
 */
public class HeadlinesManager extends AsyncTask<String, Void, String> {
    public static HeadlinesManager m_instance;

    //File manager constructor
    private HeadlinesManager() {

    }

    public static HeadlinesManager getInstance(){
        if (m_instance == null) {
            m_instance = new HeadlinesManager();
        }
        return m_instance;
    }

    public Boolean writeHeadlinesToFile(Context context, String filename, String content ){
        Boolean result =  null;
        FileOutputStream fos = null;

        try {
            fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(content.getBytes());
            Log.i("WRITE_FILE_TO_STORAGE", "SUCCESS");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            Log.i("WRITE_FILE_TO_STORAGE", "FAILED");
        }

        return result;
    }

    public String readHeadlinesFromFile(Context context, String filename){
        String content = "";

        FileInputStream fis = null;

        try {
            fis = context.openFileInput(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] contentBytes = new byte[1024];
            int bytesRead = 0;
            StringBuffer contentBuffer = new StringBuffer();

            while ((bytesRead = bis.read(contentBytes)) != -1) {
                content = new String(contentBytes, 0, bytesRead);
                contentBuffer.append(content);
            }
            content = contentBuffer.toString();
        } catch (Exception e) {

        }finally{
            try {
                fis.close();
            } catch (IOException e) {
                Log.i("CLOSE_FILE_ERROR", e.toString());
                e.printStackTrace();
            }
        }

        return content;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... params) {


        return null;
    }

    @Override
    protected void onPostExecute(String result) {

    }
}
