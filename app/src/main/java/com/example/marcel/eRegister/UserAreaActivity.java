package com.example.marcel.eRegister;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.CalendarContract;
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
import android.widget.Toolbar;

import com.example.marcel.ejournal.TimetableFragment;


public class UserAreaActivity extends AppCompatActivity implements TimetableFragment.OnFragmentInteractionListener{

    protected FrameLayout frameLayout;
    protected ListView mDrawerList;
    protected String[] listArray = { "Timetable", "Grades", "Settings", "Log out"};
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;
    Spinner spinner;
    ActionBar actionBar;
    MenuItem menuItem;
    android.widget.Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    ActivityManager.TaskDescription taskDescription;
    String label = "eRegister";

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

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.drawerOpen,R.string.drawerClose);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

                Fragment fragment;
                FragmentTransaction transFrag = getFragmentManager().beginTransaction();

                switch (item.getItemId()) {
                    case R.id.nav_grades:

                        break;
                    case R.id.nav_logout:

                        break;
                    case R.id.nav_settings:

                        break;
                    case R.id.nav_timetable:
                        fragment = new TimetableFragment();
                        transFrag.replace(R.id.content_frame,fragment);
                        transFrag.addToBackStack(null);
                        transFrag.commit();

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
                 transFrag.replace(R.id.content_frame,fragment);
                 transFrag.addToBackStack(null);
                 transFrag.commit();
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
    public void onFragmentInteraction(Uri uri) {
        //ANNOTATION: Here you activity can communicate with the fragment... I guess
    }
}