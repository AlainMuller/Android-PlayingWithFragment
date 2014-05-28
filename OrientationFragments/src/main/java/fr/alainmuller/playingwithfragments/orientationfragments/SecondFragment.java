package fr.alainmuller.playingwithfragments.orientationfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    public static final String LOG_TAG = "Orientation > SecondFragment";

    // On déclare une interface pour communiquer avec l'Activity
    public interface OnSecondFragmentListener {
        public void onPauseBackup(String name);
    }

    // On utilise l'Activity comme listener
    private OnSecondFragmentListener mListener;

    private String mName;
    private EditText mEtName;

    public SecondFragment() {
        // Required empty public constructor
        Log.d(LOG_TAG, " >> constructor!");
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, " >> onCreateView");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        mEtName = (EditText) view.findViewById(R.id.et_second_name);
        mEtName.setText(mName);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d(LOG_TAG, " >> onAttach");
        super.onAttach(activity);
        // On attache l'activity en tant que Listener
        mListener = (OnSecondFragmentListener) activity;

        // On récupère le nom depuis l'Activity
        setName(((MainActivity) activity).getName());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, " >> onCreate");
        super.onCreate(savedInstanceState);
        // Retain this fragment across configuration changes.
        setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(LOG_TAG, " >> onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        Log.d(LOG_TAG, " >> onViewStateRestored");
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(LOG_TAG, " >> onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(LOG_TAG, " >> onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(LOG_TAG, " >> onPause");
        super.onPause();

        Log.d(LOG_TAG, " >> On sauvegarde le nom : '" + mEtName.getText().toString() + "'");
        // On communique à l'Activity le nom renseigné dans le fragment avant détachement
        mListener.onPauseBackup(mEtName != null ? mEtName.getText().toString() : "");
    }

    @Override
    public void onStop() {
        Log.d(LOG_TAG, " >> onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(LOG_TAG, " >> onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(LOG_TAG, " >> onDetach");
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        Log.d(LOG_TAG, " >> onDestroyView");
        super.onDestroyView();
    }

}
