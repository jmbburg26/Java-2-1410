package com.bbgatestudios.apitest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends Activity {

    static ListView listview;
    static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        isOnline();

        setContentView(R.layout.activity_main);
        context = this;

        listview = (ListView)this.findViewById(R.id.list);
        View listHeader = this.getLayoutInflater().inflate(R.layout.listview_header, null);
        listview.addHeaderView(listHeader);

        HeadlinesManager headlinesMgr = new HeadlinesManager();
        headlinesMgr.execute("football");
    }


    public static void displayData(ArrayList<HashMap<String, String>> myList)
    {

        SimpleAdapter adapter = new SimpleAdapter(context, myList, R.layout.list_rows, new String[] {"headline", "description", "published"}, new int[] {R.id.headline, R.id.description, R.id.published});
        listview.setAdapter(adapter);

    }


    protected boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if(netInfo != null && netInfo.isConnectedOrConnecting()){
            Toast.makeText(this, "You're Online.", Toast.LENGTH_LONG).show();
            return true;
        }else{
            Toast.makeText(this, "Network Unavailable.", Toast.LENGTH_LONG).show();
            return false;
        }
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

    public class HeadlinesManager extends AsyncTask<String, Void, String> {
        public HeadlinesManager m_instance = null;
        public String headlinesFile = "headlines.txt";

        //File manager constructor
        private HeadlinesManager() {

        }

//		public HeadlinesManager getInstance(){
//			if (m_instance == null) {
//				m_instance = new HeadlinesManager();
//			}
//			return m_instance;
//		}

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

            String headlines = "";
            StringBuffer buffer = null;
            HttpURLConnection con;
            URL newUrl = null;

            try {
                newUrl = new URL("http://api.espn.com/v1/now?limit=15&apikey=e3qvjg8m43xx4xmcyqperf3a");
                con = (HttpURLConnection) newUrl.openConnection();

////				File file = new File("headlines");
////				FileInputStream fin = new FileInputStream(file);
////				InputStreamReader inReader = new InputStreamReader(fin.);
//				BufferedReader reader = new BufferedReader(inReader);

                BufferedReader reader = null;
                reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                // Reading data from our file using the reader
                // and storing it our string buffer.
                buffer = new StringBuffer();
                String text = null;
                // Make sure a line of text is available to be read.
                while((text = reader.readLine()) != null) {
                    buffer.append(text + "\n");
                }
                // Close the reader and underlying stream.
                reader.close();


//				BufferedReader reader = null;
//				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//
//				while ((headlines = reader.readLine()) != null) {
//					Log.i("SERVICE", "headlines data 1-> "+ headlines);
//
//				}
//
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //return headlines;
            // Convert the buffer to a string.
            return buffer.toString();

        }

        @Override
        protected void onPostExecute(String result) {
            ArrayList<HashMap<String, String>> myList = new ArrayList<HashMap<String, String>>();
            JSONObject news = null;
            JSONArray feed = null;

            try{
                news = new JSONObject(result);
                feed = news.getJSONArray("feed");
                int feedSize = feed.length();
                //textMessage.setText("There are" + String.valueOf(feedSize) + "headlines.");

                for (int i = 0; i < feedSize; i++)
                {
                    JSONObject newsObject = feed.getJSONObject(i);

                    String headline = newsObject.getString("headline");
                    String description = newsObject.getString("description");
                    String published = newsObject.getString("published");

                    HashMap<String, String> newsMap = new HashMap<String, String>();
                    newsMap.put("headline", headline);
                    newsMap.put("description", description);
                    newsMap.put("published", published);

                    myList.add(newsMap);
                }


                displayData(myList);

            }catch (JSONException e){
                e.printStackTrace();
            }

        }
    }
}
