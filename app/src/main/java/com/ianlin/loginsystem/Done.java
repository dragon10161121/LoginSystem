package com.ianlin.loginsystem;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Done extends android.app.Fragment {

    private TextView doneTextView;
    ListView doneListView;
    private OnFragmentInteractionListener mListener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_done, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        doneTextView = (TextView) view.findViewById(R.id.textView_done);
        doneListView = (ListView) view.findViewById(R.id.listView_purchased);
        SQLiteDataAdapter sqLiteDataAdapterPurchased = new SQLiteDataAdapter(getActivity().getApplicationContext());
        ArrayList<Item> itemList = sqLiteDataAdapterPurchased.getDoneItemData();
        DoneListViewAdapter listViewAdapter = new DoneListViewAdapter(getActivity().getApplicationContext(), R.layout.layout_done);
        listViewAdapter.addAll(itemList);
        doneListView.setAdapter(listViewAdapter);

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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
