package fr.alainmuller.playingwithfragments.dynamicfragment.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import fr.alainmuller.playingwithfragments.dynamicfragment.R;
import fr.alainmuller.playingwithfragments.dynamicfragment.ui.fragment.Dynamic1Fragment;
import fr.alainmuller.playingwithfragments.dynamicfragment.ui.fragment.Dynamic2Fragment;


public class DynamicActivity extends FragmentActivity {
    private static final String KEY_FRAGMENT = "fragment_save";

    private String mFragment;
    // On instancie les fragments ici pour des raisons de simplicité, mais ça peut devenir plus
    // compliqué si on a besoin de paramètres particuliers ou si on veut les instancier à la volée
    private final Dynamic1Fragment mDynamic1Fragment = new Dynamic1Fragment();
    private final Dynamic2Fragment mDynamic2Fragment = new Dynamic2Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // On va charger un framelayout (vide) dans lequel on ajoutera à la volée les fragments
        setContentView(R.layout.activity_fragment_dynamic);

        // Gestion du changement d'orientation : on conserve en mémoire le bundle pour recharger le bon fragment
        if (savedInstanceState != null) {
            mFragment = savedInstanceState.getString(KEY_FRAGMENT);
        } else {
            mFragment = getIntent().getStringExtra(KEY_FRAGMENT);
        }

        if (mFragment != null) {
            if (mFragment.equals(Dynamic1Fragment.class.getSimpleName())) {
                showFragment(mDynamic1Fragment);
            } else if (mFragment.equals(Dynamic2Fragment.class.getSimpleName())) {
                showFragment(mDynamic2Fragment);
            } else {
                Toast.makeText(this, "Nom de fragment non pris en charge '" + mFragment + "'", Toast.LENGTH_SHORT).show();
            }
        } else {
            showFragment(mDynamic1Fragment);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Sauvegarde du Fragment affiché
        outState.putString(KEY_FRAGMENT, mFragment != null ? mFragment : "");
        super.onSaveInstanceState(outState);
    }

    /**
     * Affichage d'un fragment donné dans l'activity
     *
     * @param fragment
     */
    private void showFragment(final Fragment fragment) {
        if (fragment == null)
            return;

        // Mise à jour du Fragment affiché
        mFragment = fragment.getClass().getSimpleName();

        // Début d'une transaction depuis le FragmentManager pour changer à la volée les fragments
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        // On peut également préciser les animation d'entrée/sortie des fragments
        // FragmentTransaction.setCustomAnimation(animation de l'entrant, animation du sortant)
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        // On remplace l'ancien élément (pointé par son id) par le fragment
        transaction.replace(R.id.fl_fragment_dynamic, fragment);
        // On peut pousser la valeur unll dans la BackStack pour forcer en retour arrière à recharger
        // l'ancien fragment quand l'utilisateur appuie sur le bouton retour.
        //transaction.addToBackStack(null);

        // On commite la transaction pour appliquer les changements
        transaction.commit();
    }

    // Gestion du clic sur les boutons des deux fragments

    public void goToFragment1(View v) {
        showFragment(mDynamic1Fragment);
    }

    public void goToFragment2(View v) {
        showFragment(mDynamic2Fragment);
    }

}
