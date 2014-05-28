package fr.alainmuller.playingwithfragments.orientationfragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    public static final String LOG_TAG = "MainActivity";

    public static final String TAG_FIRST = "first";
    public static final String TAG_SECOND = "second";

    private static final String STATE_KEY = "state";

    FragmentManager mManager;
    FirstFragment mFirstFragment;
    SecondFragment mSecondFragment;

    boolean isFirstDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "¤ onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mManager = getSupportFragmentManager();

        // On restaure les fragments s'il existaient déjà, sinon, on les crée
        mFirstFragment = (mManager.findFragmentByTag(TAG_FIRST) != null ? (FirstFragment) mManager.findFragmentByTag(TAG_FIRST) : new FirstFragment());
        mSecondFragment = (mManager.findFragmentByTag(TAG_SECOND) != null ? (SecondFragment) mManager.findFragmentByTag(TAG_SECOND) : new SecondFragment());

        // On teste le savedInstanceState pour détecter un chargement initial ou un changement d'orientation
        if (savedInstanceState == null) {
            Log.d(LOG_TAG, "¤ Instanciation : First");

            // On insère le fragment FIRST dans layout
            FragmentTransaction transaction = mManager.beginTransaction();
            transaction.replace(R.id.fl_main_container, mFirstFragment, TAG_FIRST);
            transaction.setTransition(android.R.anim.fade_in);
            transaction.commit();

            isFirstDisplayed = true;
        } else {
            Log.d(LOG_TAG, "¤ Chgt Orientation");
            // Cas d'un changement d'orientation, on restaure l'état de l'activity
            isFirstDisplayed = savedInstanceState.getBoolean(STATE_KEY);

            Log.d(LOG_TAG, "¤ Fragment à afficher : " + (isFirstDisplayed ? "FIRST" : "SECOND"));

            // On insère le fragment dans layout
            FragmentTransaction transaction = mManager.beginTransaction();
            transaction.replace(R.id.fl_main_container, isFirstDisplayed ? mFirstFragment : mSecondFragment, isFirstDisplayed ? TAG_FIRST : TAG_SECOND);
            transaction.setTransition(android.R.anim.fade_in);
            transaction.commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Sauvegarde de l'état de l'activity (fragment affiché) lors du changement d'orientation
        outState.putBoolean(STATE_KEY, isFirstDisplayed);
        super.onSaveInstanceState(outState);
    }

    // Changement du fragment actif dans la MainActivity sur clic bouton Switch
    public void switchFragment(View view) {
        if (isFirstDisplayed) {
            Log.d(LOG_TAG, "On switch vers le 2nd Fragment");
            FragmentTransaction transaction = mManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.slide_in_left, android.R.anim.fade_out);
            transaction.replace(R.id.fl_main_container, mSecondFragment, TAG_SECOND);
            transaction.commit();
        } else {
            Log.d(LOG_TAG, "On switch vers le 1er Fragment");
            FragmentTransaction transaction = mManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.slide_in_right, android.R.anim.fade_out);
            transaction.replace(R.id.fl_main_container, mFirstFragment, TAG_FIRST);
            transaction.commit();
        }

        // Changement d'état
        isFirstDisplayed = !isFirstDisplayed;
    }
}
