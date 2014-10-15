package fragment;

import android.app.Activity;
import android.app.Fragment;

import java.util.ArrayList;

import listdata.Contact;

/**
 * Created by John on 10/15/2014.
 */
public class MainFragment extends Fragment{
    private final String TAG = "MAINFRAGMENT";

    private ContactListener mListener;
    private ArrayList<Contact> mContactList;

    public interface ContactListener{
        public void viewContact(int position);
        public void deleteContact(int position);
        public ArrayList<Contact> getContacts();
    }

    public MainFragment(){};

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        if (activity instanceof ContactListener){
            mListener = (ContactListener) activity;
        }else {
            throw new IllegalArgumentException("Containing activity must implement DetailListener interface");
        }
    }
}
