package fr.alainmuller.playingwithfragments.listfragment.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import fr.alainmuller.playingwithfragments.listfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleListViewFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listview, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // On va charger une liste de String bidon pour initialiser le ListFragment
        final String[] items = getResources().getStringArray(R.array.list_examples);
        final ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);

        setListAdapter(aa);
    }
}
