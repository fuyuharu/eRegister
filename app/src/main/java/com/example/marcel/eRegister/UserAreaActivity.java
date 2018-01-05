package com.example.marcel.eRegister;

import android.app.ActivityManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class UserAreaActivity extends AppCompatActivity implements TimetableFragment.OnFragmentInteractionListener, GradesFragment.OnFragmentInteractionListener {

    FrameLayout frameLayout;
    ListView mDrawerList;
    String[] listArray = {"Timetable", "Grades", "Settings", "Log out"};
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;
    Spinner spinner;
    ActionBar actionBar;
    MenuItem menuItem;
    android.widget.Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    ActivityManager.TaskDescription taskDescription;
    String label = "eRegister";
    RecyclerView recyclerView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, new TimetableFragment());
        fragmentTransaction.commit();

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));

        setTitle(getResources().getText(R.string.drawerTimetable));

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fafafa")));

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.closeDrawers();
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawerOpen, R.string.drawerClose);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerSetUp();
    }

    /**
     * ANNOTATION: This is the view that holds your drawer, the "menu" in that view contains
     * the drawer items. You set up a new listener for those items being selected and in that
     * listener, we say what should happen when a certain item was selected.
     */
    private void drawerSetUp() {
        NavigationView mNavigationView = findViewById(R.id.navigation);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment;
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                switch (item.getItemId()) {
                    case R.id.nav_timetable:

                        fragment = new TimetableFragment();
                        fragmentTransaction.replace(R.id.content_frame, fragment);
                        setTitle(getResources().getText(R.string.drawerTimetable));
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        mDrawerLayout.closeDrawers();

                        break;

                    case R.id.nav_grades:

                        fragment = new GradesFragment();
                        fragmentTransaction.replace(R.id.content_frame, fragment);
                        setTitle(getResources().getText(R.string.drawerGrades));
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        mDrawerLayout.closeDrawers();

                        break;
                    case R.id.nav_settings:


                        mDrawerLayout.closeDrawers();

                        break;
                    case R.id.nav_logout:

                        Intent i = new Intent(UserAreaActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();

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
    public void onFragmentInteraction(Uri uri) {
        //ANNOTATION: Here you activity can communicate with the fragment... I guess
    }
}