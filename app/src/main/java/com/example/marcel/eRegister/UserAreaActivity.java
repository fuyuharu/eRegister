package com.example.marcel.eRegister;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.example.marcel.eRegister.fragments.TimetableFragment;


public class UserAreaActivity extends AppCompatActivity implements TimetableFragment.OnFragmentInteractionListener {

    protected FrameLayout frameLayout;
    protected ListView mDrawerList;
    protected String[] listArray = { "Timetable", "Grades", "Settings", "Log out"};
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;
    Spinner spinner;
    ActionBar actionBar;
    MenuItem menuItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);


        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#eb3349")));

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        drawerSetUp();
    }

    /**ANNOTATION: This is the view that holds your drawer, the "menu" in that view contains
     * the drawer items. You set up a new listener for those items being selected and in that
     * listener, we say what should happen when a certain item was selected.
     */
    private void drawerSetUp() {
        NavigationView mNavigationView = findViewById(R.id.navigation);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fagment;
                FragmentTransaction transFag = getFragmentManager().beginTransaction();

                switch (item.getItemId()) {
                    case R.id.nav_grades:

                        break;
                    case R.id.nav_logout:

                        break;
                    case R.id.nav_settings:

                        break;
                    case R.id.nav_timetable:

                        fagment = new TimetableFragment();
                        transFag.replace(R.id.content_frame,fagment);
                        transFag.addToBackStack(null);
                        transFag.commit();

                        //ANNOTATION: This is how you would do it with an activity
                        //Intent i = new Intent(UserAreaActivity.this, TimetableActivity.class);
                        //startActivity(i);
                        break;
                    default:
                        break;
                }

                /**ANNOTATION:
                 * If you want to clean the code a bit later on, make sure that a fragment is created
                 * in the switch/case "default" statement, then take the code that is
                 *
                 transFag.replace(R.id.content_frame,fagment);
                 transFag.addToBackStack(null);
                 transFag.commit();
                 *
                 * out of the individual case and just work with the variables after the switch/case
                 * statement. The fragment creation is the only thing you'd need to handle in that.
                 */
                return (true);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_spinner, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_list_item_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //ANNOTATION: Here you activity can communicate with the fragment... I guess
    }
}