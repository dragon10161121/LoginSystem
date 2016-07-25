package com.ianlin.loginsystem;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class ListViewAdapter extends ArrayAdapter<Item> {
    private Context mcontext;
    private List<Item> mitems;
    private ListView mlistView;

    interface listener{
        public void click();
    }

    public ListViewAdapter(Context context, int resource, List<Item> array, ListView listView) {
        super(context, resource);
        mcontext = context;
        mitems = array;
        mlistView = listView;

    }

    @Override
    public void add(Item itemJava) {
        super.add(itemJava);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
    public Item getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater itemInflater = LayoutInflater.from(getContext());
        View customView = itemInflater.inflate(R.layout.listview_layout, parent, false);
        final Item item = getItem(position);
        TextView itemDetailText = (TextView) customView.findViewById(R.id.textView_item);
        itemDetailText.setText(item.getItemName() + " " + item.getQuantity());
        Button okButton = (Button) customView.findViewById(R.id.button_ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setting alert dialog
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        mcontext);

                // set title
                alertDialogBuilder.setTitle("Your Title");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Click yes to exit!")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, close
                                // current activity
                              //  MainActivity.this.finish();
                                SQLiteDataAdapter.updateItemData("" + item.getId(), item.getItemName(), item.getQuantity());
                                SQLiteDataAdapter sqLiteDataAdapter = new SQLiteDataAdapter(mcontext);
                                mitems = sqLiteDataAdapter.getToDoItemData();
                                notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });

        return customView;

    }

}
