package com.bbgatestudios.apitest;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by John on 10/4/2014.
 */
public class GetHeadlines extends IntentService {

    public static final String MEESSENGER_KEY = "messenger";
    public String headlines;
    public HttpURLConnection con;
    HeadlinesManager m_file;
    String filename = "headlinesFile";


    public GetHeadlines() {
        super("GetHeadlines");
        // TODO Auto-generated constructor stub

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        m_file = HeadlinesManager.getInstance();
        Log.i("HeadlinesHandler", "started");

        Bundle extras = intent.getExtras();
        Messenger messenger = (Messenger)extras.get(MEESSENGER_KEY);
        Message message = Message.obtain();
        message.arg1 = Activity.RESULT_OK;
        message.obj = "Success";


        try {
            URL newUrl = new URL("http://api.espn.com/v1/now?limit=15&apikey=e3qvjg8m43xx4xmcyqperf3a");
            con = (HttpURLConnection) newUrl.openConnection();
            readStream(con.getInputStream());
            Log.i("HEADLINES_URL", "URL CONNECTED");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            messenger.send(message);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void readStream(InputStream in) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            headlines = "";
            while ((headlines = reader.readLine()) != null) {
                Log.i("SERVICE", "headlines data 1-> "+ headlines);

                //write received data to file
                HeadlinesManager m_file = HeadlinesManager.getInstance();

                m_file.writeHeadlinesToFile(this, filename, headlines);
            }
            Log.i("SERVICE", "headlines data 2-> "+ headlines);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
