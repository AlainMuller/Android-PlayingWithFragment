package fr.alainmuller.playingwithfragments.fixedfragment.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.alainmuller.playingwithfragments.fixedfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FixedFragment extends Fragment {

    // On surcharge la méthode onCreateView de la classe Fragment afin de pouvoir "inflater"
    // le layout XML lors de l'initialisation du Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fixed, container, false);

    }


}
