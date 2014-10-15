package fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.bbgatestudios.week3.R;

import java.util.ArrayList;

import listdata.Contact;
import listdata.ContactAdapter;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        ListView contactListView = (ListView) getView().findViewById(R.id.contactlist);
        ContactAdapter contactAdapter = new ContactAdapter(getActivity(), mListener.getContacts());
        contactListView.setAdapter(contactAdapter);

        contactListView.setOnItemClickListener((parent, view, position, id) -> {
            mListener.viewContact(position);
        });

        contactListView.setOnItemLongClickListener((parent, view, position, id) -> {
            mListener.deleteContact(position);
            return true;
        });
    }

    public void updateListData(){
        ListView contactList = (ListView) getView().findViewById(R.id.contactlist);
        BaseAdapter contactAdapter = (BaseAdapter) contactList.getAdapter();
        contactAdapter.notifyDataSetChanged();
    }
}
