package fr.alainmuller.playingwithfragments.dynamicfragment.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.alainmuller.playingwithfragments.dynamicfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Dynamic2Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // On désérialise le layout du Fragment
        return inflater.inflate(R.layout.fragment_dynamic2, container, false);
    }


}
