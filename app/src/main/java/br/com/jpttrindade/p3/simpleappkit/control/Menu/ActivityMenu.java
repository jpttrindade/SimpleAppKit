package br.com.jpttrindade.p3.simpleappkit.control.Menu;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

import br.com.jpttrindade.p3.simpleappkit.R;
import br.com.jpttrindade.p3.simpleappkit.model.Facade;


public class ActivityMenu extends FragmentActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks, FragmentMenu.OnFragmentInteractionListener{

    private NavigationDrawerFragment mNavigationDrawerFragment;

    private CharSequence mTitle;
    Fragment frag;

    private Facade facade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_menu);

        facade = (Facade) getApplication();
        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));

        frag = getSupportFragmentManager().findFragmentByTag(FragmentMenu.TAG);

        if(frag == null){
            frag = FragmentMenu.newInstance();
        }

        getSupportFragmentManager().beginTransaction().add(R.id.container, frag ).commit();

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        /*// update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();*/

        //TODO: implementar esse switch com as opções do menu.
        switch (position){
            case 1:

            case 2:


        }

    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
               // mTitle = getString(R.string.title_section1);
                break;
            case 2:
              //  mTitle = getString(R.string.title_section2);
                break;
            case 3:
               // mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
       // actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.kit, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.d("DEBUG", "settings");
            return true;
        }else if (id == R.id.refresh){
            Log.d("DEBUG", "refresh");
            facade.sendBroadcastScanFunctions();
            ////TODO: precisa notificar o LOADER da atualização.
            return false;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(String action) {

        Log.d("DEBUG", "Action = "+action);
        //startar a funcao da aplicacao correspondente.
        Intent i = new Intent(action);

        startActivity(i);

    }


}
