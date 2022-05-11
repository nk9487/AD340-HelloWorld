package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;


public class Welcome extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navDrawer;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawer = findViewById(R.id.drawer_layout);
        //drawerToggle = setupDrawerToggle();
        navDrawer = findViewById(R.id.navDrawer);


        //profile data
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ProfileData profileData = null;
        if (bundle != null){
            if(bundle.containsKey(Constants.USER_NAME_KEY) && 
                        bundle.containsKey(Constants.USER_AGE_KEY) && 
                            bundle.containsKey(Constants.USER_OCCUPATION_KEY) &&
                                bundle.containsKey(Constants.USER_DESCRIPTION_KEY) ){
                // TODO: 5/10/2022  check age  
                profileData = new ProfileData(  bundle.getString(Constants.USER_NAME_KEY),
                             (Integer.parseInt(bundle.getString(Constants.USER_AGE_KEY))),
                                                bundle.getString(Constants.USER_AGE_KEY),
                                                bundle.getString(Constants.USER_AGE_KEY));          
            }
        }
        setupDrawerContent(navDrawer, profileData);
//        ProfileFragment profileFragment = new ProfileFragment();
//
//        profileFragment.setProfileData(profileData);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//
//        fragmentManager.beginTransaction().replace(R.id.content, profileFragment).commit();
//        setTitle(getString(R.string.profile));
    }






    private void setupDrawerContent(NavigationView navigationView, ProfileData profileData) {
        navigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    selectDrawerItem(menuItem, profileData);
                    return true;
                });
    }

    public void selectDrawerItem(MenuItem menuItem, ProfileData profileData) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.profile_menu_item:
                ProfileFragment profileFragment = new ProfileFragment();
                profileFragment.setProfileData(profileData);
                fragment = profileFragment;
                break;
            case R.id.matches_menu_item:
                fragment = new MatchesFragment();
                break;
            case R.id.settings_menu_item:
                fragment = new SettingFragment();
                break;
            default:
                ProfileFragment defaultProfileFragment = new ProfileFragment();
                defaultProfileFragment.setProfileData(profileData);
                fragment = defaultProfileFragment;

        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawer.closeDrawers();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()){
          case android.R.id.home:
              drawer.openDrawer(GravityCompat.START);
              return true;
      }
      return    super.onOptionsItemSelected(item);
    }

    private void onBackClick(){
        finish();
    }

}
