package com.ianlin.loginsystem;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;



public class PendingList extends Fragment {

    private static final String TAG = PendingList.class.getSimpleName();
    public static final String ITEM = "SELECTED_ITEM_VALUE";
    private OnFragmentInteractionListener mListener;

    private List<String> items = new ArrayList<>();
    private ListView listView;
    private ArrayAdapter<String> itemsAdapter;
    private Button addButton;


    //private OnFragmentInteractionListener mListener;

    public PendingList() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pending_list, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    //
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(R.id.listView_notPurchased);
        SQLiteDataAdapter sqLiteDataAdapterNotPurchased = new SQLiteDataAdapter(getActivity().getApplicationContext());
        ArrayList<Item> itemList = sqLiteDataAdapterNotPurchased.getToDoItemData();
        ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(), R.layout.listview_layout,itemList,listView);
        listViewAdapter.addAll(itemList);
        listView.setAdapter(listViewAdapter);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}

