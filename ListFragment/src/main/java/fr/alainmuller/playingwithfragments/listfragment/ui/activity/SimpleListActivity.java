package fr.alainmuller.playingwithfragments.listfragment.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import fr.alainmuller.playingwithfragments.listfragment.R;


public class SimpleListActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_simple);
    }

}
