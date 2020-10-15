package com.food.delivery.eleven_am;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.food.delivery.eleven_am.fragments.FavouriteFragment;
import com.food.delivery.eleven_am.fragments.HomeFragment;
import com.gauravk.bubblenavigation.BubbleNavigationConstraintView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.mancj.materialsearchbar.SimpleOnSearchActionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity implements MaterialSearchBar.OnSearchActionListener {

    ImageView filter, location;
    private List<String> lastSearches;
    private MaterialSearchBar searchBar;
    TextView locationText;
    BubbleNavigationConstraintView bottomNavigation;
    int prevPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        filter = findViewById(R.id.filter);
        location = findViewById(R.id.location);
        locationText = findViewById(R.id.location_text);
        bottomNavigation = (BubbleNavigationConstraintView)findViewById(R.id.bottom_nav);

        loadFragment(new HomeFragment());
        bottomNavigation.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {

                if(prevPosition!=position)
                {
                    prevPosition = position;
                    switch (position)
                    {
                        case 0:
                            loadFragment(new HomeFragment());
                            break;

                        case 1:
                            loadFragment(new FavouriteFragment());
                            break;

                        case 2:
                            loadFragment(new HomeFragment());
                            break;

                        case 3:
                            loadFragment(new FavouriteFragment());
                            break;

                    }
                }
            }
        });
        searchBar = (MaterialSearchBar)findViewById(R.id.search_bar);
        searchBar.setOnSearchActionListener(this);
        lastSearches =  new ArrayList<String>();
        lastSearches.add("sudhanshu");
        searchBar.setLastSuggestions(lastSearches);

        searchBar.setSuggestionsEnabled(false);
    }

    @Override
    public void onSearchStateChanged(boolean enabled) {
        if(enabled)
        {

            location.setVisibility(View.GONE);
            locationText.setVisibility(View.GONE);
        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    location.setVisibility(View.VISIBLE);
                    locationText.setVisibility(View.VISIBLE);
                }
            },150);

        }
    }

    @Override
    public void onSearchConfirmed(CharSequence text) {

    }

    @Override
    public void onButtonClicked(int buttonCode) {

    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}