package fr.alainmuller.playingwithfragments.orientationfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    public static final String LOG_TAG = "Orientation > FirstFragment";

    public FirstFragment() {
        // Required empty public constructor
        Log.d(LOG_TAG, " > constructor!");
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d(LOG_TAG, " > onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, " > onCreate");
        super.onCreate(savedInstanceState);
        // Retain this fragment across configuration changes.
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, " > onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(LOG_TAG, " > onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        Log.d(LOG_TAG, " > onViewStateRestored");
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(LOG_TAG, " > onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(LOG_TAG, " > onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(LOG_TAG, " > onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(LOG_TAG, " > onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(LOG_TAG, " > onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(LOG_TAG, " > onDetach");
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        Log.d(LOG_TAG, " > onDestroyView");
        super.onDestroyView();
    }
}
