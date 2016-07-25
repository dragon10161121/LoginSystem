package com.ianlin.loginsystem;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class AfterLogin extends Activity implements PendingList.OnFragmentInteractionListener, Done.OnFragmentInteractionListener, AddItem.OnFragmentInteractionListener {
    private Button doneButton, addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        final FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        final PendingList fragmentNotPurchased = new PendingList();
        if (savedInstanceState == null) {
            fragmentTransaction.add(R.id.fragment_container, fragmentNotPurchased);
            fragmentTransaction.commit();
        }

        //reference to buttons
        doneButton = (Button) findViewById(R.id.done_button);
        addButton = (Button) findViewById(R.id.add_button);


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.fragment_container, new Done()).commit();

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction3 = getFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.fragment_container, new AddItem()).commit();

            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
